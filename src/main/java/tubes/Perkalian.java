package tubes;

import java.util.ArrayList;

public class Perkalian {
	
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
      
        input_to_tape_1(input_1,input_2);
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
			tape_1.add("1");
		} else {
			tape_1.add("0");
		}
		
		if(b<0) {
			tape_1.add("1");
		} else {
			tape_1.add("0");
		}
		
		for(int i=0;i<Math.abs(a);i++) {
			tape_1.add("0");
		}
		
		tape_1.add("1");
		
		for(int i=0;i<Math.abs(b);i++) {
			tape_1.add("0");
		}
		
		tape_1.add("1");
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
		}
		
		if(direction.charAt(1) == 'R') {
			head_2++;
		}else if (direction.charAt(1) == 'L'){
			head_2--;
		}
		
		if(direction.charAt(2) == 'R') {
			head_3++;
		}else if (direction.charAt(2) == 'L'){
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
		if(tape_1.get(head_1).equals("1")) {
			states = new String[]{"Q0", "Q1"};
	    	symbol =  new String[]{"1BB", "B1B"};
	    	direction = "RNN";
			operate("B1B", "RNN");
			record(states, symbol, direction);
			q1();
		}else if(tape_1.get(head_1).equals("0")) {
			states = new String[]{"Q0", "Q2"};
	    	symbol =  new String[]{"0BB", "B0B"};
	    	direction = "RNN";
			operate("B0B", "RNN");
			record(states, symbol, direction);
			q2();
		}
               
	}
	
	static void q1() {
		if(tape_1.get(head_1).equals("1")) {
			states = new String[]{"Q1", "Q3"};
	    	symbol =  new String[]{"11B", "BB0"};
	    	direction = "RNR";
			operate("BB0", "RNR");
			record(states, symbol, direction);
			q3();
		}else if(tape_1.get(head_1).equals("0")) {
			states = new String[]{"Q1", "Q3"};
	    	symbol =  new String[]{"01B", "BB1"};
	    	direction = "RNR";
			operate("BB1", "RNR");
			record(states, symbol, direction);
			q3();
		}
	}
	
	static void q2() {
		if(tape_1.get(head_1).equals("1")) {
			states = new String[]{"Q2", "Q4"};
	    	symbol =  new String[]{"10B", "BB1"};
	    	direction = "RNR";
			operate("BB1", "RNR");
			record(states, symbol, direction);
			q4();
		}else if(tape_1.get(head_1).equals("0")) {
			states = new String[]{"Q2", "Q4"};
	    	symbol =  new String[]{"00B", "BB0"};
	    	direction = "RNR";
			operate("BB0", "RNR");
			record(states, symbol, direction);
			q4();
		}
	}
	
	static void q3() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q3", "Q3"};
	    	symbol =  new String[]{"1BB", "BBB"};
	    	direction = "RRN";
			operate("B0B", "RRN");
			record(states, symbol, direction);
			q3();
		}else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q3", "Q5"};
	    	symbol =  new String[]{"1BB", "BBB"};
	    	direction = "RLN";
			operate("BBB", "RLN");
			record(states, symbol, direction);
			q5();
		}
	}
	
	static void q4() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q4", "Q4"};
	    	symbol =  new String[]{"0BB", "B0B"};
	    	direction = "RRN";
			operate("B0B", "RRN");
			q4();
		}else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q4", "Q5"};
	    	symbol =  new String[]{"1BB", "BBB"};
	    	direction = "RLN";
			operate("BBB", "RLN");
			q5();
		}
	}
	
	static void q5() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q5", "Q5"};
	    	symbol =  new String[]{"0BB", "000"};
	    	direction = "RNR";
			operate("000", "RNR");
			record(states, symbol, direction);
			q5();
		}else if(tape_1.get(head_1).equals("1") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q5", "Q6"};
	    	symbol =  new String[]{"10B", "10B"};
	    	direction = "LLN";
			operate("10B", "LLN");
			record(states, symbol, direction);
			q6();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q5", "Q7"};
	    	symbol =  new String[]{"0BB", "0BB"};
	    	direction = "NNN";
			operate("0BB", "NNN");
			record(states, symbol, direction);
			q7();
		}
	}
	
	static void q6() {
		if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q6", "Q6"};
	    	symbol =  new String[]{"00B", "000"};
	    	direction = "LNR";
			operate("000", "LNR");
			record(states, symbol, direction);
			q6();
		}else if(tape_1.get(head_1).equals("B") && tape_2.get(head_2).equals("0") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q6", "Q5"};
	    	symbol =  new String[]{"B0B", "B0B"};
	    	direction = "RLN";
			operate("B0B", "RLN");
			record(states, symbol, direction);
			q5();
		}else if(tape_1.get(head_1).equals("0") && tape_2.get(head_2).equals("B") && tape_3.get(head_3).equals("B")) {
			states = new String[]{"Q6", "Q7"};
	    	symbol =  new String[]{"0BB", "0BB"};
	    	direction = "NNN";
			operate("0BB", "NNN");
			record(states, symbol, direction);
			q7();
		}

	}
	
	static void q7() {
		states = new String[]{"Q7", "Q7"};
    	symbol =  new String[]{"BBB", "BBB"};
    	direction = "NNN";
		record(states, symbol, direction);
	}
}

