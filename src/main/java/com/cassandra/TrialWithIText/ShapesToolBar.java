/**
 * 
 */
package com.cassandra.TrialWithIText;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * @author Cassandra Mae
 *
 */
public class ShapesToolBar extends ToolBar {

    /**
     * Default selected color.
     */
    public static final Color DEFAULT_COLOR = Color.BLUE;

    /**
     * The canvas to draw on.
     */
    private MainCanvas canvas;

    /**
     * Color picker.
     */
    private ColorPicker colorPicker;

    /**
     * Group of radio buttons.
     */
    private ToggleGroup group;

    /**
     * The current selected tool.
     */
    private ToolsOptions selectedTool;

    /**
     * Constructs a toolbar.
     * @param canvas the canvas to draw
     */
    public ShapesToolBar(MainCanvas canvas) {
        this.canvas = canvas;
        group = new ToggleGroup();
        colorPicker = new ColorPicker(DEFAULT_COLOR);
        setupItems();
        setupHandlers();
    }

    /**
     * Sets up ui controls.
     */
    private void setupItems() {
        
        final RadioButton rectangleButton = new RadioButton("Rectangle");
        
        final RadioButton selectButton = new RadioButton("Select");

        
        rectangleButton.setToggleGroup(group);
        
        selectButton.setToggleGroup(group);
        

        
        rectangleButton.setUserData(ToolsOptions.RECTANGLE);
        
        selectButton.setUserData(ToolsOptions.SELECT);
        

        // default selection
        

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        spacer.setMinWidth(Region.USE_PREF_SIZE);
        getItems().addAll( rectangleButton,
                 spacer, selectButton, colorPicker);
    }

    /**
     * Sets up handlers.
     */
    private void setupHandlers() {
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                selectedTool = (ToolsOptions) group.getSelectedToggle().getUserData();
                canvas.setEventHandler(createEventHandler());
            }
        });

        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                canvas.setEventHandler(createEventHandler());
            }
        });
    }

    /**
     * Creates event handler depending on the selected tool and color.
     * @return a new event handler
     */
    private HandleingEvents createEventHandler() {
        Color selectedColor = colorPicker.getValue();
        switch (selectedTool) {
            
            case RECTANGLE:
                return new Drawing(canvas, ShapeRectangle::new, selectedColor);
            
            case SELECT:
                return new SelectTool(canvas);
            default:
                return null;
        }
    }
}
