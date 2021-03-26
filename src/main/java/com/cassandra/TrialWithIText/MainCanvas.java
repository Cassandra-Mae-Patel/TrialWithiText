/**
 * 
 */
package com.cassandra.TrialWithIText;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Cassandra Mae
 *
 */
public class MainCanvas extends Pane {

    /**
     * The canvas.
     */
    protected Canvas canvas;

    /**
     * Holds a list of shapes to render on the canvas.
     */
    private List<Shapes> shapes;

    /**
     * A handler corresponding to the current selected tool.
     */
    private HandleingEvents eventHandler;

    /**
     * Constructs the canvas pane.
     */
    public MainCanvas() {
        canvas = new Canvas(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        shapes = new ArrayList<>();
        getChildren().add(canvas);

        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                eventHandler.Event(e);
            }
        };

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, handler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, handler);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    /**
     * Getter for shapes.
     * @return list of shapes
     */
    public List<Shapes> getShapes() {
        return shapes;
    }

    /**
     * Getter for event handler.
     * @return the current event handler
     */
    public HandleingEvents getEventHandler() {
        return eventHandler;
    }

    /**
     * Setter for event handler.
     * @param eventHandler new event handler
     */
    public void setEventHandler(HandleingEvents eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * Clears the canvas.
     * @param color the background color of the canvas after clearing
     */
    public void clear(Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /**
     * Clears the canvas with a white background.
     */
    public void clear() {
        clear(Color.WHITE);
    }

    /**
     * Draw all the shapes onto the canvas.
     */
    private void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (Shapes myShape : shapes)
            myShape.draw(gc);
        	shapes.get(0).HghlightShape(gc);
//        if(shapes.size()!=0) {
//        	for(int i =0; i<shapes.size();i++) {
//        		Shapes myShape = shapes.get(i);
//        		if(myShape.selected) {
//        			myShape.HghlightShape(gc);
//        		}
//        	}
//        }
        }
        	

    /**
     * Update the canvas by clearing and redrawing the shapes.
     */
    public void update() {
        clear();
        render();
    }

    /**
     * Deselects any selected shape.
     */
    private void deselectShapes() {
        for (Shapes shape : shapes)
            shape.setElementSelected(false);
        update();
    }

//	public GraphicsContext getGraphicsContextMainCanvas() {
//		GraphicsContext gc = canvas.getGraphicsContext2D();
//    	return gc;
//	}
//	
//    public void setHighlight() {
//    	GraphicsContext gc = canvas.getGraphicsContext2D();
//    }
}




//if(myShape.isShapeSelected==true) {
//	myShape.setHighlight(gc);
//}
//}

//if(shapes.size()!=0) {
//for(int i =0; i<=shapes.size();i++) {
//	Shapes myShape = shapes.get(i);
//	if(myShape.isShapeSelected) {
//		myShape.setHighlight(gc);
//	}
//}
//}
