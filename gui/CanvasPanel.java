/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint - A
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tools.PencilTool;
import tools.Shapes;
import tools.Tool;

/**
 * Creates the JPanel to be used as a drawing canvas.
 * 
 * @author Danielle Lambion
 * @version 7 May 2016
 */
public class CanvasPanel extends JPanel
{

    /**
     *  A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = 3482189860683134467L;
    
    /**
     * The pixel width for the drawing panel.
     */
    private static final int CANVAS_WIDTH = 600; 
    
    /**
     * The pixel height for the drawing panel.
     */
    private static final int CANVAS_HEIGHT = 300;
    
    /**
     * Custom color, "UW Purple", to be set as default drawing color.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    
    /**
     * Custom color, "UW Gold", to be set as default fill color.
     */
    private static final Color UW_GOLD = new Color(232, 211, 162);
    
    /**
     * The current color selected for drawing.
     */
    private Color myLineColor;
    
    /**
     * The current color selected for fill.
     */
    private Color myFillColor;
    
    /**
     * The current thickness of the drawing tool.
     */
    private int myThickness;
    
    /**
     * My current selected tool for use.
     */
    private Tool myTool;
    
    /**
     * A list to hold the shapes already drawn.
     */
    private final List<Shapes> myDrawnShapes;
    
    /**
     * The shape currently being created.
     */
    private Shape myShape;
    
    /**
     * A boolean flag to check whether there is a shape in process that needs drawing, 
     * as well as any stored previous drawings.
     */
    private boolean myStatus;
    
    /**
     * Checks if filled.
     */
    private boolean myFilled;
    
    /**
     * Constructor for CanvasPanel.
     */
    public CanvasPanel()
    {
        super();
        setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        setBackground(Color.WHITE);
        generateDefaults();
        myDrawnShapes = new ArrayList<Shapes>();
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());
        myFilled = false;
    }
    
    /**
     * Sets whether shape filled.
     * 
     * @param theFill whether is filled.
     */
    public void setFilled(final boolean theFill)
    {
        myFilled = theFill;
    }
    
    /**
     * Generates the default option status of Power paint.
     */
    private void generateDefaults()
    {
        myLineColor = UW_PURPLE;
        myFillColor = UW_GOLD;
        myThickness = 1;
        myTool = new PencilTool();
        myStatus = false;
    }
    
    /**
     * Adds the shape to an array list of currently completed shapes.
     * 
     * @param theShape the most recent shape to be added.
     */
    public void addShape(final Shape theShape)
    {
        final Shapes completeShape = new Shapes(theShape, myThickness, 
                                                myFillColor, myLineColor, myFilled);
        myDrawnShapes.add(completeShape);
        myStatus = false;
    }
    
    /**
     * Updates a shape in process.
     * 
     * @param theShape the shape that is in process of creation.
     */
    public void updateShape(final Shape theShape)
    {
        myShape = theShape;
        myStatus = true;
    }
    
    /**
     * Sets the desired tool for use.
     * 
     * @param theTool the tool to be set for use.
     */
    public void setTool(final Tool theTool)
    {
        myTool = theTool;
    }
    
    /**
     * Retrieves the type of tool being used.
     * 
     * @return myTool the current tool type in use.
     */
    public Tool getTool()
    {
        return myTool;
    }
    
    /**
     * Sets the line color.
     * 
     * @param theLineColor the color to be set as the line color.
     */
    public void setLineColor(final Color theLineColor)
    {
        myLineColor = theLineColor;
    }
    
    /**
     * Sets the fill color.
     * 
     * @param theFillColor the color to be set as the line color.
     */
    public void setFillColor(final Color theFillColor)
    {
        myFillColor = theFillColor;
    }
    
    /**
     * Retrieves the currently selected line color.
     * 
     * @return myLineColor the currently selected color.
     */
    public Color getLineColor()
    {
        return myLineColor;
    }
    
    /**
     * Retrieves the currently selected fill color.
     * 
     * @return myFillColor the currently selected color.
     */
    public Color getFillColor()
    {
        return myFillColor;
    }
    
    /**
     * Sets the thickness of a line.
     * 
     * @param theThickness the width size as an integer.
     */
    public void setThickness(final int theThickness)
    {
        myThickness = theThickness;
    }
    
    /**
     * Retrieves the currently selected line thickness.
     * 
     * @return myThickness the current line thickness as an intger.
     */
    public int getThickness()
    {
        return myThickness;
    }
    
    /**
     * Clears the canvas panel.
     */
    public void clearPanel()
    {
        myDrawnShapes.clear();
        myStatus = false;
        repaint();
    }
    
    @Override
    public void paintComponent(final Graphics theGraphic)
    {
        super.paintComponent(theGraphic);
        final Graphics2D graphic = (Graphics2D) theGraphic;
        for (int i = 0; i < myDrawnShapes.size(); i++)
        {
            if (myDrawnShapes.get(i).getFilled())
            {
                graphic.setColor(myDrawnShapes.get(i).getFillColor());
                graphic.fill(myDrawnShapes.get(i).getShape());
            }
            graphic.setColor(myDrawnShapes.get(i).getLineColor());
            graphic.setStroke(new BasicStroke(myDrawnShapes.get(i).getThickness()));
            graphic.draw(myDrawnShapes.get(i).getShape());
        }
        
        if (myStatus)
        {
            if (myFilled)
            {
                graphic.setColor(myFillColor);
                graphic.fill(myShape);
            }
            graphic.setColor(myLineColor);
            graphic.setStroke(new BasicStroke(myThickness));
            graphic.draw(myShape);
        }
    }
    
    /**
     * Action Listener for the mouse commands in PowerPaint.
     */
    class MyMouseListener extends MouseAdapter
    {
        
        @Override
        public void mouseEntered(final MouseEvent theEvent) 
        {
            final Cursor cursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR); 
            setCursor(cursor);
        }

        @Override
        public void mouseExited(final MouseEvent theEvent) 
        {
            final Cursor cursor = Cursor.getDefaultCursor();
            setCursor(cursor);
        }
    }
    
}

