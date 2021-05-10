package com.ken.designpattern;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

    public static void main(String[] args) {
        try{
            // 工厂方法
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream is = httpURLConnection.getInputStream();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
