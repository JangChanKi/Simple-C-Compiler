import automata.Automata;
import automata.DFA;
import automata.Token;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer implements Runnable {
    private final FileReader fReader;
    private final BufferedWriter fWriter;
    private final Automata automata = new Automata();

    private final String fileName;

    private String symbolTable = "";

    private boolean accepted = true;

    public LexicalAnalyzer (String fileName, FileReader reader, BufferedWriter bufferedWriter) {
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
                        symbolTable = symbolTable + "<"+result.getTokenName()+", "+result.getLexeme()+">\n";
                }

                prevCh = ch;
            }

            // create .out file if accepted
            if (accepted)
                fWriter.write(symbolTable);

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

}
