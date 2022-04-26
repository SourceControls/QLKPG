/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package old;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import org.apache.pdfbox.pdmodel.*;

/**
 *
 * @author TuanHung
 */
public class testFunct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

    }

    public static void savePDF() throws IOException {
        //create and save pdf
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        document.save("G:\\My Drive\\All Tai Lieu\\CNPM-Project\\QLKPG\\testPDF.pdf");
        document.close();
    }

}
