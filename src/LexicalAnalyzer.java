import automata.DFA;
import automata.Table;

import java.io.BufferedReader;
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
            Table table = new Table();

            int ch;
            while ((ch = reader.read()) != -1) {
                DFA dfa = new DFA();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
