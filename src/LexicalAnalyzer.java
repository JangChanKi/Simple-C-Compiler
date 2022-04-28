import automata.Automata;
import automata.Transition;

import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {
    private final FileReader reader;
    private final static Transition transition = new Transition();
    private final Automata automata = new Automata();

    public LexicalAnalyzer (FileReader reader) {
        this.reader = reader;
    }

    public void run() {
        // input file
        try {

            int ch;
            while ((ch = reader.read()) != -1) {
                automata.setNextInput((char) ch);
            }
            // end character
            automata.setNextInput((char) -1);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
