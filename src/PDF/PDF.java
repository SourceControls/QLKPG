/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDF;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import model.DungChung;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author TuanHung
 */
public class PDF {

    public PDDocument document;
    PDPageContentStream contentStream;
    PDPage firstPage;
    public static int widthPage = 612;
    public static int heightPage = 792;
    public float fontSizeB;
    public float fontSizeN;
    public PDType0Font fontN;
    public PDType0Font fontB;
    public PDType0Font fontI;
    public PDType0Font fontIB;

    private void init() throws IOException {
        //setup document, page
        document = new PDDocument();
        firstPage = new PDPage(new PDRectangle(widthPage, heightPage));
        document.addPage(firstPage);
        contentStream = new PDPageContentStream(document, document.getPage(0));
        //setup font, width, height
        fontSizeB = 16;
        fontSizeN = 12;
        fontN = PDType0Font.load(document, getClass().getResourceAsStream("font/arial.ttf"));
        fontB = PDType0Font.load(document, getClass().getResourceAsStream("font/arialbd.ttf"));
        fontI = PDType0Font.load(document, getClass().getResourceAsStream("font/ariali.ttf"));
        fontIB = PDType0Font.load(document, getClass().getResourceAsStream("font/arialbi.ttf"));

    }

    public PDF() throws IOException {
        // TODO code application logic here
        init();

//        insertImage(contentStream, document, 0, 0, 0, "test/KH1.jpg");  //image sẽ vẽ từ dưới vẽ lên
//        insertFillRectangle(document, 0, 100, 0,w,30, Color.yellow);
//        insertTextCenter(document, 0,  h - 50,"Bùi Tuấn Hùng", fontN, fontSizeB, Color.black);
//        insertMultipleLine(contentStream, document, 0, 30, 100, new String[]{"Họ Tên", "Giới Tính", "Ngày Sinh"}, fontN, fontSizeN, Color.black);
//        insertMultipleLine(contentStream, document, 0, 90, 100, new String[]{":  Bùi Tuấn Hùng", ":  Nam", ":  05/09/2001"}, fontN, fontSizeN, Color.black);
        //save and close pdf
    }

    public void savePDF(String fileName) throws IOException {
        contentStream.close();
        if (!fileName.contains(".pdf")) {
            fileName += ".pdf";
        }
        document.save(DungChung.selectTargetFile(fileName));
        document.close();
        System.out.println("Lưu Thành Công");
    }

    public void insertImage(int x, int y, String imgURL, int imgW, int imgH) throws IOException {
        //specific size
        PDImageXObject image = PDImageXObject.createFromFile(imgURL, document);
        contentStream.drawImage(image, x, y, imgW, imgH); //x,y, width,height
    }

    public void insertImage(int x, int y, String imgURL) throws IOException {
        //default size
        PDImageXObject image = PDImageXObject.createFromFile(imgURL, document);
        contentStream.drawImage(image, x, heightPage - y - image.getHeight()); //x,y, width,height
    }

    public void insertImage(int x, int y, String imgURL, float scale) throws IOException {
        //scale size
        PDImageXObject image = PDImageXObject.createFromFile(imgURL, document);
        contentStream.drawImage(image, x, y, image.getWidth() + image.getWidth() * scale, image.getHeight() + image.getHeight() * scale); //x,y, width,height
    }

    public void insertFillRectangle(int x, int y, int w, int h, Color colorFill, Color colorAfter) throws IOException {
        contentStream.setNonStrokingColor(colorFill);
        contentStream.addRect(x, y, w, -h);
        contentStream.fillAndStroke();
        contentStream.setNonStrokingColor(colorAfter);

    }

    public void insertText(int x, int y, String text, PDFont font, Float fontSize, Color color, String align) throws IOException {
        if (align.equals("center")) { //center page
            float fW = font.getStringWidth(text) / 1000 * fontSize;
            x = (int) (widthPage - fW) / 2;
        }
        if (align.equals("centerX")) { //center page
            float fW = font.getStringWidth(text) / 1000 * fontSize;
            x = (int) (x - fW) / 2;
        }
        if (align.equals("right")) {   //nếu insert right thì x = margin right
            float fW = font.getStringWidth(text) / 1000 * fontSize;
            x = (int) (widthPage - fW) - x;
        }
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(color);
        contentStream.newLineAtOffset(x, heightPage - y);
        contentStream.showText(text);
        contentStream.endText();

    }

    public void insertMultipleLine(int x, int y, String text[], PDFont font, Float fontSize, Color color) throws IOException {

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

    //table 
    private int[] colWidths;
    private int numOfCols = 0;
    private int cellHeight;
    private int yPosition;
    private int xPosition;
    private int colPosition = 0;
    private int xInitialPosition;

    void drawTable(int[] colWidths, String header[], Color cellHeaderColor, int cellHeight, int XPosition, int yPosition) throws IOException {
        this.colWidths = colWidths;
        this.cellHeight = cellHeight;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        xInitialPosition = xPosition;

        contentStream.setStrokingColor(Color.black);
        if (cellHeaderColor != null) {
            contentStream.setNonStrokingColor(cellHeaderColor);
        }

        contentStream.addRect(xPosition, yPosition, colWidths[colPosition], cellHeight);
//        if (cellHeaderColor == null) {
//            contentStream.stroke();
//        } else {
//            contentStream.fillAndStroke();
//        }
    }

    void drawTable(int x, int y, int rowH, Vector<Vector> headers, Vector<Vector> datas, int[] colW) throws IOException {
        //vẽ từ trên xuống dưới
        int xtmp = x;
//        y = heightPage - y;
        int sumW = 0;
        for (int i = 0; i < headers.get(0).size(); i++) {
            sumW += colW[i];
        }
        String data = "";
        for (int i = headers.size() - 1; i >= 0; i--) {
            for (int j = 0; j < headers.get(i).size(); j++) {
                //header
                insertText(x, y + 20, headers.get(i).get(j).toString(), fontB, fontSizeN, Color.black, "");
                //content
                int xData = (int) (fontB.getStringWidth(headers.get(i).get(j).toString()) / 1000 * fontSizeN) + x + 20;
                if( datas.get(i).get(j) != null)
                    data = datas.get(i).get(j).toString();
                else 
                    data = "";
                insertText(xData, y + 15,data, fontN, fontSizeN, Color.black, "");
                //dot.............
                int xDot = x + (int) (fontN.getStringWidth(headers.get(i).get(j).toString()) / 1000 * fontSizeN);
                x += colW[j];
                while (xDot++ < x - 3) {
                    insertText(xDot++, y + 20, ". ", fontN, fontSizeN, Color.black, "");
                }
            }
            x = xtmp;
            y -= rowH;
        }
        contentStream.stroke();
    }

}
