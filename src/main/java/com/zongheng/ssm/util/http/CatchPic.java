/*
 * Copyright 2018 by 青岛比特信息科技有限公司 .
 * All rights reserved.
 */
package com.zongheng.ssm.util.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 日期		:	2018/8/8<br>
 * 作者		:	liuxin<br>
 * 项目		:	ssmDemo<br>
 * 功能		:	<br>
 */
public class CatchPic {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String easyapiUrl = "https://www.easyapi.com/epark";

            String result = httpGet(easyapiUrl);
            Document document = Jsoup.parse(result);
            Elements elements = document.select("p").select("img");
            for (Element element : elements) {
                String imgUrl = element.attr("src");
                System.out.println(imgUrl);
                try {
                    URL url = new URL(imgUrl);
                    URLConnection con = url.openConnection();
                    InputStream input = con.getInputStream();
                    byte[] bs = new byte[1024];
                    int len;
                    OutputStream os = new FileOutputStream("E:\\test\\img\\" + imgUrl.substring(imgUrl.lastIndexOf("/"), imgUrl.length()));
                    while((len = input.read(bs)) != -1){
                        os.write(bs, 0, len);
                    }
                    os.close();
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }
    }

    /*
     * 发送get请求
     * @param url    路径
     * @return
             */
    public static String httpGet(String url){
        //get请求返回结果
        String result = "";
        try {
           //DefaultHttpClient client = new DefaultHttpClient(); //方法过期，使用下面的方式
            HttpClient client = HttpClientBuilder.create().build();

            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == 404) {
                /**读取服务器返回过来的json字符串数据**/
                result = EntityUtils.toString(response.getEntity());

            } else {
                //logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            //logger.error("get请求提交失败:" + url, e);
        }
        return result;
    }
}
