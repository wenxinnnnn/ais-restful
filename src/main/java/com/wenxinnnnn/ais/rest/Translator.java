package com.wenxinnnnn.ais.rest;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author chenqing
 * @date 2018/7/12
 */
public class Translator {

    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_PUT = "PUT";
    private static final String CONTENT_TYPE = "application/json";

    public static String httpServletRequestToString(HttpServletRequest request) {
        String method = request.getMethod().toUpperCase();
        if (METHOD_GET.equalsIgnoreCase(method)) {
            return Translator.doGetParam(request);
        } else if (METHOD_POST.equalsIgnoreCase(method)) {
            return Translator.doPostParam(request);
        } else if (METHOD_PUT.equalsIgnoreCase(method)) {
            return Translator.doPutParam(request);
        } else if (METHOD_DELETE.equalsIgnoreCase(method)) {
            return Translator.doDeleteParam(request);
        } else {
            return "";
        }
    }

    private static String doPostParam(HttpServletRequest request) {
        if (!CONTENT_TYPE.equals(request.getContentType())) {
            return null;
        }
        try (InputStream is = request.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"))) {
            StringBuffer sb = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            if (sb.toString().length() > 0) {
                Map parameterMap = JSON.parseObject(sb.toString());
                StringBuffer param = new StringBuffer();
                parameterMap.forEach((k, v) -> {
                    if (param.length() > 0) {
                        param.append("&");
                    }
                    param.append(k).append("=").append(JSON.toJSONString(v));
                });
                String data = METHOD_POST + " " + request.getServletPath() + " " + param.toString();
                return data;
            } else {
                String data = METHOD_POST + " " + request.getServletPath();
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String doPutParam(HttpServletRequest request) {
        if (!CONTENT_TYPE.equals(request.getContentType())) {
            return null;
        }
        try (InputStream is = request.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"))) {
            StringBuffer sb = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            if (sb.toString().length() > 0) {
                Map parameterMap = JSON.parseObject(sb.toString());
                StringBuffer param = new StringBuffer();
                parameterMap.forEach((k, v) -> {
                    if (param.length() > 0) {
                        param.append("&");
                    }
                    param.append(k).append("=").append(JSON.toJSONString(v));
                });
                String data = METHOD_PUT + " " + request.getServletPath() + " " + param.toString();
                return data;
            } else {
                String data = METHOD_PUT + " " + request.getServletPath();
                return data;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String doGetParam(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuffer param = new StringBuffer();
        parameterMap.forEach((k, v) -> {
            if (param.length() > 0) {
                param.append("&");
            }
            param.append(k).append("=");
            if (v.length == 1) {
                param.append(v[0]);
            } else {

                param.append(JSON.toJSONString(v));
            }
        });
        String data;
        if (param.toString().length() == 0) {
            data = METHOD_GET + " " + request.getServletPath();
        } else {
            data = METHOD_GET + " " + request.getServletPath() + " " + param.toString();
        }
        return data;
    }

    private static String doDeleteParam(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuffer param = new StringBuffer();
        parameterMap.forEach((k, v) -> {
            if (param.length() > 0) {
                param.append("&");
            }
            param.append(k).append("=");
            if (v.length == 1) {
                param.append(v[0]);
            } else {

                param.append(JSON.toJSONString(v));
            }
        });

        String data;
        if (param.toString().length() == 0) {
            data = METHOD_DELETE + " " + request.getServletPath();
        } else {
            data = METHOD_DELETE + " " + request.getServletPath() + " " + param.toString();
        }
        return data;
    }
}
