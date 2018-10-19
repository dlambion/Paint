/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint - A
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * A tool that creates a line shape.
 * 
 * @author Danielle Lambion
 * @version 7 May 2016
 */
public class LineTool extends AbstractTool
{
    /**
     * The line being created.
     */
    private Line2D myLine;
    
    /**
     * The point coordinates at which the line was begun.
     */
    private Point2D.Double myPoint;
    
    /**
     * Constructor for LineTool.
     */
    public LineTool()
    {
        super();
        myLine = new Line2D.Double();
        myPoint = new Point2D.Double();
    }
    
    /**
     * Begins the created line.
     * 
     * @param theX the current x-coordinate.
     * @param theY the current y-coordinate.
     * 
     * @return the started line.
     */
    public Shape setFirstPoint(final int theX, final int theY)
    {
        myPoint = new Point2D.Double(theX, theY);
        myLine = new Line2D.Double(myPoint, myPoint);
        return myLine;
    }
    
    /**
     * Changes the line as the cursor is moved.
     * 
     * @param theX the current x-coordinate.
     * @param theY the current y-coordinate.
     * 
     * @return the current line.
     */
    public Shape setNextPoint(final int theX, final int theY)
    {
        final Point2D movePoint = new Point2D.Double(theX, theY);
        myLine = new Line2D.Double(myPoint, movePoint);
        return myLine;
    }
}
