package lexical;


import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import java.util.ArrayList;

public class Automata {
    private final String[] insName = {"IF", "ELSE","WHILE","RETURN","VTYPE","OP","INTEGER","STRING",
            "COMPARISON","ASSIGN","SEMI","LBRACE","RBRACE","LPAREN","RPAREN","COMMA","WHITESPACE","ID"};
    private final DFA[] DFAList;

    // - 처리를 위해서 따로 분류
    private final DFA dfaOP;
    private final DFA dfaInt;

    private String lexeme = "";
    private String prevToken = "";
    private char prevInput = 0;

    public Automata() {
        DFAList = new DFA[insName.length];

        for (int i=0; i< insName.length; i++){
            DFAList[i] = new DFA(insName[i]);
        }

        // - 처리를 위해 사용하는 dfa(op, int)를 쉽게 인식할 수 있도록 저장
        dfaOP = DFAList[5];
        dfaInt = DFAList[6];
    }

    /*
    LexicalAnalyzer에서 입력된 input으로 DFA들을 진행시키는 메소드
    모든 DFA가 reject 되었을 때 그 전 상태에서 final에 도달한 DFA들 중
    가장 우선순위가 높은 것을 token으로 인식한다.
    (만약 final에 도달한 DFA가 없다면, 에러로 인식한다)
    '-' 는 앞의 토큰이 INTEGER, STRING, ID, RPAREN일 때는 INT DFA를 reject 시켜서 OP로 인식시킨다.
     */

    @Nullable
    public Token setNextInput(final char input, final int lineNum) {
        ArrayList<DFA> finalDFAList = new ArrayList<>();

        // 현재 final state에 도달한 dfa들 목록
        setFinalDFAs(finalDFAList);
        // 현재 input에 대해 transition 진행
        transitionDFA(input);

        // - : OP인지/INTEGER 인지
        if(prevInput == '-') {
            if (prevToken.equals("INTEGER") || prevToken.equals("STRING") || prevToken.equals("ID") || prevToken.equals("RPAREN")) {
                dfaInt.reject();
            } else {
                dfaOP.reject();
            }

        }
        // 현재 input을 prev에 저장 (- 처리 위해서)
        prevInput = input;

        // 모든 DFA가 reject됨
        if (DFA.rejectCount == DFAList.length) {
            if (finalDFAList.isEmpty()) {
                return new Token("", "",  true, lineNum);
            }

            // 직전 final인 것중 가장 우선순위 높은 것
            Token ret = new Token(finalDFAList.get(0).getName(), lexeme, lineNum);

            // 이전 결과 저장 (- 처리를 위해서)
            String prev = finalDFAList.get(0).getName();
            if (!prev.equals("WHITESPACE"))
                prevToken = prev;

            clearAll(); //Initialize all dfa

            // 현재 input부터 dfa 동작
            finalDFAList.clear();
            setFinalDFAs(finalDFAList);
            lexeme += input;
            transitionDFA(input);

            // string token은 " " 기호 제거
            if (ret.getTokenName().equals("STRING")) {
                String curLexeme = ret.getLexeme();
                ret = new Token(
                        ret.getTokenName(),
                        curLexeme.substring(1, curLexeme.length()-1),
                        ret.getLineNumber()
                );
            }
            return ret;
        }
        else {
            lexeme += input;
        }
        return null;
    }

    // transition 전에 final state에 도달한 dfa를 저장
    private void setFinalDFAs(ArrayList<DFA> finalDFAList) {
        for (int i=0; i<DFAList.length; i++) {

            if (DFAList[i].isFinal() && !DFAList[i].isRejected())
                finalDFAList.add(DFAList[i]);
        }
    }

    // 모든 dfa에 대해서 현재 input으로 transition 진행
    private void transitionDFA(char input) {
        for (int i=0; i< DFAList.length; i++) {

            if (DFAList[i].isRunning())
                DFAList[i].transition(input);
        }
    }

    private void clearAll() {
        for (int i=0; i< DFAList.length; i++) {
            DFAList[i].clear();
        }
        lexeme = "";
    }
}
