import java.io.FileReader;
import java.io.IOException;

public class TestRun {

    public static void main(String[] args) throws IOException {
        int i = 0;

        while (i < args.length) {
            FileReader fileReader = new FileReader("./test_case/" +args[i++]);

            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(fileReader);
            lexicalAnalyzer.run();
        }
        System.out.print("모든 파일에 대해 실행이 완료되었습니다.");

    }
}