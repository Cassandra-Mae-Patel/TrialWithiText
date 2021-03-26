package com.cassandra.TrialWithIText;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SelectObjects extends Application {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Canvas canvas = new Canvas();
		
		 GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
		 
        canvas.setHeight(512);
        canvas.setWidth(512);
        
        graphicsContext2D.setFill(Color.valueOf("#ff0000"));
        graphicsContext2D.fillRect(100, 100, 200, 200);

        graphicsContext2D.setStroke(Color.valueOf("#0000ff"));
        graphicsContext2D.strokeRect(200, 200, 200, 200);
        graphicsContext2D.fillText("Hey There!", 12, 25);

        VBox vbox = new VBox(canvas);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
