package com.test;

import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

public class XmlHelper extends StringConverter {
	
	public static boolean hasCData = Boolean.TRUE;
	public static boolean HasDeclaration = Boolean.TRUE;
	public static String Encoding = "UTF-8";
	private static final String XML_TAG = "<?xml version='1.0' encoding='UTF-8'?>";
	private static XStream xstream = null;
	static {
		xstream = new XStream(new DomDriver("utf-8") {
			@Override
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out, getNameCoder()) {
					protected String PREFIX_CDATA = "<![CDATA[";
					protected String SUFFIX_CDATA = "]]>";

					@Override
					protected void writeText(QuickWriter writer, String text) {
						if (text.startsWith(this.PREFIX_CDATA) && text.endsWith(this.SUFFIX_CDATA)) {
							writer.write(text);
						} else {
							super.writeText(writer, text);
						}
					}

					@Override
					public String encodeNode(String name) {
						return name;
					}
				};
			}
		});
		xstream.ignoreUnknownElements();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
	}


	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xml, Class<T> clazz) {
		xstream.processAnnotations(clazz);
		xstream.processAnnotations(getInnerClasses(clazz));
		T object = (T) xstream.fromXML(xml);
		return object;
	}


	public static <T> String toXml(T object, Class<T> clazz) {
		xstream.processAnnotations(clazz);
		xstream.processAnnotations(getInnerClasses(clazz));
		if (XmlHelper.HasDeclaration) {
			return XML_TAG + xstream.toXML(object);
		} else {
			return xstream.toXML(object);
		}
	}


	@SuppressWarnings("unchecked")
	public static <T> T fromXml(InputStream is, Class<T> clazz) {
		xstream.processAnnotations(clazz);
		xstream.processAnnotations(getInnerClasses(clazz));
		T object = (T) xstream.fromXML(is);
		return object;
	}


	private static Class<?>[] getInnerClasses(Class<?> clz) {
		Class<?>[] innerClasses = clz.getClasses();
		if (innerClasses == null) {
			return null;
		}

		List<Class<?>> result = new ArrayList<Class<?>>();
		result.addAll(Arrays.asList(innerClasses));
		for (Class<?> inner : innerClasses) {
			Class<?>[] innerClz = getInnerClasses(inner);
			if (innerClz == null) {
				continue;
			}
			result.addAll(Arrays.asList(innerClz));
		}
		return result.toArray(new Class<?>[0]);
	}


	public static Document strToDocument(String xml) throws DocumentException {
		return DocumentHelper.parseText(xml);
	}


	public static JSONObject documentToJSONObject(String xml) throws DocumentException {
		return elementToJSONObject(strToDocument(xml).getRootElement());
	}


	public static JSONObject elementToJSONObject(Element node) {
		JSONObject result = new JSONObject();
		List<Attribute> listAttr = node.attributes();
		for (Attribute attr : listAttr) {
			result.put(attr.getName(), attr.getValue());
		}
		List<Element> listElement = node.elements();
		if (!listElement.isEmpty()) {
			for (Element e : listElement) {
				if (e.attributes().isEmpty() && e.elements().isEmpty())
					result.put(e.getName(), e.getTextTrim());
				else {
					if (!result.containsKey(e.getName()))
						result.put(e.getName(), new JSONArray());
					((JSONArray) result.get(e.getName())).add(elementToJSONObject(e));
				}
			}
		}
		return result;
	}

	@Override
	public String toString(Object obj) {
		if (XmlHelper.hasCData) {
			return "<![CDATA[" + super.toString(obj) + "]]>";
		} else {
			return super.toString(obj);
		}
	}

}
