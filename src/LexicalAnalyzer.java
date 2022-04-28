import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.Buffer;

public class LexicalAnalyzer {

    private final File file;

    public LexicalAnalyzer(File file) {
        this.file = file;
    }

    public void run() throws IOException {
        String line;
        String fileInfo = "";

        BufferedReader br = new BufferedReader(new FileReader(file));

        while((line = br.readLine()) != null){
            fileInfo += line;
        }
        br.close();


    }
}
