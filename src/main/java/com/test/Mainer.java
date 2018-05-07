package com.test;

import com.util.WebServiceHelper;

/**
 * Created by liuhongbing on 2018/3/22.
 */
public class Mainer {
    public static void main(String[] args) {
        try {
            String out = WebServiceHelper.invokeWebService("http://localhost:8080/ws/HelloWorld?wsdl", "say", "在");
            System.out.println(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
