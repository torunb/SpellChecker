package View;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import View.StyleListener.*;

/**
 * This class creates style editor for the text has been entered by the user (bold, italic, etc.)
 * @author boran
 * @version 29.04.2021
 */ 

public class StyleButtonCreator 
{
    // Properties
    JMenuBar menu;
    
    // constructors
    /**
     * Construct a menu bar
     */ 
    public StyleButtonCreator() 
    {
        menu = new JMenuBar();
        initialize();
    } 
    
    // program code
    
    /**
     * This method initializes the window that we first see
     */ 
    private void initialize() {
        
        // create style button in the menu   
        JMenu styleMenu = new JMenu();
        styleMenu.setText("Style");

        // create bold action and name it bold, then add this to style menu
        Action boldAction = new BoldAction();
        boldAction.putValue(Action.NAME, "Bold");
        styleMenu.add(boldAction);

        // create italic action and name it bold, then add this to style menu
        Action italicAction = new ItalicAction();
        italicAction.putValue(Action.NAME, "Italic");
        styleMenu.add(italicAction);

        // create foreground action and name it bold, then add this to style menu
        Action foregroundAction = new ForegroundAction();
        foregroundAction.putValue(Action.NAME, "Color");
        styleMenu.add(foregroundAction);

        // create font and size action and name it bold, then add this to style menu
        Action formatTextAction = new FontAndSizeAction();
        formatTextAction.putValue(Action.NAME, "Font and Size");
        styleMenu.add(formatTextAction);

        menu.add(styleMenu);
    }
    
    /**
     * Getter method for menu
     */ 
    public JMenuBar getStyleMenu() {
        return menu;   
    }
} // end class StyleButton Creator