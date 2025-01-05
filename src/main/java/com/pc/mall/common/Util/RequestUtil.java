package com.pc.mall.common.Util;

import jakarta.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RequestUtil {
    public static String getRequestIp(HttpServletRequest request) {
        // lấy ip address từ client khi truy cập qua api
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-client-ip");

        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-Ip");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getLocalAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
                ipAddress = inetAddress.getHostAddress();

            }
        }
        if(ipAddress.length()>15&& ipAddress!=null){
            if(ipAddress.indexOf(",")>0){
                ipAddress =ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return  ipAddress;
    }}