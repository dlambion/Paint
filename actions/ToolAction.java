/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint - A
 */

package actions;

import gui.CanvasPanel;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import tools.Tool;

/**
 * Creates action listeners for the tool buttons.
 * 
 * @author Danielle Lambion
 * @version 16 May 2016
 */
public final class ToolAction extends AbstractAction 
{
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -2350104077789928002L;
    
    /**
     * The created shape.
     */
    private Shape myShape;
    
    /**
     * The panel used as a canvas for Power Paint.
     */
    private final CanvasPanel myCanvas;
    
    /**
     * The current tool of use.
     */
    private final Tool myTool;    
    

    /**
     * Constructor for ToolAction.
     * 
     * @param theCanvas the JPanel to be drawn upon.
     * @param theTool the tool currently being selected for use.
     */
    public ToolAction(final CanvasPanel theCanvas, final Tool theTool) 
    {
        super(theTool.getShape());
        myCanvas = theCanvas;
        myTool = theTool;
        myShape = null;
        
        myCanvas.addMouseListener(new MyMouseListener());
        myCanvas.addMouseMotionListener(new MyMouseListener());
        
        if (theTool.getShape().equals("Pencil"))
        {
            putValue(Action.SELECTED_KEY, true);
            myCanvas.setTool(theTool);
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) 
    {
        putValue(Action.SELECTED_KEY, true);
        myCanvas.setTool(myTool);
    }
    
    /**
     * Action Listener for the mouse commands in PowerPaint.
     */
    class MyMouseListener extends MouseAdapter
    {

        @Override
        public void mousePressed(final MouseEvent theEvent) 
        {
            if (myTool.getShape().equals((myCanvas.getTool()).getShape()))
            {
                myShape = myTool.setFirstPoint(theEvent.getX(), theEvent.getY());
                myCanvas.updateShape(myShape);
                myCanvas.repaint();
            }
        }

        @Override
        public void mouseReleased(final MouseEvent theEvent) 
        {
            putValue(Action.SELECTED_KEY, myTool.clear());
            if (myTool.getShape().equals((myCanvas.getTool()).getShape()))
            {
                myCanvas.addShape(myShape);
                myCanvas.repaint();
            }
        }

        @Override
        public void mouseDragged(final MouseEvent theEvent) 
        {
            if (myTool.getShape().equals((myCanvas.getTool()).getShape()))
            {
                myShape = myTool.setNextPoint(theEvent.getX(), theEvent.getY());
                myCanvas.updateShape(myShape);
                myCanvas.repaint();
            }
        }
    }

}
