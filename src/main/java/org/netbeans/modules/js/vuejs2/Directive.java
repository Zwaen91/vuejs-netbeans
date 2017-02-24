package org.netbeans.modules.js.vuejs2;

/**
 *
 * @author Sven
 */
public class Directive {

    public String name;
    public Expectation[] expects;
    public String shortHand;
    public String[] modifiers = new String[0];
    public String[] limitations = new String[0];

    public String input;

    public Directive(String name, Expectation expects) {
        this(name, new Expectation[]{expects});
    }

    public Directive(String name, Expectation[] expects) {
        this.name = name;
        this.expects = expects;
    }

    public Directive(String name, Expectation[] expects, String shortHand, String[] modifiers, String[] limitations) {
        this.name = name;
        this.expects = expects;
        this.shortHand = shortHand;
        this.modifiers = modifiers;
        this.limitations = limitations;
    }

    public Match matches(String filter) {
        Match match = null;

        if (name.startsWith(filter)) {
            if (filter.endsWith(".") && modifiers.length > 0) {
                match = new Match(filter, Match.Field.MODIFIER, this);
            } else {
                match = new Match(filter, Match.Field.NAME, this);
            }
        } else if (shortHand != null && shortHand.startsWith(filter)) {
            if (filter.endsWith(".") && modifiers.length > 0) {
                match = new Match(filter, Match.Field.MODIFIER, this);
            } else {
                match = new Match(filter, Match.Field.SHORTHAND, this);
            }
        }

        return match;
    }

    public enum Expectation {
        NONE,
        NUMBER,
        STRING,
        ARRAY,
        OBJECT,
        FUNCTION,
        INLINE_STATEMENT,
        ANY
    }
}
