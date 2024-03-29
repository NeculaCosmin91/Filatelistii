package com.example.filatelistii.Necesar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpManager {
    private URL url;
    private final String adresaUrl;
    private HttpURLConnection conexiune;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    public httpManager(String adresaUrl) {
        this.adresaUrl = adresaUrl;
    }

    public String process() {
        try {
            return getRezultatHttp();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inchidereConexiuni();
        }

        return null;
    }

    private void inchidereConexiuni() {
        try {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conexiune.disconnect();

    }

    private String getRezultatHttp() throws IOException {
        url = new URL(adresaUrl);
        conexiune = (HttpURLConnection) url.openConnection();
        inputStream = conexiune.getInputStream();
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder rezultat = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            rezultat.append(line);
        }
        return rezultat.toString();

    }
}
