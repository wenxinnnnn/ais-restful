package com.wenxinnnnn.ais.rest;

import com.wenxinnnnn.ais.AisBuilder;
import com.wenxinnnnn.ais.AisParser;
import com.wenxinnnnn.ais.NonceHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenqing
 * @date 2018/7/12
 *
 */
public final class AisRestEntry {

    public static AisParser<HttpServletRequest> parser() {
        return new RestAisParser();
    }

    public static AisParser<HttpServletRequest> parser(NonceHandler nonceHandler) {
        return new RestAisParser(nonceHandler);
    }

    public static AisParser<HttpServletRequest> parser(long effective, NonceHandler nonceHandler) {
        return new RestAisParser(effective, nonceHandler);
    }

    public static AisBuilder<HttpServletRequest> builder() {
        return new RestAisBuilder();
    }

}
