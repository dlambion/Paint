/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package icons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * Creates the small icon on the buttons for color choosing.
 * 
 * @author Danielle Lambion
 * @version 19 May 2016
 */
public class ColorIcon implements Icon 
{
    /**
     * Width of the icon.
     */
    private static final int WIDTH = 16;
    
    /**
     * Height of the icon.
     */
    private static final int HEIGHT = 16;
    
    /**
     * Color of the icon.
     */
    private Color myColor;

    /**
     * Constructor for the color icon.
     * 
     * @param theColor takes in the currently selected color.
     */
    public ColorIcon(final Color theColor) 
    {
        myColor = theColor;
    }

    /* (non-Javadoc)
     * @see javax.swing.Icon#getIconHeight()
     */
    @Override
    public int getIconHeight() 
    {
        return HEIGHT;
    }

    /* (non-Javadoc)
     * @see javax.swing.Icon#getIconWidth()
     */
    @Override
    public int getIconWidth() 
    {
        return WIDTH;
    }

    /* (non-Javadoc)
     * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
     */
    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphic, 
                          final int theX, final int theY) 
    {
        final Graphics2D graphic = (Graphics2D) theGraphic;
        graphic.setColor(myColor);
        graphic.fillRect(theX,  theY, WIDTH, HEIGHT);
    }

}
