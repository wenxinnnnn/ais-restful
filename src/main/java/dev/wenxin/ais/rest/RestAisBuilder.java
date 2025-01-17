package dev.wenxin.ais.rest;

import dev.wenxin.ais.impl.AbstractAisBuilder;

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
