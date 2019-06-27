package com.webservice.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface FuncInterface {

    @WebMethod
    String saySomething(String text);

}
