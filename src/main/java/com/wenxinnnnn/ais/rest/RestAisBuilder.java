package com.wenxinnnnn.ais.rest;

import com.wenxinnnnn.ais.impl.AbstractAisBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenqing
 * @date 2018/7/12
 */
public class RestAisBuilder extends AbstractAisBuilder<HttpServletRequest> {

    @Override
    public String translate(HttpServletRequest request) {
        String data = Translator.httpServletRequestToString(request);
        return data == null ?"": data;
    }
}
