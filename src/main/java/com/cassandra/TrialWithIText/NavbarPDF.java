package com.cassandra.TrialWithIText;

//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.element.Image;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NavbarPDF extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		VBox navigationTab= getNavigationPane();
	}
	/// Ref: task 1.1
		public VBox getNavigationPane() throws IOException {
			VBox navBar =  new VBox();
			try {
				PdfReader reader = new PdfReader("C:\\Users\\Cassandra Mae\\Desktop"
						+ "\\Cassandra_Academic_Transcript.pdf");
				PdfDocument pdf = new PdfDocument(reader);
				//reader.close();
				PdfPage page = pdf.getPage(0);
				Rectangle rect = page.getPageSize();
				System.out.println("Size is: " + rect.getHeight());
				
				//PdfImageXObject xobj = page.getThumbnailImage();
				
				//PdfWriter writer = new PdfWriter("results/chapter01/hello.pdf");
				/*PdfDocument w_pdf = new PdfDocument(new PdfWriter("results/chapter01/Text.pdf"));
				PdfFormXObject pageCopy =page.copyAsFormXObject(w_pdf);
				Image image = new Image(pageCopy);
				if(image.isEmpty()){
					System.out.println("Thumbnail does not exist");
				}
				else {
					
					System.out.println("created buffered image");
				}
				
				w_pdf.close();*/
				//writer.close();
				pdf.close();
				reader.close();
			}catch(Exception e) {
				System.out.println("Reader error " + e);
			}
			
			
			
			return navBar;
		}
	/// Ref: task 1.3 
	///	This method is called only after the [drag and drop event](Ref: task 1.2).	
		public void PdfReorder() {
				
		}
		
		
		
}
