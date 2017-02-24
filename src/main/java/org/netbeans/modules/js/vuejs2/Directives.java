package org.netbeans.modules.js.vuejs2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 */
public class Directives {

    public List<Directive> directives;

    public Directives() {
        directives = new ArrayList<Directive>();
        directives.add(new Directive("v-text", Directive.Expectation.STRING));
        directives.add(new Directive("v-html", Directive.Expectation.STRING));
        directives.add(new Directive("v-show", Directive.Expectation.STRING));
        directives.add(new Directive("v-if", Directive.Expectation.STRING));
        directives.add(new Directive("v-else", Directive.Expectation.NONE));
        directives.add(new Directive("v-else-if", Directive.Expectation.STRING));

        directives.add(new Directive("v-for", new Directive.Expectation[]{
            Directive.Expectation.STRING,
            Directive.Expectation.NUMBER,
            Directive.Expectation.OBJECT,
            Directive.Expectation.ARRAY
        }));

        directives.add(new Directive("v-on", new Directive.Expectation[]{
            Directive.Expectation.FUNCTION,
            Directive.Expectation.INLINE_STATEMENT
        }, "@", new String[]{
            "stop", "prevent", "capture", "self", "native", "once"
        }, new String[0]));

        directives.add(new Directive("v-bind", new Directive.Expectation[]{
            Directive.Expectation.FUNCTION,
            Directive.Expectation.INLINE_STATEMENT
        }, ":", new String[]{
            "stop", "prevent", "capture", "self", "native", "once"
        }, new String[0]));
    }

    public List<Directive> getDirectives() {
        return this.directives;
    }

}
