/**
 * 
 */
package com.cassandra.TrialWithIText;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * @author Cassandra Mae
 *
 */
public class Main extends Application {
	 public static final int WINDOW_WIDTH = 800;
	    public static final int WINDOW_HEIGHT = 600;

	    @Override
	    public void start(Stage primaryStage) throws Exception {
	        MainCanvas canvas = new MainCanvas();
	        VBox box = new VBox();
	        box.getChildren().addAll(new ShapesToolBar(canvas), canvas);

	        Scene scene = new Scene(box, WINDOW_WIDTH, WINDOW_HEIGHT);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Let's draw!");
	        primaryStage.setResizable(false);
	        primaryStage.show();

	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	                canvas.getEventHandler().Event(event);
	            }
	        });
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}
