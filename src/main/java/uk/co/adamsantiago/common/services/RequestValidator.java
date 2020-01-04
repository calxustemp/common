package uk.co.adamsantiago.common.services;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RequestValidator {
    public static String execute(String token) {
        String responseJson = "";
        HttpGet request = new HttpGet("http://localhost:4567" + "/login?token=" + token);

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClients.createDefault();
            try {
                response = httpClient.execute(request);
            } catch(IOException ioe) {
                System.out.println(ioe.toString());
            } finally {
                if (response != null) {
                    response.close();
                }
            }
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            responseJson = EntityUtils.toString(entity);
        } catch(IOException ioe) {
            System.out.println(ioe.toString());
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.toString());
                }
            }
        }
        return responseJson;
    }
}
