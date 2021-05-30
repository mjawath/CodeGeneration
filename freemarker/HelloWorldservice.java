package com.techstart.codegen.freemarker;

import javax.jws.*;

@WebService()
public class HelloWorldservice {

    @WebMethod()
    public String hello(String name) {
        String res = "Hi" + name;
        System.out.println(res);
        return res;
    }

}