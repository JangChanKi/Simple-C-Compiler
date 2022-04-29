package automata;

/*
name에서 어떤 테이블인지를 구분하고 (ex VTYPE, LPAREN)
현재 state 정보와, Running Rejected, Final 등의 추가 정보를 가지고 있습니다.
 */

public class DFA {
    public static int rejectCount = 0;
    private boolean isRejected = false;
    private boolean isRunning = true;
    private boolean isFinal = false;
    private String name;
    private String state = "T0";

    DFA(String name) {
        this.name = name;
    }

    public void clear() {
        isRejected = false;
        isRunning = true;
        isFinal = false;
        rejectCount = 0;
        state = "T0";
    }

    /*
    transition 메소드를 통해 새로운 input에 대해서
    다음 state로 이동할 수 있습니다.
    이 과정에서 Transition 클래스의 클래스 메소드가 사용해서 다음 state를 알 수 있으며,
    만약 wrong input으로 reject되었다면 더 이상 state transition을 진행하지 않습니다.
    final에 도달했다면 그 정보를 가지고 있습니다.
     */

    public void transition(char input) {
        String next = Transition.getNextState(this.name, this.state, ""+input);
        // reject
        if (next == null && !this.isRejected) {
            this.isRejected = true;
            this.isRunning = false;
            rejectCount++;
        }
        else {
            // next state
            this.state = next;
            // final state 도달
            if (Transition.isFinalState(this.name, this.state)) {
                this.isFinal = true;
            }

        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public void reject() {
        if (!this.isRejected) {
            this.isRejected = true;
            this.isRunning = false;
            rejectCount++;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isFinal() {
        return isFinal;
    }
}
