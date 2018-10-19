/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;

/**
 * Interface for available tools in PowerPaint.
 * 
 * @author Danielle Lambion
 * @version 10 May 2016
 */
public interface Tool 
{
    
    /**
     * Retrieves the name of the shape type.
     * 
     * @return returns the shape type as a String.
     */
    String getShape();
    
    /**
     * Sets the first point of the shape being created.
     * 
     * @param theX the current x-coordinate starting the shape.
     * @param theY the current y-coordinate starting the shape.
     * 
     * @return returns the begun shape.
     */
    Shape setFirstPoint(int theX, int theY);
    
    /**
     * Sets the next point in creation of a shape.
     * 
     * @param theX the current x-coordinate for the next point in the shape.
     * @param theY the current y-coordinate for the next point in the shape.
     * 
     * @return returns the current status of the shape.
     */
    Shape setNextPoint(int theX, int theY);
    
    /**
     * A method to notify whether pencil should be cleared.
     * 
     * @return a boolean representing whether a new pencil is created.
     */
    boolean clear();

}
