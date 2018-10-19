/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint - A
 */

package gui;

import actions.ToolAction;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import tools.EllipseTool;
import tools.LineTool;
import tools.PencilTool;
import tools.RectangleTool;

/**
 * Creates the GUI for PowerPaint.
 * 
 * @author Danielle Lambion
 * @version 7 May 2016
 */
public class PowerPaintGUI extends JFrame 
{

    /**
     *  A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = 7179759619787348390L;
    
    /**
     * Menu Bar for PowerPaint.
     */
    private final PowerPaintMenuBar myMenuItems;
    
    /**
     * The JToolBar with the tool buttons.
     */
    private final PowerPaintToolBar myMenuTools;
    
    /**
     * The drawing panel.
     */
    private final CanvasPanel myCanvas;
    
    /**
     * An array list holding all the actions for each individual tool.
     */
    private final List<ToolAction> myActions;

    /**
     * Constructor for PowerPaintGUI.
     */
    public PowerPaintGUI() 
    {
        super("PowerPaint");
        myCanvas = new CanvasPanel();
        myActions = new ArrayList<ToolAction>();
        generateActions();
        myMenuItems = new PowerPaintMenuBar(this, myCanvas, myActions);
        myMenuTools = new PowerPaintToolBar(myActions);
    }
    
    /**
     * Adds the different available tool actions to the listener.
     */
    private void generateActions()
    {
        myActions.add(new ToolAction(myCanvas, new PencilTool()));
        myActions.add(new ToolAction(myCanvas, new LineTool()));
        myActions.add(new ToolAction(myCanvas, new RectangleTool()));
        myActions.add(new ToolAction(myCanvas, new EllipseTool()));
    }
    
    /**
     * Generates and makes the GUI visible for PowerPaint.
     */
    public void start()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setJMenuBar(myMenuItems);
        add(myMenuTools, BorderLayout.SOUTH);
        add(myCanvas, BorderLayout.CENTER);
        
        final ImageIcon icon = new ImageIcon(getClass().getResource
                                             ("/images/icon_washington3.gif"));
        setIconImage(icon.getImage());
        
        pack();
        
        setVisible(true);
    }
}
