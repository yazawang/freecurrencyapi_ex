package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String apiKey = "fca_live_qT7RMJEks2JSVWY0Yr6FocSutQpQMOoIt3MPUci5";
        String baseUrl = "https://api.freecurrencyapi.com/v1/latest";
        String queryParams = "?apikey=" + apiKey + "&base_currency=USD";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + queryParams))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response body: " + response.body());

        JSONObject jsonResponse = new JSONObject(response.body());
        System.out.println("EUR: " + jsonResponse.getJSONObject("data").getDouble("EUR"));
    }
}