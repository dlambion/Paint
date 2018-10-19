/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * A tool that creates a pencil shape.
 * 
 * @author Danielle Lambion
 * @version 11 May 2016
 */
public class PencilTool extends AbstractTool 
{
    /**
     * The line being created.
     */
    private Path2D myPencil;
    
    /**
     * Constructor for Pencil Tool.
     */
    public PencilTool() 
    {
        super();
        myPencil = new Path2D.Double();
    }

    /* (non-Javadoc)
     * @see tools.Tool#setFirstPoint(int, int)
     */
    @Override
    public Shape setFirstPoint(final int theX, final int theY) 
    {
        myPencil.moveTo(theX, theY);
        return myPencil;
    }

    /* (non-Javadoc)
     * @see tools.Tool#setNextPoint(int, int)
     */
    @Override
    public Shape setNextPoint(final int theX, final int theY) 
    {
        myPencil.lineTo(theX, theY);
        return myPencil;
    }
    
    /* (non-Javadoc)
     * @see tools.Tool#clearPanel()
     */
    @Override
    public boolean clear()
    {
        myPencil = new Path2D.Double();
        return false;
    }

}
