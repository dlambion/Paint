/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package actions;

import gui.CanvasPanel; 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

/**
 * Creates a color chooser dialog for the color line.
 * 
 * @author Danielle Lambion
 * @version 19 May 2016
 */
public class LineColorChooserAction extends AbstractAction 
{

    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -883943717275605884L;
    
    /**
     * The panel being drawn upon.
     */
    private final CanvasPanel myCanvas;

    /**
     * Initializes the Actions Fields.
     * @param theText the Text for this Action. 
     * @param theCanvas the canvas panel that the shapes are drawn upon.
     */
    public LineColorChooserAction(final String theText, final CanvasPanel theCanvas) 
    {
        super(theText);

        myCanvas = theCanvas;
        
        putValue(MNEMONIC_KEY, KeyEvent.VK_D);
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) 
    {
        final Color result = JColorChooser.showDialog(null, "A Color Chooser", null);
        if (result != null) 
        {
            myCanvas.setLineColor(result);
        }
    }

}
