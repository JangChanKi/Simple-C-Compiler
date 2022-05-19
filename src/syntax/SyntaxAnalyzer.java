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
    }

    public boolean getAccepted() {
        return this.accepted;
    }
}
