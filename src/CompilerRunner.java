import lexical.LexicalAnalyzer;
import lexical.Token;
import lexical.Transition;
import syntax.LRTable;
import syntax.SyntaxAnalyzer;

import java.io.*;

public class CompilerRunner {

    public static void main(String[] args) {
        int i = 0;
        int fail = 0;
        // init transition table for use in LexicalAnalyzer
        try {
            Transition.init();
            LRTable.init();
        } catch (FileNotFoundException e) {
            System.out.println("error : json file not found");
            e.printStackTrace();
            return;
        }

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

                // lexical error -> file delete
                if (!lexicalAnalyzer.getAccepted()) {
                    fileOut.delete();
                    i++;
                    continue;
                }

                // end symbol
                Token end = new Token("$", "", -1);
                lexicalAnalyzer.getSymbolTable().add(end);

                // syntax analysis
                SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(args[i], lexicalAnalyzer.getSymbolTable());
                syntaxAnalyzer.run();

                // syntax accept
                if (syntaxAnalyzer.getAccepted()) {
                    System.out.println("Successfully accepted for file " + args[i] + "\n");
                }

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