import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas  {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // Leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies_1.jpg").openStream();
        BufferedImage imagemOriginal =  ImageIO.read(inputStream);

        // Cria nova imgagem em memória com transparência e com tamanho novo

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copia a imagem original pra novo imagem (em memória)

        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // Escrever uma frase na nova imgaem
        String texto = "Imersão JAVA ✌";
        FontMetrics metrics = graphics.getFontMetrics(fonte);
        int x = (largura - metrics.stringWidth(texto)) / 2;
        int y = novaAltura - 70;
        graphics.drawString(texto, x, y);
       
        /*Criando uma nova subpasta no diretorio informado */
        boolean sucess = new File("c:\\temp\\alura-stickers" + "//saida").mkdir();
        System.out.println("Directory created successfully: " + sucess);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }

  
}
