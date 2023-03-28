import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        //fazer uma conexão http e buscar os filmes mais populares  
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient(); 
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // extrair dados  (titulo , poster, classificação, ano) 
        var jsonParser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = jsonParser.parse(body); 
       
       
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Título: " + "\u001b[1m" + filme.get("title") + "\u001b[m");
            System.out.println("Imagem: " + "\u001b[1m" + filme.get("image") + "\u001b[m");
            System.out.println("\u001b[38;2;255;255;255m\u001b[48;2;42;122;228mClassificação:\u001b[m " + "\u001b[1m" + filme.get("imDbRating") + "\u001b[m");
            

            double numRating = Double.parseDouble(filme.get("imDbRating"));
            // Adicionado emoji conforme o resultado da classificação
            if(numRating <= 6.0){
                for(int i = 1; i <= Math.ceil(numRating); i++) {
                    System.out.print("👎");
                }
            } else {
                for(int i = 1; i <= Math.ceil(numRating); i++) {
                    System.out.print("⭐");
                }
            }
            System.out.println("\n"); 
        }
    }
}

