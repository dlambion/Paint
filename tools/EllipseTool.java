/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.geom.Ellipse2D;

/**
 * A tool that creates the ellipse shape.
 * 
 * @author Danielle Lambion
 * @version 11 May 2016
 */
public class EllipseTool extends AbstractRectangleEllipse
{

    /**
     * Constructor for Ellipse Tool.
     */
    public EllipseTool() 
    {
        super(new Ellipse2D.Double());
    }
}
