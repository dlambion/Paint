/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package gui;

import actions.FillColorChooserAction;
import actions.LineColorChooserAction;
import actions.ToolAction;
import icons.ColorIcon;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.KeyStroke;

/**
 * Creates the menu bar for Power Paint.
 * 
 * @author Danielle Lambion
 * @version 13 May 2016
 */
public class PowerPaintMenuBar extends JMenuBar
{
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -2132654790054568278L;
    
    /**
     * The spacing for major tick marks on the slider.
     */
    private static final int SLIDER_SPACING_MAJOR = 5;
    
    /**
     * The spacing for the minor tick marks on the slider.
     */
    private static final int SLIDER_SPACING_MINOR = 1;
    
    /**
     * The menu item that closes the program.
     */
    private final JMenuItem myQuitItem;
    
    /**
     * An array list holding all the actions for each individual tool.
     */
    private final List<ToolAction> myActions;
    
    /**
     * The drawing panel.
     */
    private final CanvasPanel myCanvas;

    /**
     * Constructs the menu bar for PowerPaint.
     * 
     * @param theFrame the JFrame containing this menu bar.
     * @param theCanvas the drawing panel.
     * @param theActions an array list containing all the actions for each tool.
     */
    public PowerPaintMenuBar(final JFrame theFrame, final CanvasPanel theCanvas, 
                             final List<ToolAction> theActions) 
    {
        super();
        myCanvas = theCanvas;
        myQuitItem = new JMenuItem("Quit");
        myActions = theActions;
        final LineColorChooserAction lineColorAction = 
                        new LineColorChooserAction("Draw Color...", myCanvas);
        final FillColorChooserAction fillColorAction = 
                        new FillColorChooserAction("Fill Color...", myCanvas);
        add(generateFileMenu(theFrame));
        add(generateOptionsMenu(lineColorAction, fillColorAction));
        add(generateToolsMenu());
        add(generateHelpMenu());
    }
    
    /**
     * Generates the File menu.
     * 
     * @return returns the file menu.
     * @param theFrame the JFrame containing this menu bar.
     */
    private JMenu generateFileMenu(final JFrame theFrame)
    {
        final JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        final JMenuItem clear = new JMenuItem("Clear");
        clear.setMnemonic(KeyEvent.VK_C);
        clear.addActionListener(theEvent ->
        {
            myCanvas.clearPanel();
        });

        myQuitItem.setMnemonic(KeyEvent.VK_Q);
        myQuitItem.addActionListener(theEvent -> 
        {
            theFrame.dispatchEvent(new WindowEvent(theFrame, WindowEvent.WINDOW_CLOSING));
        });
        
        file.add(clear);
        file.addSeparator();
        file.add(myQuitItem);
        
        return file;
    }
    
    /**
     * Generates the Options Menu.
     * 
     * @return returns the options menu.
     * @param theLineColorAction the action listener for the line color.
     * @param theFillColorAction the action listener for the fill color.
     */
    private JMenu generateOptionsMenu(final LineColorChooserAction theLineColorAction, 
                                      final FillColorChooserAction theFillColorAction)
    {
        final JMenu options = new JMenu("Options");
        options.setMnemonic(KeyEvent.VK_O);
        
        final JMenu thickness = new JMenu("Thickness");
        thickness.setMnemonic(KeyEvent.VK_T);
        
        final JMenuItem drawColor = new JMenuItem(theLineColorAction);
        drawColor.setIcon(new ColorIcon(myCanvas.getLineColor()));
        
        final JMenuItem fillColor = new JMenuItem(theFillColorAction);
        fillColor.setIcon(new ColorIcon(myCanvas.getFillColor()));
        
        final JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 1);
        slider.setMajorTickSpacing(SLIDER_SPACING_MAJOR);
        slider.setMinorTickSpacing(SLIDER_SPACING_MINOR);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        slider.addChangeListener(theEvent ->
        {
            myCanvas.setThickness((int) ((JSlider) theEvent.getSource()).getValue());
        });
        
        thickness.add(slider);
        
        final JCheckBoxMenuItem fill = new JCheckBoxMenuItem("Fill");
        fill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        fill.addActionListener(theEvent ->
        {
            myCanvas.setFilled(fill.isSelected());
        });
        
        options.add(thickness);
        options.addSeparator();
        options.add(drawColor);
        options.add(fillColor);
        options.addSeparator();
        options.add(fill);
        
        return options;
    }
    
    /**
     * Generates the tools menu.
     * 
     * @return returns the tools menu.
     */
    private JMenu generateToolsMenu()
    {
        final JMenu tools = new JMenu("Tools");
        tools.setMnemonic(KeyEvent.VK_T);
        
        final ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < myActions.size(); i++)
        {
            final JRadioButton b = new JRadioButton(myActions.get(i));
            bg.add(b);
            tools.add(b);
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
        return tools;
    }
    
    /**
     * Generates the Help menu.
     * 
     * @return returns the help menu.
     */
    private JMenu generateHelpMenu()
    {
        final JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        
        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener(theEvent ->
        {
            final String aboutMessage = "TCSS 305 PowerPaint\nSpring 2016\nDanielle Lambion";
            final ImageIcon icon = new ImageIcon(getClass().getResource
                                                 ("/images/icon_washington3.gif"));
            JOptionPane.showMessageDialog(new JFrame(), 
                                          aboutMessage, 
                                          "About", JOptionPane.INFORMATION_MESSAGE, icon);
        });
        
        help.add(about);
        
        return help;
    }

}
