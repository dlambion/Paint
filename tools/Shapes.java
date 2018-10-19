/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Color;
import java.awt.Shape;

/**
 * Encapsulates a created shape with its properties.
 * 
 * @author Danielle Lambion
 * @version 18 May 2016
 */
public class Shapes 
{
    /**
     * The shape to be encapsulated.
     */
    private final Shape myShape;
    
    /**
     * The line thickness for the shape.
     */
    private final int myThickness;
    
    /**
     * The color for the shape line.
     */
    private final Color myLineColor;
    
    /**
     * The color for the shape fill.
     */
    private final Color myFillColor;
    
    /**
     * Whether filled or not.
     */
    private boolean myFilled;

    /**
     * Constructor for Shape.
     * 
     * @param theShape the shape to be encapsulated.
     * @param theThickness the selected line thickness for the shape.
     * @param theFillColor the selected fill color for the shape.
     * @param theLineColor the selected line color for the shape.
     * @param theFilled a boolean representing whether the shape is filled.
     */
    public Shapes(final Shape theShape, final int theThickness, final Color theFillColor, 
                  final Color theLineColor, final boolean theFilled) 
    {
        super();
        myShape = theShape;
        myThickness = theThickness;
        myFillColor = theFillColor;
        myLineColor = theLineColor;
        myFilled = theFilled;
    }
    
    /**
     * Retrieves the shape.
     * 
     * @return the current shape be painted.
     */
    public Shape getShape()
    {
        return myShape;
    }
    
    /**
     * Retrieves the line thickness of the shape.
     * 
     * @return an integer representing the line thickness.
     */
    public int getThickness()
    {
        return myThickness;
    }
    
    /**
     * Retrieves the line color of the shape.
     * 
     * @return the line color of the shape.
     */
    public Color getLineColor()
    {
        return myLineColor;
    }
    
    /**
     * Retrieves the fill color of the shape.
     * 
     * @return the fill color of the shape.
     */
    public Color getFillColor()
    {
        return myFillColor;
    }
    
    /**
     * Returns whether is filled.
     * 
     * @return returns whether filled as a boolean.
     */
    public boolean getFilled()
    {
        return myFilled;
    }
    

}
