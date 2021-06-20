
package tubes;

import java.util.ArrayList;

public class Perpangkatan {
	
	static ArrayList<String> tape;
    static String str_tape;
    static TuringMachine TM;
    static int head;
    static String[] states, symbol;
    static String direction;
    
    static TuringMachine start(int input_1, int input_2) {
    	
    	TM = new TuringMachine();

    	tape = new ArrayList<String>();
    	
        head = 0;
        
        input_to_tape_1(input_1, input_2);

        states = new String[]{"", ""};
    	symbol =  new String[]{"", ""};
    	direction = "";
        record(states, symbol, direction);
        
        q0();
        
        return TM;
    }
	
	static void input_to_tape_1(int a, int b) {	
		for(int i=0;i<Math.abs(a);i++) {
			tape.add("0");
		}
		
		tape.add("1");
		
		for(int i=0;i<Math.abs(b);i++) {
			tape.add("0");
		}
	}
	
	static void increaseBoundary() {
		if (head<0) {
			tape.add(0,"B");
			head++;
		}
		
		if (head>=tape.size()) {
			tape.add("B");
		}
	}
	
	static void operate(String after, String direction) {
		tape.set(head,after);
		
		if(direction.equals("R")) {
			head++;
		}else if (direction.equals("L")){
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
		if(tape.get(head).equals("Y")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "R";
			operate("Y", "R");
			record(states, symbol, direction);
			q0();
		}else if(tape.get(head).equals("X")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"X", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q0();
		}else if(tape.get(head).equals("1")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"1", "1"};
        	direction = "R";
			operate("1", "R");
			record(states, symbol, direction);
			q0();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q0();
		}else if(tape.get(head).equals("B")) {
        	states = new String[]{"Q0", "Q1"};
        	symbol =  new String[]{"B", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q1();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q0", "Q6"};
        	symbol =  new String[]{"A", "A"};
        	direction = "R";
			operate("A", "R");
			record(states, symbol, direction);
			q6();
		}
	}
	
	static void q1() {
		if(tape.get(head).equals("D")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"D", "D"};
        	direction = "L";
			operate("D", "L");
			record(states, symbol, direction);
			q1();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q1();
		}else if(tape.get(head).equals("1")) {
        	states = new String[]{"Q1", "Q2"};
        	symbol =  new String[]{"1", "1"};
        	direction = "R";
			operate("1", "R");
			record(states, symbol, direction);
			q2();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q1", "Q7"};
        	symbol =  new String[]{"A", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q7();
		}
	}
	
	static void q2() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q2", "Q3"};
        	symbol =  new String[]{"0", "Y"};
        	direction = "L";
			operate("Y", "L");
			record(states, symbol, direction);
			q3();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q2", "Q6"};
        	symbol =  new String[]{"A", "B"};
        	direction = "L";
			operate("B", "L");
			record(states, symbol, direction);
			q6();
		}
	}
	
	static void q3() {
		if(tape.get(head).equals("X")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"X", "X"};
        	direction = "L";
			operate("X", "L");
			record(states, symbol, direction);
			q3();
		}else if(tape.get(head).equals("Y")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "L";
			operate("Y", "L");
			record(states, symbol, direction);
			q3();
		}else if(tape.get(head).equals("1")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"1", "1"};
        	direction = "L";
			operate("1", "L");
			record(states, symbol, direction);
			q3();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q3", "Q4"};
        	symbol =  new String[]{"0", "X"};
        	direction = "R";
			operate("X", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("B")) {
        	states = new String[]{"Q3", "Q0"};
        	symbol =  new String[]{"B", "B"};
        	direction = "R";
			operate("B", "R");
			record(states, symbol, direction);
			q0();
		}
	}
	
	static void q4() {
		if(tape.get(head).equals("D")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"D", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("C")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"C", "C"};
        	direction = "R";
			operate("C", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("X")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"X", "X"};
        	direction = "R";
			operate("X", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("Y")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "R";
			operate("Y", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("1")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"1", "1"};
        	direction = "R";
			operate("1", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"A", "A"};
        	direction = "R";
			operate("A", "R");
			record(states, symbol, direction);
			q4();
		}else if(tape.get(head).equals("B")) {
        	states = new String[]{"Q4", "Q5"};
        	symbol =  new String[]{"B", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q5();
		}
	}
	
	static void q5() {
		if(tape.get(head).equals("A")) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"A", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q5();
		}else if(tape.get(head).equals("0") ) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q5();
		}else if(tape.get(head).equals("Y") ) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "L";
			operate("Y", "L");
			record(states, symbol, direction);
			q5();
		}else if(tape.get(head).equals("C") ) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"C", "C"};
        	direction = "L";
			operate("C", "L");
			record(states, symbol, direction);
			q5();
		}else if(tape.get(head).equals("D") ) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"D", "D"};
        	direction = "L";
			operate("D", "L");
			record(states, symbol, direction);
			q5();
		}else if(tape.get(head).equals("1") ) {
        	states = new String[]{"Q5", "Q3"};
        	symbol =  new String[]{"1", "1"};
        	direction = "L";
			operate("1", "L");
			record(states, symbol, direction);
			q3();
		}
	}
	
	static void q6() {	
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q6", "Q6"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q6();
		}else if(tape.get(head).equals("D") ) {
        	states = new String[]{"Q6", "Q6"};
        	symbol =  new String[]{"D", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q6();
		}else if(tape.get(head).equals("Y") ) {
        	states = new String[]{"Q6", "Q18"};
        	symbol =  new String[]{"Y", "B"};
        	direction = "L";
			operate("B", "L");
			record(states, symbol, direction);
			q18();
		}else if(tape.get(head).equals("C") ) {
        	states = new String[]{"Q6", "Q8"};
        	symbol =  new String[]{"C", "C"};
        	direction = "L";
			operate("C", "L");
			record(states, symbol, direction);
			q8();
		}
		else if(tape.get(head).equals("B") ) {
        	states = new String[]{"Q6", "Q1"};
        	symbol =  new String[]{"B", "C"};
        	direction = "L";
			operate("C", "L");
			record(states, symbol, direction);
			q1();
		}else if(tape.get(head).equals("A") ) {
        	states = new String[]{"Q6", "Q1"};
        	symbol =  new String[]{"A", "A"};
        	direction = "R";
			operate("A", "R");
			record(states, symbol, direction);
			q1();
		}
	}
	
	static void q7() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q7", "Q7"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q7();
		}else if(tape.get(head).equals("Y")) {
        	states = new String[]{"Q7", "Q2"};
        	symbol =  new String[]{"Y", "Y"};
        	direction = "R";
			operate("Y", "R");
			record(states, symbol, direction);
			q2();
		}
	}
	
	static void q8() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q8", "Q8"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q8();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q8", "Q9"};
        	symbol =  new String[]{"A", "A"};
        	direction = "R";
			operate("A", "R");
			record(states, symbol, direction);
			q9();
		}else if(tape.get(head).equals("D")) {
        	states = new String[]{"Q8", "Q9"};
        	symbol =  new String[]{"D", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q9();
		}
	}
	
	static void q9() {
		if(tape.get(head).equals("C")) {
        	states = new String[]{"Q9", "Q16"};
        	symbol =  new String[]{"C", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q16();
		}else if(tape.get(head).equals("D")) {
        	states = new String[]{"Q9", "Q9"};
        	symbol =  new String[]{"D", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q9();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q9", "Q10"};
        	symbol =  new String[]{"0", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q10();
		}
	}
	
	static void q10() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q10", "Q10"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q10();
		}else if(tape.get(head).equals("C")) {
        	states = new String[]{"Q10", "Q10"};
        	symbol =  new String[]{"C", "C"};
        	direction = "R";
			operate("C", "R");
			record(states, symbol, direction);
			q10();
		}else if(tape.get(head).equals("B")) {
        	states = new String[]{"Q10", "Q11"};
        	symbol =  new String[]{"B", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q11();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q10", "Q11"};
        	symbol =  new String[]{"A", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q11();
		}
	}
	
	static void q11() {
		if(tape.get(head).equals("X")) {
        	states = new String[]{"Q11", "Q11"};
        	symbol =  new String[]{"X", "X"};
        	direction = "L";
			operate("X", "L");
			record(states, symbol, direction);
			q11();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q11", "Q12"};
        	symbol =  new String[]{"0", "X"};
        	direction = "R";
			operate("X", "R");
			record(states, symbol, direction);
			q12();
		}else if(tape.get(head).equals("C")) {
        	states = new String[]{"Q11", "Q14"};
        	symbol =  new String[]{"C", "C"};
        	direction = "R";
			operate("C", "R");
			record(states, symbol, direction);
			q14();
		}
	}
	
	static void q12() {
		if(tape.get(head).equals("X")) {
        	states = new String[]{"Q12", "Q12"};
        	symbol =  new String[]{"X", "X"};
        	direction = "R";
			operate("X", "R");
			record(states, symbol, direction);
			q12();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q12", "Q12"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q12();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q12", "Q12"};
        	symbol =  new String[]{"A", "A"};
        	direction = "R";
			operate("A", "R");
			record(states, symbol, direction);
			q12();
		}else if(tape.get(head).equals("B")) {
        	states = new String[]{"Q12", "Q13"};
        	symbol =  new String[]{"B", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q13();
		}
	}
	
	static void q13() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q13", "Q13"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q13();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q13", "Q13"};
        	symbol =  new String[]{"A", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q13();
		}else if(tape.get(head).equals("X")) {
        	states = new String[]{"Q13", "Q11"};
        	symbol =  new String[]{"X", "X"};
        	direction = "L";
			operate("X", "L");
			record(states, symbol, direction);
			q11();
		}
	}
	
	static void q14() {
		if(tape.get(head).equals("X")) {
        	states = new String[]{"Q14", "Q14"};
        	symbol =  new String[]{"X", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q14();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q14", "Q15"};
        	symbol =  new String[]{"A", "A"};
        	direction = "L";
			operate("A", "L");
			record(states, symbol, direction);
			q15();
		}
	}
	
	static void q15() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q15", "Q15"};
        	symbol =  new String[]{"0", "0"};
        	direction = "L";
			operate("0", "L");
			record(states, symbol, direction);
			q15();
		}else if(tape.get(head).equals("C")) {
        	states = new String[]{"Q15", "Q15"};
        	symbol =  new String[]{"C", "C"};
        	direction = "L";
			operate("C", "L");
			record(states, symbol, direction);
			q15();
		}else if(tape.get(head).equals("D")) {
        	states = new String[]{"Q15", "Q9"};
        	symbol =  new String[]{"D", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q9();
		}
	}
	
	static void q16() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q16", "Q16"};
        	symbol =  new String[]{"0", "D"};
        	direction = "R";
			operate("D", "R");
			record(states, symbol, direction);
			q16();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q16", "Q17"};
        	symbol =  new String[]{"A", "D"};
        	direction = "L";
			operate("D", "L");
			record(states, symbol, direction);
			q17();
		}
	}
	
	static void q17() {
		if(tape.get(head).equals("D")) {
        	states = new String[]{"Q17", "Q17"};
        	symbol =  new String[]{"D", "D"};
        	direction = "L";
			operate("D", "L");
			record(states, symbol, direction);
			q17();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q17", "Q17"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q17();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q17", "Q6"};
        	symbol =  new String[]{"A", "A"};
        	direction = "R";
			operate("A", "R");
			record(states, symbol, direction);
			q6();
		}
	}
	
	static void q18() {
		if(tape.get(head).equals("0")) {
        	states = new String[]{"Q18", "Q18"};
        	symbol =  new String[]{"0", "B"};
        	direction = "L";
			operate("B", "L");
			record(states, symbol, direction);
			q18();
		}else if(tape.get(head).equals("1")) {
        	states = new String[]{"Q18", "Q18"};
        	symbol =  new String[]{"1", "B"};
        	direction = "L";
			operate("B", "L");
			record(states, symbol, direction);
			q18();
		}else if(tape.get(head).equals("Y")) {
        	states = new String[]{"Q18", "Q18"};
        	symbol =  new String[]{"Y", "B"};
        	direction = "L";
			operate("B", "L");
			record(states, symbol, direction);
			q18();
		}
		else if(tape.get(head).equals("B")) {
        	states = new String[]{"Q18", "Q19"};
        	symbol =  new String[]{"B", "B"};
        	direction = "R";
			operate("B", "R");
			record(states, symbol, direction);
			q19();
		}
	}
	
	static void q19() {
		if(tape.get(head).equals("B")) {
        	states = new String[]{"Q19", "Q19"};
        	symbol =  new String[]{"B", "B"};
        	direction = "R";
			operate("B", "R");
			record(states, symbol, direction);
			q19();
		}else if(tape.get(head).equals("A")) {
        	states = new String[]{"Q19", "Q19"};
        	symbol =  new String[]{"A", "B"};
        	direction = "R";
			operate("B", "R");
			record(states, symbol, direction);
			q19();
		}else if(tape.get(head).equals("D")) {
        	states = new String[]{"Q19", "Q19"};
        	symbol =  new String[]{"D", "B"};
        	direction = "R";
			operate("B", "R");
			record(states, symbol, direction);
			q19();
		}else if(tape.get(head).equals("0")) {
        	states = new String[]{"Q19", "Q19"};
        	symbol =  new String[]{"0", "0"};
        	direction = "R";
			operate("0", "R");
			record(states, symbol, direction);
			q19();
		}else if(tape.get(head).equals("C")) {
        	states = new String[]{"Q19", "Q20"};
        	symbol =  new String[]{"C", "B"};
        	direction = "R";
			operate("B", "R");
			record(states, symbol, direction);
			q20();
		}
	}
	
	static void q20() { //FINAL
    	states = new String[]{"", ""};
    	symbol =  new String[]{"", ""};
    	direction = "";
    	record(states, symbol, direction);
	}
}

