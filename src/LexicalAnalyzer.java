import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyzer {
    private final FileReader reader;

    public LexicalAnalyzer (FileReader reader) {
        this.reader = reader;
    }

    public void run() {
        try {
            int ch;
            while ((ch = reader.read()) != -1) {
                // here your code
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
