package com.xjtushilei.logagent4networkcollege.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjtushilei.logagent4networkcollege.entity.VisitLog;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author scriptshi
 * 2018/5/24
 */
public class IpUtil {

    private static OkHttpClient okHttpClient = new OkHttpClient();


    public static void setIPinfo(VisitLog visitLog) {


        try {
            Request request = new Request.Builder()
                    .url("http://ip.taobao.com/service/getIpInfo2.php?ip=" + visitLog.getIp())
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String bodyString = response.body().string();
            JSONObject data = JSON.parseObject(bodyString).getJSONObject("data");
            visitLog.setCity(data.getString("city"));
            visitLog.setCountry(data.getString("country"));
            visitLog.setProvince(data.getString("region"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }

    public static void main(String[] args) {
        String ip = "123.206.50.198";
        try {
            Request request = new Request.Builder()
                    .url("http://ip.taobao.com/service/getIpInfo2.php?ip=" + ip)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String bodyString = response.body().string();
            JSONObject data = JSON.parseObject(bodyString).getJSONObject("data");
            System.out.println(data.getString("city"));
            System.out.println(data.getString("country"));
            System.out.println(data.getString("region"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}