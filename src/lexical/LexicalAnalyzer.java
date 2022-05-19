package lexical;

import lexical.Automata;
import lexical.DFA;
import lexical.Token;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LexicalAnalyzer implements Runnable {
    private final FileReader fReader;
    private final BufferedWriter fWriter;
    private final Automata automata = new Automata();

    private final String fileName;

    private final ArrayList<Token> symbolTable = new ArrayList<Token>();

    private boolean accepted = true;

    public LexicalAnalyzer (final String fileName, final FileReader reader, final BufferedWriter bufferedWriter) {
        this.fileName = fileName;
        this.fReader = reader;
        this.fWriter = bufferedWriter;
    }

    @Override
    public void run() {
        // input file
        try {

            int lineNum = 1;
            int prevCh = 0;
            int ch;
            while ((ch = fReader.read()) != -1) {
                if (ch == '\n')
                    lineNum++;

                Token result = automata.setNextInput((char) ch);

                if (result == null) {
                    // token으로 아직 인식되지 않았을 때
                } else if (result.getErrorOccur()) {
                    // 해당 input에서 오류가 발생한 경우
                    System.out.println("Error occurred in file " + fileName);
                    System.out.println("Line number " + lineNum + ": '" + (char) prevCh + "' is not a symbol.\n");
                    accepted = false;
                    break;
                } else {
                    // whitespace token은 제외
                    if (!result.getTokenName().equals("WHITESPACE"))
                        symbolTable.add(result);
                }

                prevCh = ch;
            }

            // create .out file if accepted
            if (accepted) {
                Iterator iter = symbolTable.iterator();

                while (iter.hasNext()) {
                    Token token = (Token) iter.next();
                    String curLine = "<" + token.getTokenName() + ", " + token.getLexeme() + ">\n";
                    fWriter.write(curLine);
                }
            }

            // end character
            //automata.setNextInput((char) 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DFA.clearRejectCount();

    }

    public boolean getAccepted() {
        return this.accepted;
    }

    public final ArrayList<Token> getSymbolTable() {
        return this.symbolTable;
    }

}
