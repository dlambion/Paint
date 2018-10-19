/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.geom.Rectangle2D;

/**
 * A tool that creates a rectangle shape.
 * 
 * @author Danielle Lambion
 * @version 11 May 2016
 */
public class RectangleTool extends AbstractRectangleEllipse
{

    /**
     * Constructor for Rectangle Tool.
     */
    public RectangleTool() 
    {
        super(new Rectangle2D.Double());
    }
}
