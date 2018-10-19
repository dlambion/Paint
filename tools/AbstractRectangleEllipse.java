/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * An abstract class for shapes that extend the RectangularShape class.
 * 
 * @author Danielle Lambion
 * @version 11 May 2016
 */
public abstract class AbstractRectangleEllipse extends AbstractTool 
{
    
    /**
     * The rectangle or ellipse shape being created.
     */
    private RectangularShape myShape;
    
    /**
     * The point x-coordinate at which the shape was begun.
     */
    private Point2D.Double myPoint;

    /**
     * Constructor for an ellipse or rectangle shape.
     * 
     * @param theShape the specific type of shape being created.
     */
    public AbstractRectangleEllipse(final RectangularShape theShape) 
    {
        super();
        myShape = theShape;
        myPoint = new Point2D.Double();
    }

    /* (non-Javadoc)
     * @see tools.Tool#setFirstPoint(int, int)
     */
    @Override
    public Shape setFirstPoint(final int theX, final int theY) 
    {
        myPoint = new Point2D.Double(theX, theY);
        myShape.setFrameFromDiagonal(myPoint, myPoint);
        return (RectangularShape) myShape.clone();
    }

    /* (non-Javadoc)
     * @see tools.Tool#setNextPoint(int, int)
     */
    @Override
    public Shape setNextPoint(final int theX, final int theY) 
    {
        final Point2D movePoint = new Point2D.Double(theX, theY);
        myShape.setFrameFromDiagonal(myPoint, movePoint);
        return (RectangularShape) myShape.clone();
    }

}
