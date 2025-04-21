package org.example;//package org.example;
//
//import okhttp3.HttpUrl;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//import java.io.IOException;
//import java.util.Objects;
//
//public class Main {
//    public static void main(String[] args) {
//
//        // Base URL
//        String baseUrl = "https://api.browserstack.com/sdk/v1/update_cli";
//
//        // Build the URL with query parameters
//        HttpUrl.Builder httpUrlBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl)).newBuilder();
//        httpUrlBuilder.addQueryParameter("sdk_language", "java");
//        httpUrlBuilder.addQueryParameter("os", "Mac OS X");
//        httpUrlBuilder.addQueryParameter("sdk_version", "1.32.0");
//        httpUrlBuilder.addQueryParameter("os_arch", "x86_64");
//        httpUrlBuilder.addQueryParameter("cli_version", "0");
//
//        // Final URL
//        HttpUrl finalUrl = httpUrlBuilder.build();
//        System.out.println("Built URL: " + finalUrl);
//
//        // Create an OkHttpClient instance
//        OkHttpClient client = new OkHttpClient();
//
//        // Build the request
//        Request request = new Request.Builder()
//                .url(finalUrl)
//                .get()
//                .build();
//
//        // Execute the request and print the response
//        try (Response response = client.newCall(request).execute()) {
//            if (response.isSuccessful() && response.body() != null) {
//                System.out.println("Response: " + response.body().string());
//            } else {
//                System.out.println("Request failed with status code: " + response.code());
//            }
//        } catch (IOException e) {
//            System.err.println("Error during request execution: " + e.getMessage());
//        }
//    }
//    }







import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Base URL
        String baseUrl = "https://api.browserstack.com/sdk/v1/update_cli";

        // Build the URL with query parameters
        HttpUrl.Builder httpUrlBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl)).newBuilder();
        httpUrlBuilder.addQueryParameter("sdk_language", "java");
        httpUrlBuilder.addQueryParameter("os", "Mac OS X");
        httpUrlBuilder.addQueryParameter("sdk_version", "1.32.0");
        httpUrlBuilder.addQueryParameter("os_arch", "x86_64");
        httpUrlBuilder.addQueryParameter("cli_version", "0");

        // Final URL
        HttpUrl finalUrl = httpUrlBuilder.build();
        System.out.println("Built URL: " + finalUrl);

        // Add your BrowserStack username and access key
        String username = "your_userName"; // Replace with your BrowserStack username
        String accessKey = "your_AccessKey"; // Replace with your BrowserStack access key

        // Create an OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Build the request with Basic Authentication
        String credential = Credentials.basic(username, accessKey);
        Request request = new Request.Builder()
                .url(finalUrl)
                .addHeader("Authorization", credential)
                .get()
                .build();

        // Execute the request and print the response
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Response: " + response.body().string());
            } else {
                System.out.println("Request failed with status code: " + response.code());
            }
        } catch (IOException e) {
            System.err.println("Error during request execution: " + e.getMessage());
        }
    }
}