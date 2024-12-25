/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoppingoline.Service;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author choco
 */
public class IntergrationService {

    public String getImgSuggest(String img) {
        HttpClient httpClient = HttpClients.createDefault();

        String url = "http://localhost:8710/api/v1/ai/suggest?img=" + img;
        HttpGet httpGet = new HttpGet(url);
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(60 * 1000)
                .setConnectionRequestTimeout(60 * 1000)
                .setSocketTimeout(60 * 1000).build();
        httpGet.setConfig(config);

        try {
            // Thực hiện yêu cầu HTTP GET
            HttpResponse response = httpClient.execute(httpGet);
            // Lấy nội dung trả về từ phản hồi HTTP
            if (response.getStatusLine().getStatusCode() != 200) {
                return "";
            }
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // Lấy một đối tượng InputStream từ phản hồi
                InputStream inputStream = entity.getContent();
                byte[] sourceBytes = IOUtils.toByteArray(inputStream);
                String encodedString = new String(sourceBytes);
                String res = encodedString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "'");
                // Đóng luồng
                inputStream.close();
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
