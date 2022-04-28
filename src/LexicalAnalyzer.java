import dfa.*;

public class LexicalAnalyzer {
    //dfa테이블 수만큼 length 저장
    private static final int TOKEN_NUM = 100;

    private final String fileInfo;

    private String resultInfo =  null;
    DecodeJSON decodeJSON = new DecodeJSON();
    DFA[] dfa = new DFA[TOKEN_NUM];

    public LexicalAnalyzer(String fileInfo) {
        this.fileInfo = fileInfo;
        setDFA();
        run();
    }



    private void setDFA(){
        for(int i=0; i<TOKEN_NUM; i++){
            dfa[i] = new DFA(decodeJSON.getTable(i));
            dfa[i].initDFA();
        }
    }

    private void run(){
        int startPosition = 0;
        //끝난 lex들의 길이를 재서 가장 긴 것으로 저장하기 위해서
        int[] lexLength = new int[TOKEN_NUM+1];
        //한글자씩 진행
        while(startPosition < fileInfo.length()){
            //모든 dfa 돌려주기
            //모든 dfa의 state가 끝난 상태로 인지하면 무엇을 선택할지 고르
            for(int i =0;i<TOKEN_NUM;i++){
                lexLength[i] = -1;

            }
        }
    }
}
