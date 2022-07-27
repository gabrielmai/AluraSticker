import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;
//import java.net.URL;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // Leitura da imagem
        //InputStream inputStream = new URL("https://scontent.fvix2-1.fna.fbcdn.net/v/t31.18172-8/1559397_10202065260584080_4461783675951807156_o.jpg?_nc_cat=101&ccb=1-7&_nc_sid=cdbe9c&_nc_ohc=d8gkBQOjJt0AX-vgQdv&_nc_ht=scontent.fvix2-1.fna&oh=00_AT-tKECgtjbTIXL-eJlmT47Cusk4mO_K34PFh9cCblxtgQ&oe=62FCA54B").openStream();
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputStream);


        // Criar nova imagem em memoria com transparência e 
        // tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 300;
        double larguraTexto = largura * (0.1);
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
                

        // Copiar a imagem original p/ nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, null, 0, 0);

    
        
        // Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, (int) larguraTexto);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        

        // Escrever uma frase na imagem
        graphics.drawString("TOPZERA", largura/4, novaAltura - 100);



        // Escrever a nova imagem em um arquivo
        //ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    
    }

   // public static void main(String[] args) throws Exception {
    //    var geradora = new GeradoraDeFigurinhas();
    //    geradora.cria();
}

