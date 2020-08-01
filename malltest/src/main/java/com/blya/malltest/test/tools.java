package com.blya.malltest.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description
 * @Author Date 2020/7/17 16:53
 **/
public class tools {


    public static void cl3() throws IOException {
        // 输入服务网址
        HttpClient client = new HttpClient();
        // HttpClient client = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
        // GetMethod
        PostMethod post = new PostMethod("http://211.161.193.122/ZBTest/bailservice.asmx");
        // 设置参数
        post.setParameter("mobileCode", "18291876713");
        post.setParameter("userID", "");
        // client.setTimeout(newTimeoutInMilliseconds);

        // 执行,返回一个结果码
        int code = client.executeMethod(post);

        System.out.println("结果码：" + code);
        // 获取xml结果
        String result = post.getResponseBodyAsString();
        System.out.println("结果：" + result);
        // 释放连接
        post.releaseConnection();
        // 关闭连接
        ((SimpleHttpConnectionManager) client.getHttpConnectionManager()).shutdown();
    }


    public static void cl6(String xml) throws IOException {
        // 服务器地址
        String urlString = "http://211.161.193.122/ZBTest/bailservice.asmx";
        // 需要调用的方法
        String soapActionString = "PostDoData";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 拼接soap
        String soap = xml;
        byte[] buf = soap.getBytes("UTF-8");
        // 设置报头
        conn.setRequestProperty("Content-Length", String.valueOf(buf.length));
        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestProperty("soapActionString", soapActionString);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        OutputStream out = conn.getOutputStream();
        out.write(buf);
        out.close();
        // 获取响应状态码
        int code = conn.getResponseCode();
        System.out.println(code);
        StringBuffer sb = new StringBuffer();
        if (code == HttpStatus.OK.value()) {
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                String s = new String(b, 0, len, "utf-8");
                sb.append(s);
            }
            is.close();
        }
        System.out.println(sb);
    }




    public static void main(String[] args) throws IOException {
        String str =
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                        + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                        + "  <soap:Body>\n"
                        + "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n"
                        + "      <mobileCode>18291876713</mobileCode>\n"
                        + "      <userID></userID>\n"
                        + "    </getMobileCodeInfo>\n"
                        + "  </soap:Body>\n"
                        + "</soap:Envelope>";

        cl6(str);

    }
}
