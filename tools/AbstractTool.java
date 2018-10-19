/*
 * TCSS 305 - Spring 2016
 * Assignment 5 - PowerPaint
 */

package tools;

/**
 * Abstract parent class for all available tools in PowerPaint.
 * 
 * @author Danielle Lambion
 * @version 10 May 2016
 */
public abstract class AbstractTool implements Tool 
{
    /**
     * The "Tool" suffix.
     */
    private static final String TOOL_SUFFIX = "Tool";

    /**
     * The name of this tool (will be used on buttons).
     */
    private String myToolName;
    
    /**
     * Constructs a tool and modifies the class name for the name of the tool to 
     * not have "Tool" on the end, which is the name of the type of shape also. 
     */
    protected AbstractTool()
    {
        final String name = getClass().getName();
        final int dot = name.lastIndexOf('.');
        if (dot >= 0 && name.endsWith(TOOL_SUFFIX))
        {
            myToolName = name.substring(dot + 1, name.length() - TOOL_SUFFIX.length());
        }
        else
        {
            myToolName = name.substring(dot + 1, name.length());
        }
    }
    
    /* (non-Javadoc)
     * @see tools.Tool#getToolName()
     */
    @Override
    public String getShape() 
    {
        return myToolName;
    }
    
    /* (non-Javadoc)
     * @see tools.Tool#clearPanel()
     */
    @Override
    public boolean clear()
    {
        return false;
    }
}
