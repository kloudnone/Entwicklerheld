package de.devboost.entwicklerheldchallenge;

import de.devboost.entwicklerheldchallenge.model.Assignment;
import de.devboost.entwicklerheldchallenge.model.CannotDoMuchProgram;
import de.devboost.entwicklerheldchallenge.model.Expression;
import de.devboost.entwicklerheldchallenge.model.IntegerLiteral;
import de.devboost.entwicklerheldchallenge.model.Statement;
import de.devboost.entwicklerheldchallenge.model.VariableReference;

public class CannotDoMuchProgramAnalyzer {

    public boolean analyze(CannotDoMuchProgram program, String variableName, int value) {
        for (Statement stmt : program.getStatements()) {
            if (stmt instanceof Assignment) {
                Assignment assignment = (Assignment)stmt;

                if (assignment.getVariableName() == variableName) {
                    Expression expression = assignment.getExpression();
                    if (expression instanceof IntegerLiteral) {
                        IntegerLiteral integerLiteral = (IntegerLiteral)expression;
                        if (integerLiteral.getValue() == value) {
                            return true;
                        }
                    } else if (expression instanceof VariableReference) {
                        VariableReference variableReference = (VariableReference)expression;
                        return analyze(program, variableReference.getVariableName(), value);
                    }
                }
            }
        }

        return false;
    }
}
