package br.com.alura.conversorDeMoedas.classes;

import br.com.alura.conversorDeMoedas.exceptions.InvalidCurrencyException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;


public class Exchanger {

    private final String apiKey;

    public Exchanger(String apiKey) {
        this.apiKey = apiKey;
    }

    public void exchange(String baseCurrency, String targetCurrency, Double value) {
        String requestAddress = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";

        Gson gson = new Gson();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestAddress + baseCurrency))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 403) {
                throw new InvalidKeyException("A chave de autenticação da API é inválida");
            }

            if (response.statusCode() == 404) {
                throw new InvalidCurrencyException("Moeda base não encontrada");
            }


            Currency currency = gson.fromJson(response.body(), Currency.class);

            if (!currency.conversion_rates().containsKey(targetCurrency)) {
                throw new InvalidKeyException("Moeda de troca inválida");
            }

            if (response.statusCode() == 200) {
                double exchangedValue = currency.conversion_rates().get(targetCurrency) * value;
                System.out.println(value + " " + baseCurrency + " equivalem a " +
                        String.format("%.2f", exchangedValue) + " em " + targetCurrency);
            }

        } catch (IOException | InterruptedException | InvalidKeyException | InvalidCurrencyException e) {
            System.out.println("Houve um erro: " + e.getMessage());
        }
    }


}