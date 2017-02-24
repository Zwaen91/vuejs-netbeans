package org.netbeans.modules.js.vuejs2.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JToolTip;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;

/**
 *
 * @author sven
 */
public class Vuejs2ModifierCompletionItem extends Vuejs2CompletionItem {
    
    private final String modifier;

    public Vuejs2ModifierCompletionItem(String modifier, int dotOffset, int caretOffset) {
        super(dotOffset, caretOffset);
        
        this.modifier = modifier;
    }

    @Override
    public void defaultAction(JTextComponent jtc) {
        
    }

    @Override
    public void processKeyEvent(KeyEvent ke) {
        
    }

    @Override
    public int getPreferredWidth(Graphics graphics, Font font) {
        return CompletionUtilities.getPreferredWidth(this.modifier, null, graphics, font);
    }

    @Override
    public void render(Graphics g, Font defaultFont, Color defaultColor,
            Color backgroundColor, int width, int height, boolean selected) {
        CompletionUtilities.renderHtml(fieldIcon, this.modifier, null, g, defaultFont,
                (selected ? Color.white : fieldColor), width, height, selected);
    }

    @Override
    public CompletionTask createToolTipTask() {
        return new AsyncCompletionTask(new AsyncCompletionQuery() {
            @Override
            protected void query(CompletionResultSet completionResultSet, Document document, int i) {
                JToolTip toolTip = new JToolTip();
                toolTip.setTipText("Press Enter to insert \"" + modifier + "\"");
                completionResultSet.setToolTip(toolTip);
                completionResultSet.finish();
            }
        });
    }

    @Override
    public CharSequence getSortText() {
        return this.modifier;
    }

    @Override
    public CharSequence getInsertPrefix() {
        return this.modifier;
    }
    
}
