import lexical.LexicalAnalyzer;
import lexical.Transition;
import syntax.SyntaxAnalyzer;

import java.io.*;

public class CompilerRunner {

    public static void main(String[] args) {
        int i = 0;
        int fail = 0;
        Transition.init();

        while (i < args.length) {
            try {
                // file reader 생성
                FileReader fileReader = new FileReader("." + File.separator + "test_case" + File.separator + args[i]);
                // file writer 생성
                String outName = args[i];
                if (args[i].split("\\.").length > 0)
                    outName = args[i].split("\\.")[0];
                // Output 파일 이름 결정
                File fileOut = new File("." + File.separator + "test_case" + File.separator +outName + ".out");
                FileWriter fileWriter = new FileWriter(fileOut);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // lexical analysis
                LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(args[i], fileReader, bufferedWriter);
                lexicalAnalyzer.run();

                // error 발생 -> file delete
                if (!lexicalAnalyzer.getAccepted())
                    fileOut.delete();

                // syntax analysis
                SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(args[i], lexicalAnalyzer.getSymbolTable());
                syntaxAnalyzer.run();

                // 정상 종료
                fileReader.close();
                bufferedWriter.close();
                fileWriter.close();

            } catch (FileNotFoundException e) {
                // file이 없을 경우
                System.out.println("The file does not exist : "+args[i++] + "\n");
                fail++;
                continue;
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.print("Execution is complete for "+(i-fail)+" files.");

    }
}