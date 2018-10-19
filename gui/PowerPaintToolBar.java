/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package gui;

import actions.ToolAction;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Creates the tool bar for Power Paint.
 * 
 * @author Danielle Lambion
 * @version 13 May 2016
 */
public class PowerPaintToolBar extends JToolBar
{   
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -5830885807365046415L;
    
    /**
     * An array list holding all the actions for each individual tool.
     */
    private final List<ToolAction> myActions;

    /**
     * Constructs the tool bar.
     * 
     * @param theActions an array list containing all the actions for each tool.
     */
    public PowerPaintToolBar(final List<ToolAction> theActions) 
    {
        super();
        myActions = theActions;
        generateButtons();
    }
    
    /**
     * Generates the tool buttons for the tool bar.
     */
    private void generateButtons()
    {
        final ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < myActions.size(); i++)
        {
            final JToggleButton b = new JToggleButton(myActions.get(i));
            add(b);
            bg.add(b);
            if (i == 0)
            {
                b.setMnemonic(KeyEvent.VK_P);
            }
            else if (i == 1)
            {
                b.setMnemonic(KeyEvent.VK_L);
            }
            else if (i == 2)
            {
                b.setMnemonic(KeyEvent.VK_R);
            }
            else
            {
                b.setMnemonic(KeyEvent.VK_E);
            }
        }
    }
}
