package tubes;

import java.util.ArrayList;

public class Logaritma {
    
    static ArrayList<String> tape;
    static String str_tape;
    static TuringMachine TM;
    static int head;
    static String[] states, symbol;
    static String direction;
    
    static TuringMachine start(int input) {
    	
    	TM = new TuringMachine();

    	tape = new ArrayList<String>();
    	
        head = 0;

        fill_tape(input);
        
        states = new String[]{"Q0", "Q0"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
        record(states, symbol, direction);
        
        q0();
        
		return TM;
    }

    static void fill_tape(int input) {
        String binary = Integer.toBinaryString(input);
        for (char digit : binary.toCharArray()) {
            tape.add(String.valueOf(digit));
        }
    }

    static void increaseBoundary() {
		if (head < 0) {
			tape.add(0,"B");
			head++;
		} else if (head >= tape.size()) {
			tape.add("B");
		}
	}

    static void operate(String new_value, String direction) {
        tape.set(head, String.valueOf(new_value.charAt(0)));
        if (direction.charAt(0) == 'R') {
			head++;
		} else if (direction.charAt(0) == 'L'){
			head--;
		}
        increaseBoundary();
    }
    
    static void record(String[] states, String[] symbol, String direction) {
    	
    	str_tape = "";
        
        for (int i = 0; i < tape.size(); i++) {
            str_tape = str_tape.concat(tape.get(i));
        }
        
        TM.addRecord(str_tape, head);
        TM.addTransition(states, symbol, direction);        
    }

    static void q0() {
        String value = tape.get(head);
        if (value.equals("0")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
            operate("0", "R");
            record(states, symbol, direction);
            q0();
        }
        if (value.equals("1")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"1", "1"};
        	direction = "R";
            operate("1", "R");
            record(states, symbol, direction);
            q0();
        }
        if (value.equals("B")) {
        	states = new String[]{"Q0", "Q1"};
        	symbol =  new String[]{"B", ";"};
        	direction = "L";
            operate(";", "L");
            record(states, symbol, direction);
            q1();
        }
    }

    static void q1() {
        String value = tape.get(head);
        if (value.equals("0")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
            operate("0", "L");
            record(states, symbol, direction);
            q1();
        }
        if (value.equals("1")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"1", "1"};
        	direction = "L";
            operate("1", "L");
            record(states, symbol, direction);
            q1();
        }
        if (value.equals("B")) {
        	states = new String[]{"Q1", "Q2"};
        	symbol =  new String[]{"B", "B"};
        	direction = "R";
            operate("B", "R");
            record(states, symbol, direction);
            q2();
        }
    }

    static void q2() {
        String value = tape.get(head);
        if (value.equals("1")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"1", "1"};
        	direction = "R";
            operate("1", "R");
            record(states, symbol, direction);
            q2();
        }
        if (value.equals("0")) {
        	states = new String[]{"Q2", "Q3"};
        	symbol =  new String[]{"0", "X"};
        	direction = "R";
            operate("X", "R");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals(";")) {
        	states = new String[]{"Q2", "Q5"};
        	symbol =  new String[]{";", "B"};
        	direction = "L";
            operate("B", "L");
            record(states, symbol, direction);
            q5();
        }
    }

    static void q3() {
        String value = tape.get(head);
        if (value.equals("Y")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "R";
            operate("Y", "R");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals(";")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{";", ";"};
        	direction = "R";
            operate(";", "R");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals("0")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
            operate("0", "R");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals("B")) {
        	states = new String[]{"Q3", "Q4"};
        	symbol =  new String[]{"B", "Y"};
        	direction = "L";
            operate("Y", "L");
            record(states, symbol, direction);
            q4();
        }
    }

    static void q4() {
        String value = tape.get(head);
        if (value.equals(";")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{";", ";"};
        	direction = "L";
            operate(";", "L");
            record(states, symbol, direction);
            q4();
        }
        if (value.equals("0")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
            operate("0", "L");
            record(states, symbol, direction);
            q4();
        }
        if (value.equals("Y")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "L";
            operate("Y", "L");
            record(states, symbol, direction);
            q4();
        }
        if (value.equals("X")) {
        	states = new String[]{"Q4", "Q2"};
        	symbol =  new String[]{"X", "X"};
        	direction = "R";
            operate("X", "R");
            record(states, symbol, direction);
            q2();
        }
    }

    static void q5() {
        String value = tape.get(head);
        if (value.equals("X")) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"X", "B"};
        	direction = "L";
            operate("B", "L");
            record(states, symbol, direction);
            q5();
        }
        if (value.equals("1")) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"1", "B"};
        	direction = "L";
            operate("B", "L");
            record(states, symbol, direction);
            q5();
        }
        if (value.equals("B")) {
        	states = new String[]{"Q5", "Q6"};
        	symbol =  new String[]{"B", "B"};
        	direction = "L";
            operate("B", "L");
            record(states, symbol, direction);
            q6();
        }
    }

    static void q6() {
    	states = new String[]{"Q6", "Q6"};
    	symbol =  new String[]{"B", "B"};
    	direction = "N";
    	record(states, symbol, direction);
    }

}
