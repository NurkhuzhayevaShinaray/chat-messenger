package api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class ApiClient {
    private final String baseUrl;
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new utils.LocalDateTimeAdapter())
            .create();
    public ApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public <T> T post(String endpoint, Object body, Class<T> responseType) throws Exception {
        URL url = new URL(baseUrl + endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);

        if (body != null) {
            String json = gson.toJson(body);
            try (OutputStream os = con.getOutputStream()) {
                os.write(json.getBytes("utf-8"));
            }
        }

        int code = con.getResponseCode();
        if (code != 200)
            throw new RuntimeException("Ошибка: " + code);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line = br.readLine();
            return gson.fromJson(line, responseType);
        }
    }

    public <T> T get(String endpoint, Class<T> responseType) throws Exception {
        URL url = new URL(baseUrl + endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int code = con.getResponseCode();
        if (code != 200)
            throw new RuntimeException("Ошибка: " + code);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line = br.readLine();
            return gson.fromJson(line, responseType);
        }
    }

    public void delete(String endpoint, Object body) throws Exception {
        URL url = new URL(baseUrl + endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);

        if (body != null) {
            String json = gson.toJson(body);
            try (OutputStream os = con.getOutputStream()) {
                os.write(json.getBytes("utf-8"));
            }
        }

        int code = con.getResponseCode();
        if (code != 200)
            throw new RuntimeException("Ошибка: " + code);
    }
}
