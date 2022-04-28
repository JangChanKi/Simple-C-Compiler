package automata;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;

public class Automata {
    private final DFA[] DFAList;
    private final String[] insName = {"IF", "ELSE","WHILE","RETURN","VTYPE","OP","INTEGER","STRING",
            "COMPARISON","ASSIGN","SEMI","LBRACE","RBRACE","LPAREN","RPAREN","COMMA","WHITESPACE","ID"};
    private String lexeme = "";
    private String prevInput;

    public Automata() {
        DFAList = new DFA[insName.length];

        for (int i=0;i< insName.length;i++){
            DFAList[i] = new DFA(insName[i]);
        }
    }

    public void setNextInput(char input) {
        ArrayList<DFA> finalDFAList = new ArrayList<>();

        transitionDFA(finalDFAList, input);

        // 모든 DFA가 reject됨
        if (DFA.rejectCount == DFAList.length) {
            if (finalDFAList.isEmpty()) {
                System.out.println("오류가 발생했습니다.");
                return;
            }

            // 직전 final인 것중 가장 우선순위 높은 것
            System.out.println("<"+finalDFAList.get(0).getName()+"," + lexeme + ">");

            // 이전 결과 저장 (- 처리를 위해서)
            String prev = finalDFAList.get(0).getName();
            if (!prev.equals("WHITESPACE"))
                prevInput = prev;

            clearAll(); //Initialize all dfa

            // 현재 input부터 dfa 동작
            finalDFAList.clear();
            lexeme += input;
            transitionDFA(finalDFAList, input);
        }
        else {
            lexeme += input;
        }

        // - 처리
        checkMinus(input);
    }

    private void transitionDFA(ArrayList<DFA> finalDFAList, char input) {
        for (int i=0; i< DFAList.length; i++) {

            // transition 전에 final state에 도달한 dfa를 저장
            if (DFAList[i].isFinal() && !DFAList[i].isRejected())
                finalDFAList.add(DFAList[i]);

            // 모든 dfa에 대해서 현재 input으로 transition 진행
            if (DFAList[i].isRunning())
                DFAList[i].transition(input);
        }
    }

    private void checkMinus(char input) {
        if (input == '-') {
            // int, string, id, rparen -> op로 인식
            if (prevInput.equals("INTEGER") || prevInput.equals("STRING") || prevInput.equals("ID") || prevInput.equals("RPAREN")) {
                // INTEGER reject
                DFAList[6].reject();
            } else {
                // OP reject
                DFAList[5].reject();
            }

        }
    }

    private void clearAll() {
        for (int i=0; i< DFAList.length; i++) {
            DFAList[i].clear();
        }
        lexeme = "";
    }
}
