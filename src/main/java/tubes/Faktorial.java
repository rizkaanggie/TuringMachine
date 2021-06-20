package tubes;

import java.util.ArrayList;
import java.util.HashMap;

public class Faktorial {
    
    static ArrayList<String> tape_1, tape_2, tape_3;
    static String str_tape_1, str_tape_2, str_tape_3;
    static TuringMachine TM;
    static int head_1, head_2, head_3;
    static String[] states, symbol;
    static String direction;
    
    static TuringMachine start(int input) {
    	
    	TM = new TuringMachine();

    	tape_1 = new ArrayList<String>();
        tape_2 = new ArrayList<String>();
        tape_3 = new ArrayList<String>();
    	
        head_1 = head_2 = head_3 = 0;
      
        fill_tape(input);

        states = new String[]{"Q0", "Q0"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
        record(states, symbol, direction);
        
        q0();

        return TM;
    }

    static void fill_tape(int input) {
        for(int i = 0; i < input; i++) {
            tape_1.add("0");
            tape_2.add("B");
            tape_3.add("B");
        }
        tape_1.add("1");
        tape_2.add("B");
        tape_3.add("B");
    }

    static void increaseBoundary() {
		if (head_1 < 0 || head_2 < 0 || head_3 < 0) {
			tape_1.add(0,"B");
			tape_3.add(0,"B");
			tape_2.add(0,"B");
			head_1++;
			head_2++;
			head_3++;
		} else if (head_1 >= tape_1.size() || head_2 >= tape_2.size() || head_3 >= tape_3.size()) {
			tape_1.add("B");
			tape_3.add("B");
			tape_2.add("B");
		}
	}

    static void operate(String new_value, String direction) {
        tape_1.set(head_1, String.valueOf(new_value.charAt(0)));
        tape_2.set(head_2, String.valueOf(new_value.charAt(1)));
        tape_3.set(head_3, String.valueOf(new_value.charAt(2)));

        if (direction.charAt(0) == 'R') {
			head_1++;
		} else if (direction.charAt(0) == 'L'){
			head_1--;
		}
		if (direction.charAt(1) == 'R') {
			head_2++;
		} else if (direction.charAt(1) == 'L'){
			head_2--;
		}
		if (direction.charAt(2) == 'R') {
			head_3++;
		} else if (direction.charAt(2) == 'L'){
			head_3--;
		}
        increaseBoundary();
    }

    static void record(String[] states, String[] symbol, String direction) {
    	
    	str_tape_1 = "";
        str_tape_2 = "";
        str_tape_3 = "";
        
        for (int i = 0; i < tape_1.size(); i++) {
            str_tape_1 = str_tape_1.concat(tape_1.get(i));
        }
        for (int i = 0; i < tape_2.size(); i++) {
        	str_tape_2 = str_tape_2.concat(tape_2.get(i));
        }
        for (int i = 0; i < tape_3.size(); i++) {
        	str_tape_3 = str_tape_3.concat(tape_3.get(i));
        }
        
        TM.addRecord(str_tape_1, str_tape_2, str_tape_3, head_1, head_2, head_3);
        TM.addTransition(states, symbol, direction);   
    }

    static void q0() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("0BB")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"0BB", "00B"};
        	direction = "RRN";
            operate("00B", "RRN");
            record(states, symbol, direction);
            q0();
        }
        if (value.equals("1BB")) {
        	states = new String[]{"Q0", "Q1"};
        	symbol =  new String[]{"1BB", "BBB"};
        	direction = "LLN";
            operate("BBB", "LLN");
            record(states, symbol, direction);
            q1();
        }
    }

    static void q1() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q1", "Q2"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "NLN";
            operate("0BB", "NLN");
            record(states, symbol, direction);
            q2();
        }
        if (value.equals("BBB")) {
        	states = new String[]{"Q1", "Q2"};
        	symbol =  new String[]{"BBB", "0BB"};
        	direction = "NNN";
            operate("0BB", "NNN");
            record(states, symbol, direction);
            q2();
        }
    }

    static void q2() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("000")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"000", "000"};
        	direction = "LNR";
            operate("000", "LNR");
            record(states, symbol, direction);
            q2();
        }
        if (value.equals("00B")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"00B", "000"};
        	direction = "LNR";
            operate("000", "LNR");
            record(states, symbol, direction);
            q2();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q2", "Q3"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "RLN";
            operate("B0B", "RLN");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals("0BB")) {
        	states = new String[]{"Q2", "Q7"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "NRN";
            operate("0BB", "NRN");
            record(states, symbol, direction);
            q7();
        }
    }

    static void q3() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("000")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"000", "000"};
        	direction = "RNR";
            operate("000", "RNR");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals("00B")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"00B", "000"};
        	direction = "RNR";
            operate("000", "RNR");
            record(states, symbol, direction);
            q3();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q3", "Q2"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "LLN";
            operate("B0B", "LLN");
            record(states, symbol, direction);
            q2();
        }
        if (value.equals("0BB")) {
        	states = new String[]{"Q3", "Q4"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "NRN";
            operate("0BB", "NRN");
            record(states, symbol, direction);
            q4();
        }
    }

    static void q4() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q4", "Q5"};
        	symbol =  new String[]{"00B", "0BB"};
        	direction = "NRL";
            operate("0BB", "NRL");
            record(states, symbol, direction);
            q5();
        }
    }

    static void q5() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("B00")) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"B00", "000"};
        	direction = "RNL";
            operate("000", "RNL");
            record(states, symbol, direction);
            q5();
        }
        if (value.equals("000")) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"000", "000"};
        	direction = "RNL";
            operate("000", "RNL");
            record(states, symbol, direction);
            q5();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q5", "Q6"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "LRN";
            operate("B0B", "LRN");
            record(states, symbol, direction);
            q6();
        }
        if (value.equals("0B0")) {
        	states = new String[]{"Q5", "Q10"};
        	symbol =  new String[]{"0B0", "0B0"};
        	direction = "NNN";
            operate("0B0", "NNN");
            record(states, symbol, direction);
            q10();
        }
    }

    static void q6() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q6", "Q6"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "NRN";
            operate("00B", "NRN");
            record(states, symbol, direction);
            q6();
        }
        if (value.equals("0BB")) {
        	states = new String[]{"Q6", "Q2"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "NLR";
            operate("0BB", "NLR");
            record(states, symbol, direction);
            q2();
        }
    }

    static void q7() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q7", "Q8"};
        	symbol =  new String[]{"00B", "0BB"};
        	direction = "NRL";
            operate("0BB", "NRL");
            record(states, symbol, direction);
            q8();
        }
    }

    static void q8() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("B00")) {
        	states = new String[]{"Q8", "Q8"};
        	symbol =  new String[]{"B00", "000"};
        	direction = "LNL";
            operate("000", "LNL");
            record(states, symbol, direction);
            q8();
        }
        if (value.equals("000")) {
        	states = new String[]{"Q8", "Q8"};
        	symbol =  new String[]{"000", "000"};
        	direction = "LNL";
            operate("000", "LNL");
            record(states, symbol, direction);
            q8();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q8", "Q9"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "RRN";
            operate("B0B", "RRN");
            record(states, symbol, direction);
            q9();
        }
        if (value.equals("0B0")) {
        	states = new String[]{"Q8", "Q10"};
        	symbol =  new String[]{"0B0", "0B0"};
        	direction = "NNN";
            operate("0B0", "NNN");
            record(states, symbol, direction);
            q10();
        }
    }

    static void q9() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q9", "Q9"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "NRN";
            operate("00B", "NRN");
            record(states, symbol, direction);
            q9();
        }
        if (value.equals("0BB")) {
        	states = new String[]{"Q9", "Q3"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "NLR";
            operate("0BB", "NLR");
            record(states, symbol, direction);
            q3();
        }
    }

    static void q10() {
    	states = new String[]{"Q10", "Q10"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
        record(states, symbol, direction);
    }
}
