package com.webservice;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * Created by liuhongbing on 2018/3/22.
 */
@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld {

    public String say(String str) {
        return "Hello "+str;
    }
}
