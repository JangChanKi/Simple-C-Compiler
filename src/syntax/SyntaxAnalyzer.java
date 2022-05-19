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
            String decision = LRTable.getAction(stateStack.peek(), nextSymbol);

            // invalid transition -> reject
            if (decision == null || decision.length() < 1) {
                System.out.println("Error occurred in file " + fileName);
                System.out.println("Syntax error : " + symbolTable.get(splitter).getLexeme());
                accepted = false;
            }
            else {
                char op = decision.charAt(0);                                                   // s or c
                int value = Integer.parseInt(decision.substring(1));                  // [num]

                System.out.println(splitter + " " + decision);
                // action : shift and goto
                if (op == 's') {
                    stateStack.push(value);     // push the next state into the stack
                    splitter++;                 // move the splitter to the right
                }
                // action : reduce
                else if (op == 'r') {

                    System.out.println(LRTable.getNumOfRHS(value));
                    // pop number of RHS items from stack
                    for (int i = 0; i < LRTable.getNumOfRHS(value); i++)
                        stateStack.pop();

                    // accepted
                    if (stateStack.empty()) {
                        break;
                    }

                    int nextState = LRTable.getGoto(stateStack.peek(), LRTable.getLHS(value));              // goto table
                    // rejected
                    if (nextState == -1)
                        accepted = false;
                    else
                        stateStack.push(nextState);
                }
            }

        }
    }

    public boolean getAccepted() {
        return this.accepted;
    }
}
