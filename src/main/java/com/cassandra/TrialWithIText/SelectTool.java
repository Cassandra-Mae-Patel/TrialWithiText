/**
 * 
 */
package com.cassandra.TrialWithIText;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @author Cassandra Mae
 *
 */
public class SelectTool implements HandleingEvents {

	/**
	 * The canvas to draw.
	 */
	private MainCanvas canvas;

	/**
	 * The current selected shape.
	 */
	private Shapes selectedShape;

	/**
	 * Current pressed point.
	 */
	private Point2D pressedPoint;

	/**
	 * Constructs a new selection handler.
	 * 
	 * @param canvas canvas to handle selection
	 */
	public SelectTool(MainCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void Event(MouseEvent event) {
		Point2D currentPoint = new Point2D(event.getX(), event.getY());

        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            pressedPoint = currentPoint;
            selectedShape = null;
            for (Shapes obj : canvas.getShapes())
                if (obj.contains(currentPoint)) {
                    selectedShape = obj;
                    obj.setElementSelected(true);
                } else
                    obj.setElementSelected(false);

        } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            if (selectedShape != null) {
                Point2D transform = new Point2D(currentPoint.getX() - pressedPoint.getX(),
                        currentPoint.getY() - pressedPoint.getY());
                selectedShape.setTransform(transform);
            }

        } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
            if (selectedShape != null)
                selectedShape.applyTransform();
//        }else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
//        	pressedPoint = currentPoint;
//            selectedShape = null;
//        	for (Shapes obj : canvas.getShapes())
//                if (obj.contains(currentPoint)) {
//                    selectedShape = obj;
//                    obj.setElementSelected(true);
//                    
//                } else
//                    obj.setElementSelected(false);
               
        }
        

        canvas.update();
    }

    @Override
    public void Event(KeyEvent e) {
        if (selectedShape != null && e.getCode() == KeyCode.DELETE || e.getCode() == KeyCode.BACK_SPACE) {
            canvas.getShapes().remove(selectedShape);
            canvas.update();
        }
    }
}