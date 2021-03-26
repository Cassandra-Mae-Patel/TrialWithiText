/**
 * 
 */
package com.cassandra.TrialWithIText;

import java.util.function.Supplier;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * @author Cassandra Mae
 *
 */
public class Drawing implements HandleingEvents {

    /**
     * The canvas to draw.
     */
    private MainCanvas canvas;

    /**
     * The color of the shape.
     */
    private Color color;

    /**
     * Generates a new shape object.
     */
    private Supplier<Shapes> shapeSupplier;

    /**
     * Current being drawn shape.
     */
    private Shapes currentShape;

    /**
     * Constructs a new drawing handler.
     * @param canvas canvas to draw
     * @param shapeSupplier shape generator
     * @param color color of the shape
     */
    public Drawing(MainCanvas canvas, Supplier<Shapes> shapeSupplier, Color color) {
        this.canvas = canvas;
        this.shapeSupplier = shapeSupplier;
        this.color = color;
    }

    @Override
    public void Event(MouseEvent e) {
        // when the mouse is pressed, create a new shape and add to the canvas if there is no shape
        if (e.getEventType() == MouseEvent.MOUSE_PRESSED && currentShape == null)
            addNewShape();

        if (currentShape != null) {
            // clear the last shape if the user presses and releases immediately
            if (e.getEventType() == MouseEvent.MOUSE_RELEASED && !currentShape.isValidShape())
                canvas.getShapes().remove(currentShape);
            // otherwise, tell the shape to handle the mouse event
            else
                currentShape.Event(e);

            canvas.update();
        }
    }

    @Override
    public void Event(KeyEvent e) {
        if (currentShape != null)
            currentShape.Event(e);
    }

    /**
     * Adds a new shape object to the canvas.
     */
    private void addNewShape() {
        currentShape = shapeSupplier.get();
        currentShape.setDidFinishDrawingCallback(() -> currentShape = null);
        currentShape.setColor(color);
        canvas.getShapes().add(currentShape);
    }
 
}