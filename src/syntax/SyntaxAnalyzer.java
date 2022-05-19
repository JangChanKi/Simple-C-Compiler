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

        while(accepted &&  splitter < symbolTable.size()) {
            boolean epsilonMoved = false;

            // next input symbol
            String nextSymbol = symbolTable.get(splitter).toTerminal();
            String decision = LRTable.getAction(stateStack.peek(), nextSymbol);

            // epsilon move
            if (decision == null) {
                decision = LRTable.getAction(stateStack.peek(), "e");
                epsilonMoved = true;
            }

            // invalid transition -> reject
            if (decision == null || decision.length() < 1) {
                Token symbol = symbolTable.get(splitter);
                System.out.println("Error occurred in file " + fileName);
                System.out.println("Syntax error : '" + symbol.getLexeme() + "' in Line " + symbol.getLineNumber() + "\n");
                accepted = false;
            }
            else {
                char op = decision.charAt(0);                                                   // s or c
                int value = Integer.parseInt(decision.substring(1));                  // [num]

                // action : shift and goto
                if (op == 's') {
                    stateStack.push(value);     // push the next state into the stack
                    if (!epsilonMoved)
                        splitter++;                 // move the splitter to the right
                }
                // action : reduce
                else if (op == 'r') {

                    // pop number of RHS items from stack
                    for (int i = 0; i < LRTable.getNumOfRHS(value); i++)
                        stateStack.pop();

                    int nextState = LRTable.getGoto(stateStack.peek(), LRTable.getLHS(value));              // goto table
                    // rejected
                    if (nextState == -1)
                        accepted = false;
                    else
                        stateStack.push(nextState);
                }
                // accept
                else if (decision.equals("acc")) {
                    accepted = true;
                    break;
                }
            }

        }
    }

    public boolean getAccepted() {
        return this.accepted;
    }
}
