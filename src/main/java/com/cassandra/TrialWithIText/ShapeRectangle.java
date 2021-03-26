/**
 * 
 */
package com.cassandra.TrialWithIText;

import java.util.Arrays;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * @author Cassandra Mae
 *
 */
public class ShapeRectangle extends Shapes {
	
	//protected   GraphicsContext graphicContext = null;
	// javafx.scene.shape.Rectangle bound;
	
	public ShapeRectangle() {
		pointsOfShape = Arrays.asList(null, null);
		
    }

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (pointsOfShape.get(0) == null || pointsOfShape.get(1) == null)
            return;
		//this.graphicContext =gc;

		gc.setFill(color);
        javafx.scene.shape.Rectangle bound = getBound();
        gc.fillRect(bound.getX(), bound.getY(), bound.getWidth(), bound.getHeight());
    }

	@Override
	public void Event(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		Point2D currentPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED)
        	pointsOfShape.set(0, currentPoint);
        else if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED)
        	pointsOfShape.set(1, currentPoint);
        else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED)
            didFinishDrawingCallback.run();
        
        	
        }
	

	@Override
	public void Event(KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HghlightShape(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(Shapes.selected) {
			
//			gc.setFill(Color.RED);
//			
//	        javafx.scene.shape.Rectangle bound = getBound();
//	        gc.fillRect(bound.getX(), bound.getY(), bound.getWidth(), bound.getHeight());

			javafx.scene.shape.Rectangle bound = getBound();
			gc.setLineWidth(7.0);
			bound.setStroke(Color.RED);
			gc.strokeRect(bound.getX(), bound.getY(), bound.getWidth(), bound.getHeight());
//	        bound.setStroke(Color.RED);
//	        bound.setStrokeWidth(30.0);
////	        javafx.scene.shape.Rectangle nurect = new javafx.scene.shape.Rectangle (bound.getX(), bound.getY(), bound.getWidth(), bound.getHeight());
////	        nurect.setStroke(Color.RED);
////	        nurect.setStrokeWidth(3.0);

	}

	
	}
}
  
	/*public  void  setHighlight() {
		// TODO Auto-generated method stub
		graphicContext.setFill(color.brighter());
	 graphicContext.fillRect(bound.getX(), bound.getY(), bound.getWidth(), bound.getHeight());
	  System.out.println("Hightlighted" );
	  
	}*/
	

	

	

