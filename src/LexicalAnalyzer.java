import automata.Automata;
import automata.Token;
import automata.Transition;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {
    private final FileReader fReader;
    private final BufferedWriter fWriter;
    private final Automata automata = new Automata();

    public LexicalAnalyzer (FileReader reader, BufferedWriter bufferedWriter) {
        this.fReader = reader;
        this.fWriter = bufferedWriter;
    }

    public void run() {
        // input file
        try {

            int ch;
            while ((ch = fReader.read()) != -1) {
                Token result = automata.setNextInput((char) ch);

                if (result == null) {
                    // token으로 아직 인식되지 않았을 때
                } else if (result.getErrorOccur()) {
                    // 해당 input에서 오류가 발생한 경우
                    fWriter.write("!----- error occurred at input: "+(char) ch+" ------>\n");
                    fWriter.write("Output is not possible from this line.. ");
                    break;
                } else {
                    // whitespace token은 제외
                    if (!result.getTokenName().equals("WHITESPACE"))
                        fWriter.write("<"+result.getTokenName()+", "+result.getLexeme()+">\n");
                }


            }
            // end character
            automata.setNextInput((char) -1);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
