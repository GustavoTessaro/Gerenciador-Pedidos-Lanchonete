package Model;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import Main.Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GerarTabelaPDF {

    private String destinoArquivo;
    private Document documento;

    public GerarTabelaPDF(String destinoArquivo) {
        this.destinoArquivo = destinoArquivo;
        configurarPDF();
    }

    public PdfWriter configurarGeradorPDF() {
        try {
            return new PdfWriter(this.destinoArquivo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void configurarPDF() {
        try {
            PdfWriter writer = configurarGeradorPDF();
            if (writer == null) {
                throw new IOException(Main.controller.getMensagem("GerarTabelaPDF_configurarPDF1"));
            }
            PdfDocument pdf = new PdfDocument(writer);
            PageSize pageSize = PageSize.A4;
            this.documento = new Document(pdf, pageSize);
            this.documento.setMargins(20, 20, 20, 20);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void adicionarTabela(String[] colunas, String[][] linhas) {
        float[] columnWidths = new float[colunas.length];
        for (int i = 0; i < colunas.length; i++) {
            columnWidths[i] = 1;
        }
        Table tabela = new Table(UnitValue.createPercentArray(columnWidths));
        tabela.setWidth(UnitValue.createPercentValue(100));

        // Adicionando cabeçalhos
        for (String coluna : colunas) {
            tabela.addHeaderCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(coluna).setFontSize(12)));
        }

        // Adicionando linhas da tabela
        for (String[] linha : linhas) {
            for (String celula : linha) {
                tabela.addCell(new Cell().add(new com.itextpdf.layout.element.Paragraph(celula).setFontSize(10)));
            }
        }

        this.documento.add(tabela);
    }

    public void fecharDocumento() {
        if (this.documento != null) {
            this.documento.close();
        }
    }
}