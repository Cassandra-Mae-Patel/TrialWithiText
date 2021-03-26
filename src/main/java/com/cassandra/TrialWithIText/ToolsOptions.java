/**
 * 
 */
package com.cassandra.TrialWithIText;

/**
 * @author Cassandra Mae
 *
 */
public enum ToolsOptions {
	RECTANGLE("Rectangle"),
	SELECT("Select");
	
	public final String label;
	
	ToolsOptions(String label) {
        this.label = label;
    }
}
