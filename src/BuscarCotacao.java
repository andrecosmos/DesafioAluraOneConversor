import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarCotacao {

    public Cotacao buscarCotacao(String moeda, double valor, String conv) {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/8322dbc257216409fb293439/latest/" + conv);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            JsonObject conversoes = json.getAsJsonObject("conversion_rates");
            double taxa = conversoes.get(moeda).getAsDouble();

            double resultado = taxa * valor;
            return new Cotacao(moeda, resultado);


        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a cotação.");
        }
    }
}
