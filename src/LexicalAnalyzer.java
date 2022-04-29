import dfa.*;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LexicalAnalyzer {
    //dfa테이블 수+1만큼 length 저장
    private static final int TOKEN_NUM = 19;

    private final String fileInfo;
    private final String fileName;
    private String resultInfo =  "";
    boolean isFinish = false;
    String currentToken = "";
    String currentValue = "";
    DecodeJSON decodeJSON = new DecodeJSON();
    DFA[] dfa = new DFA[TOKEN_NUM];

    public LexicalAnalyzer(String fileInfo, String fileName) {
        this.fileInfo = fileInfo;
        this.fileName = fileName;
        setDFA();
        run();
    }



    private void setDFA(){
        for(int i=0; i<TOKEN_NUM; i++){
            dfa[i] = new DFA(decodeJSON.getTable(i));
///            System.out.println(dfa[i].getTableName());
            dfa[i].initDFA();
        }
    }

    private void run(){
        System.out.println("running");
        int startPosition = 0;
        //끝난 lex들의 길이를 재서 가장 긴 것으로 저장하기 위해서
        int[] lexLength = new int[TOKEN_NUM+1];
        //한글자씩 진행
        while(startPosition < fileInfo.length()){
            //모든 dfa 돌려주기
            //모든 dfa의 state가 끝난 상태로 인지하면 무엇을 선택할지 고르
            for(int i =0;i<TOKEN_NUM;i++){ //모든 dfa 돌리기
                lexLength[i] = -1;
                for(int j = startPosition; j <= fileInfo.length() ;j++){
                    //DFA가 끝났는지 확인
                    String index;
                    isFinish = dfa[i].setState("final");
//                    System.out.println("set state to finish: " + isFinish);
                    //끝까지 돌았는데 안 끝났는 것 처리
                    //dfa돌릴 글자 fileInfo[i]를 어디에다가 저장
                    if(j == fileInfo.length()){ //input file의 끝까지 돌았을 때
                        index = "@#$#@";
                    } else{
                        index = fileInfo.substring(j, j+1);
                    }
                    //- 처리 (boolean으로 변수 하나 만들어두고 이전 token이 =이면 true로 바꿔줘서 처리)
                    if(index.equals("-") && i == 8 && (currentToken.equals("INTEGER")) && j == startPosition){
                        break;
                    }
                    if( index.equals("-") && i == 8 && (currentToken.equals("IDENTIFIER")) && j == startPosition){
                        break;
                    }
                    //dfa.setState()로 다음 state 반환
                    if(!dfa[i].setState(index)){ //setState가 false 반환할 때
//                        System.out.println("finished?" + isFinish);
                        if(isFinish){
                            lexLength[i] = j - startPosition; //토큰 길이 저장
                        }
                        dfa[i].initDFA();
                        break;
                    }
                }
                //dfa init해주기
                dfa[i].initDFA();
            }
            //가장 길게 나온 토큰으로 결정해주기
            int max = -1;
            int maxLengthTableId = -1;
            for(int j = 0; j<TOKEN_NUM;j++){
//                System.out.println("lex length:" + lexLength[j]);
                //길이가 같은 2개 이상의 토큰이 있다면 우선순위 순서대로 dfa가 돌아가서 우선순위가 높은 토큰이 먼저 들어가게 되므로 >=이 아닌 >로 해서 우선순위 가장 높은 토큰을 받음
                if(lexLength[j]>max){
                    max = lexLength[j];
                    maxLengthTableId = j;
                }
            }

            //dfa 성공한 토큰 없을 때  validation
            if(maxLengthTableId == -1){
                resultInfo += "입력받을 수 없는 문자입니다";
                break;
            }
            //나온 토큰 저장, 이전 token type 저장(- 처리 위해서)
            if(!dfa[maxLengthTableId].getTableName().equals("WHITESPACE")) {
                currentToken = dfa[maxLengthTableId].getTableName();
                currentValue = fileInfo.substring(startPosition, startPosition + max);

                if (currentToken.equals("VTYPE")||currentToken.equals("COMPARISON")||currentToken.equals("INTEGER")||currentToken.equals("OPERATOR")||currentToken.equals("ASSIGNMENT")||currentToken.equals("CHAR")||currentToken.equals("BOOLEAN")||currentToken.equals("STRING")||currentToken.equals("IDENTIFIER")) {
                    resultInfo += ("<"+ currentToken + "," + currentValue + ">");
                } else{
                    resultInfo += ("<"+currentToken+">");
                }
                System.out.println("token: " + currentToken);
                System.out.println("value: " + currentValue);
            }
            startPosition += max;
//            System.out.println("start position" + startPosition);
            //output파일에 저장
            BufferedOutputStream bs = null;
            try {
                bs = new BufferedOutputStream(new FileOutputStream("./" + fileName + "_" + "output.txt"));
                bs.write(resultInfo.getBytes());
                bs.close();
//                System.out.println("파일이 생성되었습니다");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
