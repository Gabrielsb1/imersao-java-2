import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        //fazer uma conexão HTTP e buscar os filmes mais populares

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
        //ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();


        var http =  new ClienteHttp();
        String json = http.buscaDados(url);
        
        
        // exibir e manipular os dados

        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 3 ; i++) {

            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();

            String nomeArquivo = conteudo.titulo() + ".png";
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println(); 
        }
    }
}

