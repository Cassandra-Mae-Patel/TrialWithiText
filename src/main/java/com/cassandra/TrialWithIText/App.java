package com.cassandra.TrialWithIText;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.IOException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;



/**
 * Hello world!
 *
 */
public class App 
{
	public static final String DEST  = "results/chapter01/practice2.pdf";
	public static final String SRC1  = "results/chapter01/practice1.pdf";
	//public static final String EXISTING = "/TrialWithIText/src/main/java/com/cassandra/TrialWithIText/Testing123.pdf";
   
	public static void main( String[] args ) throws IOException
    {
		File file = new File(DEST);
        file.getParentFile().mkdirs();
        try {
			new App().createPdf(SRC1);
			
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while creating PDF: " + e);
		}
         
       
		
        //System.out.println( "Hello World!" );
    }
    public void createPdf(String dest) throws IOException, java.io.IOException {
        //Initialize PDF writer
    	PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);
        
        //PdfDocument docOld = new PdfDocument(new PdfReader(EXISTING));
        
        //NavbarPDF nav = new NavbarPDF(pdf);
        //Add paragraph to the document
        document.add(new Paragraph("Hello from your Instructor!"));
        System.out.println("PDF created ");
        
        //Close document
        //docOld.close();
        document.close();
        pdf.close();
        writer.close();
        
        try {
			new App().createNewPDF(DEST);
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			System.out.println("NavBar creating method: "+ e);
		}
    }
    
    public void createNewPDF(String src) throws java.io.IOException {
    	/*PdfWriter writer = new PdfWriter(dest);
    	System.out.println("    writer    ");

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        System.out.println("    pdf doc    ");

        // Initialize document
        Document document = new Document(pdf);
        System.out.println("    simple doc    ");*/
        
        //PdfDocument docOld = new PdfDocument(new PdfReader(EXISTING));
        
        //NavbarPDF nav = new NavbarPDF(pdf);
        //Add paragraph to the document
        
        
       /* NavbarPDF nav = new NavbarPDF(pdf);
        System.out.println("    constructor was already called here    ");
        PdfImageXObject imOj;
        System.out.println("    PdfImageXObject created    ");
        imOj = nav.getThumbnailImage();
        System.out.println("    ThumbnailImage is used and stored in imObj    ");
        Image img1 = new Image(imOj);
        System.out.println("  imObj is stores in img1    ");
        document.add(img1);
        //document.add(new Image(nav.getThumbnailImage()));
        System.out.println("    Thumbanil to image successful and added to doc    ");
        System.out.println("PDF created ");
        
        //Close document
        //docOld.close();
        document.close();
        pdf.close();
        writer.close();*/
        
        
        PdfDocument origPdf = new PdfDocument(new PdfReader(src));
        PdfPage origPage = origPdf.getPage(1);
        System.out.println("**Read PDF");
        PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
        System.out.println("**Write PDF");
        //PdfFormXObject pageCopy = origPage.copyAsFormXObject(pdf);
        PdfImageXObject pageCopy = origPage.getThumbnailImage();
        System.out.println("**PdfImageXObject PDF");
        
        Document doc =new Document (pdf);
        System.out.println("New Doc created");
        try {
        	//int num = pageCopy.getImageBytes().length;
        	//byte[] imageTobyte = pageCopy.getImageBytes();
        	/*for (int i=0;i<=num;i++ ) {
        		imageTobyte[i]=page
        	}*/
        	ImageData imageData = ImageDataFactory.create(pageCopy.getImageBytes(false));
        	System.out.println("Image data");
        	
        	Image image = new Image(imageData);
        	System.out.println("image taken");
        	
        	doc.add(image);
        	System.out.println("document added");
        	
        }catch(Exception e) {
        	System.out.println("Last Error: "+ e);
        	
        }
        
        doc.close();
        
        origPdf.close();
        origPdf.close();
        
        
        
    }
}
