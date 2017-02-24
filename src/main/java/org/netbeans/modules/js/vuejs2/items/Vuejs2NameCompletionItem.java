package org.netbeans.modules.js.vuejs2.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JToolTip;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.netbeans.api.editor.completion.Completion;
import org.netbeans.modules.js.vuejs2.Match;
import static org.netbeans.modules.js.vuejs2.items.Vuejs2CompletionItem.fieldIcon;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.openide.util.Exceptions;

/**
 *
 * @author sven
 */
public class Vuejs2NameCompletionItem extends Vuejs2CompletionItem {

    protected final Match match;

    public Vuejs2NameCompletionItem(Match match, int dotOffset, int caretOffset) {
        super(dotOffset, caretOffset);

        this.match = match;
    }

    @Override
    public void defaultAction(JTextComponent jtc) {
        try {
            StyledDocument doc = (StyledDocument) jtc.getDocument();
            //Here we remove the characters starting at the start offset
            //and ending at the point where the caret is currently found:
            doc.remove(dotOffset, caretOffset - dotOffset);
            doc.insertString(dotOffset, this.match.completion, null);
            jtc.setCaretPosition(this.match.getPosition(dotOffset));
            Completion.get().hideAll();
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public int getPreferredWidth(Graphics graphics, Font font) {
        return CompletionUtilities.getPreferredWidth(this.match.directive.name, null, graphics, font);
    }

    @Override
    public void render(Graphics g, Font defaultFont, Color defaultColor,
            Color backgroundColor, int width, int height, boolean selected) {
        CompletionUtilities.renderHtml(fieldIcon, this.match.directive.name, null, g, defaultFont,
                (selected ? Color.white : fieldColor), width, height, selected);
    }

    @Override
    public CompletionTask createToolTipTask() {
        return new AsyncCompletionTask(new AsyncCompletionQuery() {
            @Override
            protected void query(CompletionResultSet completionResultSet, Document document, int i) {
                JToolTip toolTip = new JToolTip();
                toolTip.setTipText("Press Enter to insert \"" + match.directive.name + "\"");
                completionResultSet.setToolTip(toolTip);
                completionResultSet.finish();
            }
        });
    }

    @Override
    public CharSequence getSortText() {
        return this.match.directive.name;
    }

    @Override
    public CharSequence getInsertPrefix() {
        return this.match.directive.name;
    }
}
