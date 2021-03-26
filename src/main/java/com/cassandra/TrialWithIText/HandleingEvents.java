/**
 * 
 */
package com.cassandra.TrialWithIText;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @author Cassandra Mae
 *
 */
public interface HandleingEvents {
	/**
	 * 
	 * @param mouseEvent the event to be handled when mouse clicked or dragged
	 * or released or pressed.
	 */
	void Event(MouseEvent mouseEvent);

	void Event(KeyEvent keyEvent);
}
