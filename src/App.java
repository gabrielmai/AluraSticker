import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // Fazer conexão Https e buscar conteúdo
       
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_hvjpinb9";
        String url = "https://api.nasa.gov/planetary/apod?api_key=g7NXJLXxRzX2zReVneit7llogTXrHy9ebTepblb3&start_date=2022-06-12&end_date=2022-06-14";
        //String url = "https://linguagens-api-gabriel-mai.herokuapp.com/linguagens";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        // Extrair e manipular os dados

        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (Conteudo conteudo : conteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo().replace(":", "-")  + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}