import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
      // fazer uma conexão HTTP e buscar os top 250 filmes do IMDB
      String url = "https://imdb-api.com/en/API/Top250Movies/k_55g4qyyu";

      URI endereco = URI.create(url);

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

      String body = response.body(); 

      // System.out.println(body);

      // extrair só os dados que interessam (titulo, poster, classificação)
      JsonParser parser = new JsonParser();
      List<Map<String, String>> listaDeFilmes = parser.parse(body);

      // exibir e manipular os dados

      for (Map<String, String> filme: listaDeFilmes){
        System.out.println("Nome do filme: " + filme.get("title"));
        System.out.println("Imagem do filme: " + filme.get("image"));
        System.out.println("Nota do filme: " + filme.get("imDbRating"));
        System.out.println();
      }
    }
}