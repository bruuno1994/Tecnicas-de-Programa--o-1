import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class GeradorStickers {

    public void gerarStickers() throws IOException {
        // Leitura da imagem "local"
        BufferedImage imagemOriginal = ImageIO.read(new File("Stickers/entrada/walle.jpg"));

        // Criar uma nova imagem em memória, com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TYPE_INT_ARGB);

        // Copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurar a fonte para escrever na imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD,100);
        graphics.setFont(fonte);
        graphics.setColor(Color.RED);

        // Escrever uma mensagem na nova imagem
        graphics.drawString("TOP 250 FILMES", 200, novaAltura - 80);

        // Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("Stickers/saida/figurinha.png"));
    }
    public static void main(String[] args) throws IOException {
        var gerador = new GeradorStickers();
        gerador.gerarStickers();
    }
}