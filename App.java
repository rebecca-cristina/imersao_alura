import static java.net.http.HttpRequest.newBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão http e guardar uma resposta dentro de uma string e buscar os top 250 filmes

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = newBuilder(endereco).GET().build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação) - parciar os dados
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);


        // exibir e manipular os dados

        
        for (Map<String,String> filme : listaDeFilmes) {

        System.out.println("\u001b[1mTítulo: \u001b[0m" + filme.get("title"));

        System.out.println("\u001b[1mPoster: \u001b[0m" + filme.get("image"));

        double classificacao = Double.parseDouble(filme.get("imDbRating"));

        int numEstrelinhas = (int) classificacao;
        
        for (int estrela = 1; estrela <= numEstrelinhas; estrela++) {
            System.out.print("⭐");
        }
        
        System.out.print("\n");

        double corClassificacao = (double) classificacao;

        for (double cor = 0; cor <= corClassificacao; cor++) {

            if (corClassificacao <= 10.0 && corClassificacao >= 9.7){
                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;27;219;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
                break;           
            
            } else if(corClassificacao < 9.7 && corClassificacao >= 9.5) {
                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;96;219;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
                break;

            } else if (corClassificacao < 9.5 && corClassificacao >= 9.2) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;140;219;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
                break;

            } else if (corClassificacao < 9.2 && corClassificacao >= 9.0) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;172;219;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
               
                break;
                
            } else if (corClassificacao < 9.0 && corClassificacao >= 8.7) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;200;219;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
               
                break;
                
            } else if (corClassificacao < 8.7 && corClassificacao >= 8.5) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;219;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break;
                
            } else if (corClassificacao < 8.5 && corClassificacao >= 8.2) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;187;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break;
            
            } else if (corClassificacao < 8.2 && corClassificacao >= 8.0) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;143;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break;

            } else if (corClassificacao < 8.0 && corClassificacao >= 7.7) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;124;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break;               

            } else if (corClassificacao < 7.7 && corClassificacao >= 7.5) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;87;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break;

            } else if (corClassificacao < 7.5 && corClassificacao >= 7.2) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;68;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break; 

            } else if (corClassificacao < 7.2 && corClassificacao >= 7.0) {

                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;39;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            
                break;  

            } else{
                System.out.print("\u001b[1m \u001b[38;2;255;255;255m \u001b[48;2;219;11;11mClassificação: " + filme.get("imDbRating") + "\u001b[0m \u001b[m");
            }
        }
        
        System.out.println("\n");

    }
  }
}




