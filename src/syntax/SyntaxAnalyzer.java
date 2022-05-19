package syntax;

import lexical.Token;

import java.util.ArrayList;
import java.util.Stack;

public class SyntaxAnalyzer implements Runnable {

    private final String fileName;
    private final ArrayList<Token> symbolTable;

    private final Stack<Integer> stateStack = new Stack<Integer>();

    private boolean accepted = true;

    public SyntaxAnalyzer(final String fileName, final ArrayList<Token> symbolTable) {
        this.fileName = fileName;
        this.symbolTable = symbolTable;
    }

    @Override
    public void run() {
        int splitter = 0;

        // init
        stateStack.push(0);

        while(accepted && splitter < symbolTable.size()) {

            // next input symbol
            String nextSymbol = symbolTable.get(splitter).toTerminal();
            String decision = LRTable.getActionOrGoto(stateStack.peek(), nextSymbol);

            // invalid transition -> reject
            if (decision == null || decision.length() < 1) {
                accepted = false;
            }
            else {
                char op = decision.charAt(0);
                int value = Integer.parseInt(decision.substring(1));

                // shift and goto
                if (op == 's') {
                    stateStack.push(value);     // push the next state into the stack
                    splitter++;     // move the splitter to the right
                }
                // reduce
                else if (op == 'r') {
                    Token cur = symbolTable.get(splitter);
                    //Token reduced = new Token()

                    //symbolTable.add(splitter, reduced);
                    symbolTable.remove(splitter);
                }
            }

        }
    }

    public boolean getAccepted() {
        return this.accepted;
    }
}
