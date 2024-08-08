package Model;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Main.Main;

public class CupomFiscal {

    private String destinoArquivo;
    private int alturaDocumento;
    private int larguraDocumento;
    private PdfFont titulo;
    private Document documento;

    public CupomFiscal() {
        this.destinoArquivo = "./cupom.pdf"; // raiz do projeto
        this.alturaDocumento = 98;
        this.larguraDocumento = 88;
        configurarPDF();
        start();
    }

    public String getDestinoArquivo() {
        return destinoArquivo;
    }
    
    public PdfWriter configurarGeradorPDF() {
        try {
            return new PdfWriter(this.destinoArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void configurarPDF() {
        try {
            PdfWriter writer = configurarGeradorPDF();
            if (writer == null) {
                throw new IOException(Main.controller.getMensagem("CupomFiscal_configurarPDF1"));
            }
            PdfDocument pdf = new PdfDocument(writer);
            PageSize pageSize = new PageSize(this.larguraDocumento, this.alturaDocumento);
            this.documento = new Document(pdf, pageSize);
            this.documento.setMargins(1, 4, 1, 4);
            PdfFont textoPadrao = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
            this.titulo = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);

            // Configurações padrão de texto
            this.documento.setFont(textoPadrao);
            this.documento.setFontSize(5);
            // Remover a linha problemática
            // this.documento.setProperty(Property.LEADING, UnitValue.createPointValue(0.2f)); // Espaçamento entre linhas

        } catch (IOException ex) {
            Logger.getLogger(CupomFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {
        try {
            // Linhas de separação de seções e de corte de impressora
            Paragraph linhaCabecalho = new Paragraph("__________________________")
                    .setFont(titulo)
                    .setFontSize(6);

            Paragraph dadosEmpresa = new Paragraph(Main.controller.getMensagem("CupomFiscal_start1") + "Esquinão Lanches"); // Refatorar como objeto e realizar injeção de dependência

            Paragraph linhaSeparador = new Paragraph("****************************************************")
                    .setFont(titulo)
                    .setFontSize(3);

            this.documento.add(linhaCabecalho);

            this.documento.add(dadosEmpresa);

            this.documento.add(linhaSeparador);

        } catch (Exception e) {
            Logger.getLogger(CupomFiscal.class.getName()).log(Level.SEVERE, Main.controller.getMensagem("CupomFiscal_start2"), e);
            e.printStackTrace();
        }
    }

    public void adicionarMensagem(String mostrarPedidoP) {
        Paragraph mostrarPedido = new Paragraph(mostrarPedidoP);
        documento.add(mostrarPedido);
    }

    public void finishPDF(String formaPagamentoP) {
        Paragraph linhaSeparador = new Paragraph("****************************************************")
                .setFont(titulo)
                .setFontSize(3);

        this.documento.add(linhaSeparador);

        Paragraph dadosPagamento = new Paragraph(Main.controller.getMensagem("CupomFiscal_finishPDF1") + formaPagamentoP);
        documento.add(dadosPagamento);

        Paragraph linhaRodape = new Paragraph("------------------------------------------------------------")
                .setFont(titulo)
                .setFontSize(4);

        documento.add(linhaRodape);
        documento.close(); // Documento impresso
    }
}