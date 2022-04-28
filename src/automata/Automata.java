package automata;


import java.util.List;

public class Automata {
    private final static Transition transition = new Transition();
    private final DFA[] DFAList = new DFA[16];
    private final String[] insName = {"IF", "ELSE",""}
    public Automata() {
        for (int i=0;i< insName.length;i++){
            DFAList[i] = new DFA(insName[i]);
        }
    }

    public void setNextInput(char c) {
    }




}
