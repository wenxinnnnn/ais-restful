package com.wenxinnnnn.ais.rest;

import com.wenxinnnnn.ais.NonceHandler;
import com.wenxinnnnn.ais.impl.AbstractAisParser;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenqing
 * @date 2018/7/12
 */
public class RestAisParser extends AbstractAisParser<HttpServletRequest> {

    public RestAisParser() {
    }

    public RestAisParser(NonceHandler nonceHandler) {
        super(nonceHandler);
    }

    public RestAisParser(long effective, NonceHandler nonceHandler) {
        super(effective, nonceHandler);
    }

    @Override
    public String translate(HttpServletRequest request) {
        String data = Translator.httpServletRequestToString(request);
        return data == null ?"": data;
    }

}
