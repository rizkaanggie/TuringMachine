package tubes;

import java.util.ArrayList;

public class Pengurangan {
	
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
      
        input_to_tape_1(input_1, input_2);
        filltape_2tape_3();
		
		states = new String[]{"Q0", "Q0"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
        record(states, symbol, direction);
        
        q0();
        
        return TM;
    }
	
	static void input_to_tape_1(int a, int b) {
		if(a<0) {
			tape_1.add("-");
		} else {
			tape_1.add("+");
		}
		
		for(int i=0;i<Math.abs(a);i++) {
                    tape_1.add("0");
		}
		
		tape_1.add("1");
                
                if(b<0) {
			tape_1.add("-");
		} else {
			tape_1.add("+");
		}
		
		for(int i=0;i<Math.abs(b);i++) {
			tape_1.add("0");
                }
                
	}
	
	static void filltape_2tape_3() {
		for(int i=0;i<tape_1.size();i++) {
			tape_2.add("B");
			tape_3.add("B");
		}
	}
	
	static void increaseBoundary() {
		if (head_1<0 || head_2<0 || head_3<0) {
			tape_1.add(0,"B");
			tape_3.add(0,"B");
			tape_2.add(0,"B");
			head_1++;
			head_2++;
			head_3++;
		}
		
		if (head_1>=tape_1.size() || head_2>=tape_1.size() || head_3>=tape_1.size()) {
			tape_1.add("B");
			tape_3.add("B");
			tape_2.add("B");
		}
	}
	
	//syntax, after = 1BB or 0BB, direction = RNL (right, not move, left)
        
