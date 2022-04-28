package automata;


import java.util.List;

public class Automata {
    private final static Transition transition = new Transition();
    private final DFA[] DFAList = new DFA[16];

    public Automata() {
        DFAList[0] = new DFA("IF");
    }

    public void setNextInput(char c) {
    }




}
