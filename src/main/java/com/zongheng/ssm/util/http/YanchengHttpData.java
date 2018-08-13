/*
 * Copyright 2018 by 青岛比特信息科技有限公司 .
 * All rights reserved.
 */
package com.zongheng.ssm.util.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.util.LinkedHashMap;

/**
 * 日期		:	2018/8/8<br>
 * 作者		:	liuxin<br>
 * 项目		:	ssmDemo<br>
 * 功能		:	<br>
 */
public class YanchengHttpData {

    public static void main(String[] args) {


        try {

            HttpClient httpClient = HttpClientBuilder.create().build();

            String postUrl = "http://localhost:8080/epark/api/v1/park/driveOut";
            HttpPost httpPost = new HttpPost(postUrl);

            File firstFile = new File("E:\\test\\img\\111.jpg");
            FileBody firstFileBody = new FileBody(firstFile, ContentType.create("image/jpeg"));

            File secondFile = new File("E:\\test\\img\\111.jpg");
            FileBody secondFileBody = new FileBody(secondFile, ContentType.create("image/jpeg"));

            // data content
            LinkedHashMap<String, Object> baseData = new LinkedHashMap<String, Object>();
            baseData.put("cmdCode", 3);
            baseData.put("devId", "100020");
            baseData.put("psId", "100005");

            LinkedHashMap<String, Object> data = new LinkedHashMap<String, Object>();
            data.put("numplate", "鲁B12345");
            data.put("status", 0);
            data.put("confidence", 100);
            data.put("color", "02");
            data.put("plateFeature", "491/213/284/281");
            data.put("isPicUrl", 0);
            data.put("photo", "");
            data.put("photo1", "");
            data.put("dataTime", "2018-06-28 15:00:00");
            baseData.put("data", data);

            StringBody contentBody = new StringBody(JSONObject.toJSONString(baseData),ContentType.APPLICATION_JSON);

            HttpEntity httpEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.RFC6532)
                    .addPart("json", contentBody)
                    .addPart("file", firstFileBody)
                    //.addPart("file", secondFileBody)
                    .build();


            httpPost.setEntity(httpEntity);

            HttpResponse response = httpClient.execute(httpPost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {

                HttpEntity entitys = response.getEntity();
                if (entitys != null) {
                    System.out.println(EntityUtils.toString(entitys));
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