	static void operate(String after, String direction) {
     
		tape_1.set(head_1,String.valueOf(after.charAt(0)));
		tape_2.set(head_2,String.valueOf(after.charAt(1)));
		tape_3.set(head_3,String.valueOf(after.charAt(2)));
	 
		if(direction.charAt(0) == 'R') {
			head_1++;
		}else if (direction.charAt(0) == 'L'){
			head_1--;
		}else if (direction.charAt(0) == 'N') {
			head_1 = head_1;
		}
		
		if(direction.charAt(1) == 'R') {
			head_2++;
		}else if (direction.charAt(1) == 'L'){
			head_2--;
		}else if (direction.charAt(1) == 'N') {
			head_2 = head_2;
		}

		if(direction.charAt(2) == 'R') {
			head_3++;
		}else if (direction.charAt(2) == 'L'){
			head_3--;
		}else if (direction.charAt(2) == 'N') {
			head_3 = head_3;
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
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "RNN";
			operate("0BB", "RNN");
			record(states, symbol, direction);
			q0();
		}else if(tape_1.get(head_1).equals("+") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"+BB", "+BB"};
        	direction = "RNN";
			operate("+BB", "RNN");
			record(states, symbol, direction);
			q0();
		}else if(tape_1.get(head_1).equals("-") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q0", "Q0"};
        	symbol =  new String[]{"-BB", "-BB"};
        	direction = "RNN";
			operate("-BB", "RNN");
			record(states, symbol, direction);
			q0();
		}else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q0", "Q1"};
        	symbol =  new String[]{"1BB", "1BB"};
        	direction = "RNN";
			operate("1BB", "RNN");
			record(states, symbol, direction);
			q1();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q0", "QFinal"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
			operate("BBB", "NNN");
			record(states, symbol, direction);
			qFinal();
		}
               
	}
	
	static void q1() {
		if(tape_1.get(head_1).equals("0")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"0BB", "B0B"};
        	direction = "RRN";
			operate("B0B", "RRN");
			record(states, symbol, direction);
			q1();
		}else if(tape_1.get(head_1).equals("+")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"+BB", "B+B"};
        	direction = "RRN";
			operate("B+B", "RRN");
			record(states, symbol, direction);
			q1();
		}else if(tape_1.get(head_1).equals("-")) {
        	states = new String[]{"Q1", "Q1"};
        	symbol =  new String[]{"-BB", "B-B"};
        	direction = "RRN";
			operate("B-B", "RRN");
			record(states, symbol, direction);
			q1();
		}else if(tape_1.get(head_1).equals("B")) {
        	states = new String[]{"Q1", "Q2"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "LLN";
			operate("BBB", "LLN");
			record(states, symbol, direction);
			q2();
		}
	
	}
	
	static void q2() {
		if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"B0B", "B0B"};
        	direction = "LLN";
			operate("B0B", "LLN");
			record(states, symbol, direction);
			q2();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("0")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "LLN";
			operate("00B", "LLN");
			record(states, symbol, direction);
			q2();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("+")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"0+B","0+B"};
        	direction = "LNN";
			operate("0+B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("-")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"0-B", "0-B"};
        	direction = "LNN";
			operate("0-B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("+")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"B+B", "B+B"};
        	direction = "LNN";
			operate("B+B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("-")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"B-B", "B-B"};
        	direction = "LNN";
			operate("B-B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("0")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"10B", "B0B"};
        	direction = "LNN";
			operate("B0B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("+")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"1+B", "B+B"};
        	direction = "LNN";
			operate("B+B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("-")) {
        	states = new String[]{"Q2", "Q2"};
        	symbol =  new String[]{"1-B", "B-B"};
        	direction = "LNN";
			operate("B-B", "LNN");
			record(states, symbol, direction);
			q2();
        }else if(tape_1.get(head_1).equals("-") && tape_2.get(head_2).equals("+") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q3"};
        	symbol =  new String[]{"-+B", "-+-"};
        	direction = "RNR";
			operate("-+-", "RNR");
			record(states, symbol, direction);
			q3();
        }else if(tape_1.get(head_1).equals("+") && tape_2.get(head_2).equals("-") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q3"};
        	symbol =  new String[]{"+-B", "+-+"};
        	direction = "RNR";
			operate("+-+", "RNR");
			record(states, symbol, direction);
			q3();
        }else if(tape_1.get(head_1).equals("+") && tape_2.get(head_2).equals("+") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q4"};
        	symbol =  new String[]{"++B", "++B"};
        	direction = "RRN";
			operate("++B", "RRN");
			record(states, symbol, direction);
			q4();
        }else if(tape_1.get(head_1).equals("-") && tape_2.get(head_2).equals("-") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q5"};
        	symbol =  new String[]{"--B", "--B"};
        	direction = "RRN";
			operate("--B", "RRN");
			record(states, symbol, direction);
			q5();
        }else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q8"};
        	symbol =  new String[]{"1BB", "BBB"};
        	direction = "LRN";
			operate("BBB", "LRN");
			record(states, symbol, direction);
			q8();
		}else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("-") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q9"};
        	symbol =  new String[]{"1-B", "B-B"};
        	direction = "NNN";
			operate("B-B", "NNN");
			record(states, symbol, direction);
			q9();
		}else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("+") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q2", "Q9"};
        	symbol =  new String[]{"1+B", "B-B"};
        	direction = "NNN";
			operate("B-B", "NNN");
			record(states, symbol, direction);
			q9();
		}               
	}
	
	static void q3() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("+")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"0+B", "0+0"};
        	direction = "RNR";
			operate("0+0", "RNR");
			record(states, symbol, direction);
			q3();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("-")) {
        	states = new String[]{"Q3", "Q3"};
        	symbol =  new String[]{"0-B", "0-0"};
        	direction = "RNR";
			operate("0-0", "RNR");
			record(states, symbol, direction);
			q3();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("+")) {
        	states = new String[]{"Q3", "Q7"};
        	symbol =  new String[]{"B+B", "B+B"};
        	direction = "NRN";
			operate("B+B", "NRN");
			record(states, symbol, direction);
			q7();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("-")) {
        	states = new String[]{"Q3", "Q7"};
        	symbol =  new String[]{"B-B", "B-B"};
        	direction = "NRN";
			operate("B-B", "NRN");
			record(states, symbol, direction);
			q7();
		}
	}
	
	static void q4() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q4", "Q4"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "RRN";
			operate("00B", "RRN");
			record(states, symbol, direction);
			q4();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q4", "Q6"};
        	symbol =  new String[]{"B0B", "B0-"};
        	direction = "NNR";
			operate("B0-", "NNR");
			record(states, symbol, direction);
			q6();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q4", "Q6"};
        	symbol =  new String[]{"0BB", "0B+"};
        	direction = "NNR";
			operate("0B+", "NNR");
			record(states, symbol, direction);
			q6();
		}
	}
	
	static void q5() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q5", "Q5"};
        	symbol =  new String[]{"00B", "00B"};
        	direction = "RRN";
			operate("00B", "RRN");
			record(states, symbol, direction);
			q5();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q5", "Q6"};
        	symbol =  new String[]{"B0B", "B0+"};
        	direction = "NNR";
			operate("B0+", "NNR");
			record(states, symbol, direction);
			q6();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q5", "Q6"};
        	symbol =  new String[]{"0BB", "0B-"};
        	direction = "NNR";
			operate("0B-", "NNR");
			record(states, symbol, direction);
			q6();
		}
	}
	
	static void q6() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q6", "Q6"};
        	symbol =  new String[]{"0BB", "0B0"};
        	direction = "RNR";
			operate("0B0", "RNR");
			record(states, symbol, direction);
			q6();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q6", "Q6"};
        	symbol =  new String[]{"B0B", "B00"};
        	direction = "NRR";
			operate("B00", "NRR");
			record(states, symbol, direction);
			q6();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q6", "QFinal"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
			operate("BBB", "NNN");
			record(states, symbol, direction);
			qFinal();
		}

	}
	
    static void q7() {
		if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q7", "Q7"};
        	symbol =  new String[]{"B0B", "B00"};
        	direction = "NRR";
			operate("B00", "NRR");
			record(states, symbol, direction);
			q7();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q7", "Q7"};
        	symbol =  new String[]{"B0B", "B00"};
        	direction = "NRR";
			operate("BBB", "NNN");
			record(states, symbol, direction);
			qFinal();
		}

	}
        
    static void q8() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	        	states = new String[]{"Q8", "Q8"};
        	symbol =  new String[]{"0BB", "0BB"};
        	direction = "LNN";
			operate("0BB", "LNN");
			record(states, symbol, direction);
			q8();
		}else if(tape_1.get(head_1).equals("+") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q8", "Q10"};
        	symbol =  new String[]{"+BB", "+BB"};
        	direction = "NNN";
			operate("+BB", "NNN");
			record(states, symbol, direction);
			q10();
		}else if(tape_1.get(head_1).equals("-") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q8", "Q10"};
        	symbol =  new String[]{"-BB", "-BB"};
        	direction = "NNN";
			operate("-BB", "NNN");
			record(states, symbol, direction);
			q10();
		}

	}
    static void q9() {		
		if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("+") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q9", "Q9"};
        	symbol =  new String[]{"B+B", "B++"};
        	direction = "NRR";
			operate("B++", "NRR");
			record(states, symbol, direction);
			q9();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("-") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q9", "Q9"};
        	symbol =  new String[]{"B-B", "B--"};
        	direction = "NRR";
			operate("B--", "NRR");
			record(states, symbol, direction);
			q9();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q9", "Q9"};
        	symbol =  new String[]{"B0B", "B00"};
        	direction = "NRR";
			operate("B00", "NRR");
			record(states, symbol, direction);
			q9();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q9", "QFinal"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
			operate("BBB", "NNN");
			record(states, symbol, direction);
			qFinal();
		}

	}
    static void q10() {
		if(tape_1.get(head_1).equals("+") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q10", "Q10"};
        	symbol =  new String[]{"+BB", "+B+"};
        	direction = "RNR";
			operate("+B+", "RNR");
			record(states, symbol, direction);
			q10();
		}else if(tape_1.get(head_1).equals("-") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q10", "Q10"};
        	symbol =  new String[]{"-BB", "-B-"};
        	direction = "RNR";
			operate("-B-", "RNR");
			record(states, symbol, direction);
			q10();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q10", "Q10"};
        	symbol =  new String[]{"0BB", "0B0"};
        	direction = "RNR";
			operate("0B0", "RNR");
			record(states, symbol, direction);
			q10();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
        	states = new String[]{"Q10", "QFinal"};
        	symbol =  new String[]{"BBB", "BBB"};
        	direction = "NNN";
			operate("BBB", "NNN");
			record(states, symbol, direction);
			qFinal();
		}

	}
        
	static void qFinal() {
		record(states, symbol, direction);
	}
}