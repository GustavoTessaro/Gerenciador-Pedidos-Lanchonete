package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;
import java.io.ByteArrayOutputStream;
import Main.Main;

public class GerarPDFComGrafico {

    private int totalDeClientesCadastrado;
    private int totalDeClientesNaoCadastrado;
    private float total;
    private float totalFaturadoCadastrado;
    private float totalFaturadoNaoCadastrado;
    private String destinoArquivo;

    public GerarPDFComGrafico(int totalDeClientesCadastrado, int totalDeClientesNaoCadastrado, float total, float totalFaturadoCadastrado, float totalFaturadoNaoCadastrado) {
        this.totalDeClientesCadastrado = totalDeClientesCadastrado;
        this.totalDeClientesNaoCadastrado = totalDeClientesNaoCadastrado;
        this.total = total;
        this.totalFaturadoCadastrado = totalFaturadoCadastrado;
        this.totalFaturadoNaoCadastrado = totalFaturadoNaoCadastrado;
        this.destinoArquivo = "./Grafico.pdf";
    }

    public String getDestinoArquivo() {
        return destinoArquivo;
    }

    public JFreeChart criarGrafico() {
        // Calcula a porcentagem de clientes cadastrados e não cadastrados
        float porcentagemCadastrado = ((float) totalDeClientesCadastrado / (totalDeClientesCadastrado + totalDeClientesNaoCadastrado)) * 100;
        float porcentagemNaoCadastrado = ((float) totalDeClientesNaoCadastrado / (totalDeClientesCadastrado + totalDeClientesNaoCadastrado)) * 100;

        // Crie um conjunto de dados para o gráfico de pizza
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Adicione os valores ao conjunto de dados
        dataset.setValue(Main.controller.getMensagem("GerarPDFComGrafico_criarGrafico1") + porcentagemCadastrado + "%)", totalFaturadoCadastrado);
        dataset.setValue(Main.controller.getMensagem("GerarPDFComGrafico_criarGrafico2") + porcentagemNaoCadastrado + "%)", totalFaturadoNaoCadastrado);

        // Crie o gráfico de pizza usando o conjunto de dados
        JFreeChart chart = ChartFactory.createPieChart(Main.controller.getMensagem("GerarPDFComGrafico_criarGrafico3"), // Título do gráfico
                dataset, // Conjunto de dados
                true, // Inclui legenda
                true, // Inclui dicas de ferramentas
                false // Não inclui URLs
        );

        return chart;
    }

    public void gerarPDFComGrafico() {
        try {
            // Crie o gráfico de pizza
            JFreeChart chart = criarGrafico();

            // Converta o gráfico em uma imagem
            BufferedImage bufferedImage = chart.createBufferedImage(400, 300);

            // Converta a imagem em um array de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] chartImage = baos.toByteArray();

            // Configure o escritor de PDF
            PdfWriter writer = configurarGeradorPDF();
            if (writer == null) {
                throw new IOException(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico1"));
            }
            PdfDocument pdf = new PdfDocument(writer);
            PageSize pageSize = PageSize.A4;

            // Crie o documento PDF
            Document document = new Document(pdf, pageSize);
            document.add(new Paragraph(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico2")));

            // Adicione as informações dos clientes
            document.add(new Paragraph(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico3") + totalDeClientesCadastrado));
            document.add(new Paragraph(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico4") + totalDeClientesNaoCadastrado));
            document.add(new Paragraph(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico5") + Main.controller.getMensagem("MoedaDinheiro") + " " + totalFaturadoCadastrado));
            document.add(new Paragraph(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico6") + Main.controller.getMensagem("MoedaDinheiro") + " " + totalFaturadoNaoCadastrado));
            document.add(new Paragraph(Main.controller.getMensagem("GerarPDFComGrafico_gerarPDFComGrafico7") + Main.controller.getMensagem("MoedaDinheiro") + " " + total));
            
            // Adicione a imagem do gráfico ao PDF
            Image image = new Image(ImageDataFactory.create(chartImage));
            document.add(image);

            // Feche o documento
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(GerarPDFComGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PdfWriter configurarGeradorPDF() {
        try {
            return new PdfWriter(this.destinoArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerarPDFComGrafico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}