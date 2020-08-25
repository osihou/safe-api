package com.projectpl.safeapi.utils;

import com.itextpdf.text.*;

import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.service.locations.ILocationService;
import com.projectpl.safeapi.service.opinions.IOpinionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfGenerator {


    @Autowired
    private static IOpinionService opinionService;

    @Autowired
    private static ILocationService locationService;

    public static void main(String[] args) {
        try {
            int id=100010;//Test only!!! I'll get it from the frontend

            Opinion opinions = opinionService.findByLocationKey(id);//Score search for percentage calc -> my points
            Location location = locationService.findById(id); //Name search -> my name

            int myCleanliness = opinions.getCleanliness();//remembering my points for the future
            int myService = opinions.getService();//remembering my points for the future
            int myImprovements=opinions.getImprovements();//remembering my points for the future
            int myEquipment =opinions.getEquipment();//remembering my points for the future
            int myConsumables=opinions.getConsumables();//remembering my points for the future

            PdfReader pdfReader = new PdfReader("raport.pdf");
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("ForesightsRaport.pdf"));
            PdfContentByte canvas = pdfStamper.getOverContent(1);
            Font headFont = FontFactory.getFont("/fonts/Poppins-Regular.ttf",16, new BaseColor(59,185,31,100));
            Font bigFont = FontFactory.getFont("/fonts/Poppins-Regular.ttf",20, new BaseColor(59,185,31,100));
            Font blackFont = FontFactory.getFont("/fonts/Poppins-Regular.ttf",16);


            //name
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(location.getAddress(),bigFont), 129, 1674, 0);

            //date
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = dateFormat.format(date);

            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(strDate, blackFont), 453, 1638, 0);

            //score
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(String.valueOf(opinions.getScore()), headFont), 184, 1604, 0);

            //Later
            //ShowWaysToImprove(id)
            //Later

            //Random generator 1
            Random generator = new Random();
            int randomId = generator.nextInt(46550)+13545;//13545 is index of first location
            opinions = opinionService.findByLocationKey(randomId-13545);//Score search for percentage calc -> their points,
            // -13545 because first id of opinions is 1 but first id of locations is 13545
            location = locationService.findById(randomId);//Name search -> their name

            //Names
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(location.getAddress(), bigFont), 40, 1408+8, 0);
            //Percentage1
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myCleanliness,opinions.getCleanliness()), headFont), 135+6, 1372+8, 0);
            //Percentage2
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myService,opinions.getService()), headFont), 208+6, 1343+8, 0);
            //Percentage3
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myImprovements, opinions.getImprovements()), headFont), 276+6, 1314+8, 0);
            //Percentage4
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myEquipment, opinions.getEquipment()), headFont), 289+6, 1285+8, 0);
            //Percentage5
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myConsumables, opinions.getConsumables()), headFont), 154+6, 1256+8, 0);

            //Random generator 2
            generator = new Random();
            randomId = generator.nextInt(46550)+13545;//13545 is index of first location
            opinions = opinionService.findByLocationKey(randomId-13545);//Score search for percentage calc -> their points
            location = locationService.findById(randomId);//Name search -> their name

            //Names
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(location.getAddress(), bigFont), 40, 1189+8, 0);
            //Percentage1
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myCleanliness,opinions.getCleanliness()), headFont), 135+6, 1152+8, 0);
            //Percentage2
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myService,opinions.getService()), headFont), 208+6, 1123+8, 0);
            //Percentage3
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myImprovements, opinions.getImprovements()), headFont), 276+6, 1094+8, 0);
            //Percentage4
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myEquipment, opinions.getEquipment()), headFont), 289+6, 1065+8, 0);
            //Percentage5
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myConsumables, opinions.getConsumables()), headFont), 154+6, 1036+8, 0);

            //Random generator 3
            generator = new Random();
            randomId = generator.nextInt(46550)+13545;//13545 is index of first location
            opinions = opinionService.findByLocationKey(randomId-13545);//Score search for percentage calc -> their points
            location = locationService.findById(randomId);//Name search -> their name

            //Names
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(location.getAddress(), bigFont), 40, 969+8, 0);
            //Percentage1
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myCleanliness,opinions.getCleanliness()), headFont), 135+6, 932+8, 0);
            //Percentage2
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myService,opinions.getService()), headFont), 208+6, 903+8, 0);
            //Percentage3
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myImprovements, opinions.getImprovements()), headFont), 276+6, 874+8, 0);
            //Percentage4
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myEquipment, opinions.getEquipment()), headFont), 289+6, 845+8, 0);
            //Percentage5
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myConsumables, opinions.getConsumables()), headFont), 154+6, 816+8, 0);

            //Random generator 4
            generator = new Random();
            randomId = generator.nextInt(46550)+13545;//13545 is index of first location
            opinions = opinionService.findByLocationKey(randomId-13545);//Score search for percentage calc -> their points
            location = locationService.findById(randomId);//Name search -> their name

            //Names
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(location.getAddress(), bigFont), 40, 749+8, 0);
            //Percentage1
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myCleanliness,opinions.getCleanliness()), headFont), 135+6, 712+8, 0);
            //Percentage2
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myService,opinions.getService()), headFont), 208+6, 683+8, 0);
            //Percentage3
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myImprovements, opinions.getImprovements()), headFont), 276+6, 654+8, 0);
            //Percentage4
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myEquipment, opinions.getEquipment()), headFont), 289+6, 625+8, 0);
            //Percentage5
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myConsumables, opinions.getConsumables()), headFont), 154+6, 596+8, 0);

            //Random generator 5
            generator = new Random();
            randomId = generator.nextInt(46550)+13545;//13545 is index of first location
            opinions = opinionService.findByLocationKey(randomId-13545);//Score search for percentage calc -> their points
            location = locationService.findById(randomId);//Name search -> their name

            //Names
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(location.getAddress(), bigFont), 40, 529+8, 0);
            //Percentage1
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myCleanliness,opinions.getCleanliness()), headFont), 135+6, 492+8, 0);
            //Percentage2
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myService,opinions.getService()), headFont), 208+6, 463+8, 0);
            //Percentage3
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myImprovements, opinions.getImprovements()), headFont), 276+6, 434+8, 0);
            //Percentage4
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myEquipment, opinions.getEquipment()), headFont), 289+6, 405+8, 0);
            //Percentage5
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(percentagesCounting(myConsumables, opinions.getConsumables()), headFont), 154+6, 376+8, 0);

            pdfStamper.close();
            pdfReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static String percentagesCounting(int myPoints,int theirPoints){
        //Get points and convert it to procents
        String output;
        int Percent= (myPoints/theirPoints)*100;
        if (Percent > 110)
        {
            output = Percent-100 + "better";
        }
        else if (Percent < 90)
        {
            output = Percent + "worst";
        }
        else
        {
            output = "equal";
        }
        return output;
    }

    //public static ShowWaysToImprove(id){
    // sort and show best 3 ways to improwe
    //}
}

