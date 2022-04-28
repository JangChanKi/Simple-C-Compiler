import automata.Automata;

import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {
    private final FileReader reader;


    public LexicalAnalyzer (FileReader reader) {
        this.reader = reader;
    }

    public void run() {
        // input file
        try {

            int ch;
            while ((ch = reader.read()) != -1) {
                Automata dfa = new Automata();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
