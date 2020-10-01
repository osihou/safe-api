package com.projectpl.safeapi.utils;


import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;

import com.itextpdf.text.pdf.PdfWriter;

import com.projectpl.safeapi.persistance.entity.Opinion;
import io.netty.handler.codec.AsciiHeadersEncoder;


import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PdfRaportGenerator {

    public static ByteArrayInputStream opinionsReport(List<Opinion> opinionsList) throws URISyntaxException, DocumentException, IOException {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Path path = Paths.get(ClassLoader.getSystemResource("image/logo.png").toURI());
        PdfWriter.getInstance(document, out);

        document.open();

        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scalePercent(50);
        document.add(img);




        Font font1 = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);
        Chunk chunk1 = new Chunk("\nHi there,", font1);

        Font font2 = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.GREEN);
        Chunk chunk2 = new Chunk("[PLACE_NAME]", font2);


        document.add(chunk1);

        document.add(chunk2);



        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
