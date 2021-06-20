package tubes;

import java.util.ArrayList;

public class Modulo {
    
	static ArrayList<String> tape_1, tape_2, tape_3;
    static String str_tape_1, str_tape_2, str_tape_3;
    static TuringMachine TM;
    static int head_1, head_2, head_3;
    static String[] states, symbol;
    static String direction;
    
    static TuringMachine start(int input_1, int input_2) {
    	
    	TM = new TuringMachine();

    	tape_1 = new ArrayList<String>();
        tape_2 = new ArrayList<String>();
        tape_3 = new ArrayList<String>();
    	
        head_1 = head_2 = head_3 = 0;
      
        fill_tape(input_1, input_2);
        
        states = new String[]{"Q0", "Q0"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
        record(states, symbol, direction);
        
        q0();
        return TM;
    }

    static void fill_tape(int input_1, int input_2) {
        for(int i = 0; i < input_1; i++) {
            tape_1.add("0");
            tape_2.add("B");
            tape_3.add("B");
        }
        tape_1.add("1");
        tape_2.add("B");
        tape_3.add("B");
        for(int i = 0; i < input_2; i++) {
            tape_1.add("0");
            tape_2.add("B");
            tape_3.add("B");
        }
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
        	states = new String[]{"Q0", "Q1"};
        	symbol =  new String[]{"0BB", "B0B"};
        	direction = "RRN";
            operate("B0B", "RRN");
            record(states, symbol, direction);
            q0();
        }
        if (value.equals("1BB")) {
        	states = new String[]{"Q0", "Q1"};
        	symbol =  new String[]{"1BB", "BBB"};
        	direction = "RLN";
            operate("BBB", "RLN");
            record(states, symbol, direction);
            q1();
        }
    }

    static void q1() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q1", "Q1"};
			symbol =  new String[]{"00B", "00B"};
			direction = "RLN";
            operate("00B", "RLN");
            record(states, symbol, direction);;
            q1();
        }
        if (value.equals("0BB")) {
            operate("0BB", "NRN");
            states = new String[]{"Q1", "Q2"};
    		symbol =  new String[]{"0BB", "0BB"};
    		direction = "NRN";
            record(states, symbol, direction);;
            q2();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q1", "Q5"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "LNN";
            operate("B0B", "LNN");
            record(states, symbol, direction);;
            q5();
        }
    }

    static void q2() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "RRN";
            operate("00B", "RRN");
            record(states, symbol, direction);;
            q2();
        }
        if (value.equals("0BB")) {
        	states = new String[]{"Q2", "Q3"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "NLN";
            operate("0BB", "NLN");
            record(states, symbol, direction);;
            q3();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q2", "Q6"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "NLN";
            operate("B0B", "NLN");
            record(states, symbol, direction);;
            q6();
        }
        if (value.equals("BBB")) {
        	states = new String[]{"Q2", "Q7"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
            operate("BBB", "NNN");
            record(states, symbol, direction);;
            q7();
        }
    }

    static void q3() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "RLN";
            operate("00B", "RLN");
            record(states, symbol, direction);;
            q3();
        }
        if (value.equals("0BB")) {
        	states = new String[]{"Q3", "Q2"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "NRN";
            operate("0BB", "NRN");
            record(states, symbol, direction);;
            q2();
        }
        if (value.equals("B0B")) {
        	states = new String[]{"Q3", "Q4"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "NRN";
            operate("B0B", "NRN");
            record(states, symbol, direction);;
            q4();
        }
        if (value.equals("BBB")) {
        	states = new String[]{"Q3", "Q7"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
            operate("BBB", "NNN");
            record(states, symbol, direction);;
            q7();
        }
    }

    static void q4() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("B0B")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"B0B", "B00"};
        	direction = "NRR";
            operate("B00", "NRR");
            record(states, symbol, direction);;
            q4();
        }
        if (value.equals("BBB")) {
        	states = new String[]{"Q4", "Q7"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
            operate("BBB", "NNN");
            record(states, symbol, direction);;
            q7();
        }
    }

    static void q5() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("00B")) {
            operate("000", "LNR");
            states = new String[]{"Q5", "Q5"};
            symbol =  new String[]{"00B", "000"};
            direction = "LNR";
            record(states, symbol, direction);;
            q5();
        }
        if (value.equals("B0B")) {
            operate("B0B", "NNN");
            states = new String[]{"Q5", "Q7"};
            symbol =  new String[]{"B0B", "B0B"};
            direction = "NNN";
            record(states, symbol, direction);;
            q7();
        }
    }

    static void q6() {
        String value = tape_1.get(head_1) + tape_2.get(head_2) + tape_3.get(head_3);
        if (value.equals("B0B")) {
        	states = new String[]{"Q6", "Q6"};
        	symbol =  new String[]{"B0B", "B00"};
        	direction = "NLR";
            operate("B00", "NLR");
            record(states, symbol, direction);;
            q6();
        }
        if (value.equals("BBB")) {
        	states = new String[]{"Q6", "Q7"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
            operate("BBB", "NNN");
            record(states, symbol, direction);;
            q7();
        }
    }

    static void q7() {
        states = new String[]{"Q7", "Q7"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
        record(states, symbol, direction);;
        end();
    }
    
    static void end() {
    	int count = 0;
    	String[] output = new String[2];
        for (String i : tape_3) {
            if (i.equals("0")) {
                count++;
            }
        }
//        System.out.println("Hasilnya = " + count);
        output[0] = String.valueOf(count);
    }

//    public static void main(String[] argrs) {
//
//        int input_1 = 3;
//        int input_2 = 5;
//        
//        System.out.println("Modulo dari " + input_1 + " dan " + input_2);
//        float start = System.nanoTime();
//        start(input_1, input_2);
//        float end = System.nanoTime();
//        float total = end - start;
//        System.out.println("Time exec: " + total/1000000000 + " detik");
//    }
}
