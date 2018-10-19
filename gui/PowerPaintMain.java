/*

 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint - A
 */

package gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Runs PowerPaint by instantiating and starting the GUI.
 * 
 * @author Danielle Lambion
 * @version 7 May 2016
 */
public final class PowerPaintMain
{

    /**
     * Private constructor for prevention of instantiation.
     */
    private PowerPaintMain()
    {
        throw new IllegalStateException();
    }

    /**
     * Invokes the PowerPaint GUI.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs)
    {
        try 
        {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } 
        catch (final UnsupportedLookAndFeelException ex) 
        {
            ex.printStackTrace();
        } 
        catch (final IllegalAccessException ex) 
        {
            ex.printStackTrace();
        } 
        catch (final InstantiationException ex) 
        {
            ex.printStackTrace();
        } 
        catch (final ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new PowerPaintGUI().start();
            }
        });
    }
}
