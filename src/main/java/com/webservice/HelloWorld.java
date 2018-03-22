package com.webservice;

import javax.jws.WebService;

/**
 * Created by liuhongbing on 2018/3/22.
 */
@WebService
public interface HelloWorld {
    public String say(String str);
}
