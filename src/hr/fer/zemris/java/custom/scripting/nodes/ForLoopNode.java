package hr.fer.zemris.java.custom.scripting.nodes;

import com.sun.istack.internal.Nullable;
import hr.fer.zemris.java.custom.scripting.elems.Element;
import hr.fer.zemris.java.custom.scripting.elems.ElementVariable;

/**
 * Created by akarlovic on 19.1.2017..
 */
public class ForLoopNode extends Node {
    private ElementVariable variable;
    private Element startExpression;
    private Element endExpression;
    private Element stepExpression;

    public ForLoopNode(ElementVariable var, Element start, Element end, Element step){
        variable = var;
        startExpression = start;
        endExpression = end;
        startExpression = step;
    }

    public ElementVariable getVariable() { return variable; }

    public Element getStartExpression() {
        return startExpression;
    }

    public Element getEndExpression() {
        return endExpression;
    }

    public Element getStepExpression() {
        return stepExpression;
    }
}
