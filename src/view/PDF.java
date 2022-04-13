/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author TuanHung
 */
public class PDF {

    public PDF() throws IOException {
        // TODO code application logic here
        //setup document, page
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);
        PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(0));
        //setup font, width, height
        float fontSizeB = 14;
        float fontSizeN = 11;
        PDType0Font fontN = PDType0Font.load(document, getClass().getResourceAsStream("font/arial.ttf"));
        PDType0Font fontB = PDType0Font.load(document, getClass().getResourceAsStream("arialbd.ttf"));
        PDType0Font fontI = PDType0Font.load(document, getClass().getResourceAsStream("ariali.ttf"));
        PDType0Font fontIB = PDType0Font.load(document, getClass().getResourceAsStream("arialbi.ttf"));

        int w = (int) document.getPage(0).getTrimBox().getWidth();
        int h = (int) document.getPage(0).getTrimBox().getHeight();

        insertImage(contentStream, document, 0, 0, 0, "test/KH1.jpg");  //image sẽ vẽ từ dưới vẽ lên
//        insertFillRectangle(document, 0, 100, 0,w,30, Color.yellow);
//        insertTextCenter(document, 0,  h - 50,"Bùi Tuấn Hùng", fontN, fontSizeB, Color.black);
//        insertMultipleLine(contentStream, document, 0, 30, 100, new String[]{"Họ Tên", "Giới Tính", "Ngày Sinh"}, fontN, fontSizeN, Color.black);
//        insertMultipleLine(contentStream, document, 0, 90, 100, new String[]{":  Bùi Tuấn Hùng", ":  Nam", ":  05/09/2001"}, fontN, fontSizeN, Color.black);

        //save and close pdf
        contentStream.close();
        document.save("G:\\My Drive\\All Tai Lieu\\CNPM-Project\\QLKPG\\test\\testPDF.pdf");
        document.close();
    }

    public void insertImage(PDPageContentStream contentStream, PDDocument document, int page, int x, int y, String imgURL, int imgW, int imgH) throws IOException {
        //specific size
        PDImageXObject image = PDImageXObject.createFromFile(imgURL, document);
        contentStream.drawImage(image, x, y, imgW, imgH); //x,y, width,height
    }

    public void insertImage(PDPageContentStream contentStream, PDDocument document, int page, int x, int y, String imgURL) throws IOException {
        //default size
        PDImageXObject image = PDImageXObject.createFromFile(imgURL, document);
        contentStream.drawImage(image, x, y); //x,y, width,height
    }

    public void insertImage(PDPageContentStream contentStream, PDDocument document, int page, int x, int y, String imgURL, float scale) throws IOException {
        //scale size
        PDImageXObject image = PDImageXObject.createFromFile(imgURL, document);
        contentStream.drawImage(image, x, y, image.getWidth() + image.getWidth() * scale, image.getHeight() + image.getHeight() * scale); //x,y, width,height
    }

    public void insertFillRectangle(PDPageContentStream contentStream, PDDocument document, int page, int x, int y, int w, int h, Color color) throws IOException {
        contentStream.setNonStrokingColor(color);
        contentStream.addRect(x, y, w, h);
        contentStream.fill();
    }

    public void insertTextCenter(PDPageContentStream contentStream, PDDocument document, int page, int y, String text, PDFont font, Float fontSize, Color color) throws IOException {
        int w = (int) document.getPage(0).getMediaBox().getWidth();
        int h = (int) document.getPage(0).getMediaBox().getHeight();
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(color);
        float fW = font.getStringWidth(text) / 1000 * fontSize;
        contentStream.newLineAtOffset((w - fW) / 2, y);
        contentStream.showText(text);
        contentStream.endText();

    }

    public void insertMultipleLine(PDPageContentStream contentStream, PDDocument document, int page, int x, int y, String text[], PDFont font, Float fontSize, Color color) throws IOException {
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(color);
        contentStream.setLeading(fontSize + 5);
        contentStream.newLineAtOffset(x, y);

        for (String s : text) {
            contentStream.showText(s);
            contentStream.newLine();
        }
        contentStream.endText();
    }
}
