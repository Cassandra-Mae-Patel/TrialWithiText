package com.cassandra.TrialWithIText;


import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.itextpdf.io.image.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;



public class TrialPdfTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			//source
			PdfWriter writer = new PdfWriter("C:\\Users\\Cassandra Mae\\Desktop\\Cassandra_Academic_Transcript.pdf");
			PdfDocument origPdf = new PdfDocument(writer );
			PdfPage origPage = origPdf.getFirstPage();
			Document doc = new Document(origPdf);
			PdfImageXObject xobj = origPage.getThumbnailImage();
			//BufferedImage bim = xobj.getBufferedImage();
			Image img = new Image(xobj);
			if(img.isEmpty()) {
				System.out.println("No Image obtained");
			}
			else {
				System.out.println("Image Obtained");
			}
			
			doc.close();
			origPdf.close();
			writer.close();
		}catch(Exception e) {
			System.out.println("Error while reading file: "+ e);
		}
		
		//destination
		//PdfDocument pdf = new PdfDocument(new PdfWriter("results/chapter01/iText_Image_Example.pdf"));
		//PdfFormXObject pageCopy = origPage.copyAsFormXObject(pdf);
		
	
	
			
			
			
		/*System.out.println("Type of imegae: " + xobj.identifyImageType());
		byte[] img = new byte[1024];*/
		//ArrayList<Byte> img  = new ArrayList <Byte>(); 
		//File firstFile = new File("results/chapter01/Trail.png");
		//FileOutputStream fout = new FileOutputStream(firstFile);
		
		
		
		
		//fout.write(img);
				//int len = xobj.getImageBytes().length;
		/*for(int i=0; i<=xobj.getImageBytes().length;i++) {
					img[i]=xobj.getImageBytes()[i];
			//img.add(xobj.getImageBytes()[i]);
					fout.write(img,0,xobj.getImageBytes().length);
				}*/
		/*Document document1 = new Document(pdf);
		Image image = new Image(pageCopy);
		
		document1.add(image);
		 
		document1.close();*/
		
		

	}
	}
