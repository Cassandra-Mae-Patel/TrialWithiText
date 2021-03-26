package com.cassandra.TrialWithIText;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.icepdf.core.pobjects.*;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

/**
 * \defgroup NavBar Navigation Pane
 * 
 * @{
 *
 */
/// Ref: User_Story 1
/// Ref: task 1.1
/// This class provides the functionality for the navigation pane while 
/// accessing the PDF. 
public class UINavigationPane extends Application {
	

	public static void main(String[] args) { 
		// TODO Auto-generated method stub

		launch(args);
	}
/// Ref: task 1.1
/// Ref: task 1.2 
/// 
	@Override
	public void start(Stage primaryStage) throws Exception {
		getNavigationPane();
	}
	/// Ref: task 1.1
	public VBox getNavigationPane() {
		//VBox navBar =  new VBox();
		PdfWriter writer;
		BufferedImage[] img = null;
		try {
			writer = new PdfWriter("./target/result.pdf");
			
			PdfDocument doc = new PdfDocument(writer);
			//Document pdDoc = new Document(doc);
			Document document = new Document();
			document.setFile("./src/main/res/bookmarks.pdf");
			for (int i = 0; i < document.getNumberOfPages(); i++) {
		         BufferedImage bimage = (BufferedImage) document.getPageImage(i, GraphicsRenderingHints.PRINT, Page.BOUNDARY_CROPBOX, 0, 1);
		         
		         WritableImage jimage = SwingFXUtils.toFXImage(bimage, null);
		        //display image or add to array for display
		         if(jimage.isError()) {
		        	 System.out.println("Not found image: ");
		         }
		         else {
		        	 System.out.println("Image found");
		        	img[i] = bimage;
		        	 
		        	 
		         }
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e);
		}
		
		return null;
	}
	
	public void setThumbnail(WritableImage[] img) {
		
	}
/// Ref: task 1.3 
///	This method is called only after the [drag and drop event](Ref: task 1.2).	
	public void PdfReorder() {
		
	}
}
		

/**@}*/
