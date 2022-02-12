package View;

import java.util.ArrayList;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import SpellCorrector.*;

/**
 * Class for higlighting wrong words
 * @author Ahmet Sahin
 * @version 28.04.2021
*/ 
public class Highlight
{
    // Properties
    private JTextPane pane;
    private ArrayList<WrongWordResponse> list;
    private StyledDocument doc;
    FileOperatorForTheme fileOperator;
    Color color;

    // Constructors
    
    /**
     * Consture class that hilights wrong words
     * @param pane JTextPane that user write
     * @param wrongWords list of wrong words objects of type WrongWordResponse
     * @throws BadLocationException
     * @throws IOException
     */ 
    public Highlight ( JTextPane pane, ArrayList<WrongWordResponse> wrongWords) throws BadLocationException, IOException {
        this.pane = pane;
        list = wrongWords;  
        doc = pane.getStyledDocument(); 
        fileOperator = new FileOperatorForTheme();
        determineColor();
        highlightAll();
    }
    
    //Methods
    
    /**
     * Method to choose highlight color according to theme
    */ 
    private void determineColor() {
        if ( fileOperator.getMode().equals("Open Dark Mode") ) {
            color = Color.red;
        }
        else {
            color = Color.yellow;
        }
    }
    
    /**
     * Method that higlights all wrong words
     * @throws BadLocationException
    */ 
    private void highlightAll() throws BadLocationException {
        WrongWordResponse word;
        int start;
        int end;
        String firstForm;
        
        for ( int i = 0; i < list.size(); i++ ) {
            Style style = pane.addStyle("Red Style", null);
            StyleConstants.setForeground(style, color);
            word = list.get(i);
            start = word.getBeginIndex();
            end = word.getEndIndex();
            firstForm = doc.getText(start, end - start);
            doc.remove(start, end - start);
            doc.insertString(start, firstForm, style);
        }

    }    
}