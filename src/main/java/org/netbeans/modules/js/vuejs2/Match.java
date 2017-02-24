package org.netbeans.modules.js.vuejs2;

/**
 *
 * @author Sven
 */
public class Match {

    public final Field field;
    public final String filter;
    public final Directive directive;
    public String completion;

    Match(String filter, Field field, Directive directive) {
        this.filter = filter;
        this.field = field;
        this.directive = directive;

        this.completion = (field == Field.SHORTHAND) ? directive.shortHand : directive.name;

        if (directive.expects.length == 1 && directive.expects[0] == Directive.Expectation.NONE) {
            return;
        }

        if (directive.shortHand != null && filter.length() == directive.shortHand.length()) {
            return;
        }

        this.completion += "=\"\"";
    }

    public int getPosition(int dotOffset) {
        int position = completion.length() + dotOffset;

        if (directive.expects.length == 1 && directive.expects[0] == Directive.Expectation.NONE) {
            return position;
        }
        
        if (directive.shortHand != null && filter.length() == directive.shortHand.length()) {
            return position;
        }

        return position - 1;
    }

    public enum Field {
        NAME,
        SHORTHAND,
        MODIFIER
    }
}
