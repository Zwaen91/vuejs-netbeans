package org.netbeans.modules.js.vuejs2.items;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.text.JTextComponent;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.openide.util.ImageUtilities;

/**
 *
 * @author sven
 */
public abstract class Vuejs2CompletionItem implements CompletionItem {

    protected static final ImageIcon fieldIcon = new ImageIcon(ImageUtilities.loadImage(
            "org/netbeans/modules/js/vuejs2/vuejs16.png"
    ));
    protected static final Color fieldColor = Color.decode("0x0000B2");
    protected final int caretOffset;
    protected final int dotOffset;

    public Vuejs2CompletionItem(int dotOffset, int caretOffset) {
        this.dotOffset = dotOffset;
        this.caretOffset = caretOffset;
    }

    @Override
    public void processKeyEvent(KeyEvent ke) {

    }

    @Override
    public CompletionTask createDocumentationTask() {
        return null;
    }

    @Override
    public boolean instantSubstitution(JTextComponent jtc) {
        return false;
    }

    @Override
    public int getSortPriority() {
        return 0;
    }
}
