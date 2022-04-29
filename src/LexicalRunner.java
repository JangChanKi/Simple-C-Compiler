import automata.Transition;

import java.io.*;

public class LexicalRunner {

    public static void main(String[] args) throws IOException {
        int i = 0;
        Transition.init();

        while (i < args.length) {
            try {
                // file reader 생성
                FileReader fileReader = new FileReader("./test_case/" + args[i]);
                // file writer 생성
                String outName = args[i];
                if (args[i].split("\\.").length > 0)
                    outName = args[i].split("\\.")[0];
                // Output 파일 이름 결정
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./test_case" + outName + ".out"));

                LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(fileReader, bufferedWriter);

                lexicalAnalyzer.run();

                // 정상 종료
                fileReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.print("Execution is complete for "+i+" files.");

    }
}