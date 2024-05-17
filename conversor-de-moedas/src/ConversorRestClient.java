import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorRestClient {


    public ConversorExchangeRateResponse converter(String moedaBase, String moedaAlvo, double quantidade) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/32d25cc35bb51b13d9a1418d/pair/"
                        + moedaBase + "/" + moedaAlvo + "/" + quantidade))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            return gson.fromJson(json, ConversorExchangeRateResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}