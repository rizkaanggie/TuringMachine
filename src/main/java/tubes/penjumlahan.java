package tubes;

import java.util.ArrayList;

public class penjumlahan {
	static ArrayList<String> tape = new ArrayList<String>();
	static int tape_pos;
	static boolean record_on;
	
	static void input_to_tape(int a, int b) {
		
		for(int i=0;i<Math.abs(a);i++) {
			if(a<0) {
				tape.add("B");
			}else {
				tape.add("0");
			}
		}
		
		tape.add("1");
		
		for(int i=0;i<Math.abs(b);i++) {
			if(b<0) {
				tape.add("B");
			}else {
				tape.add("0");
			}
		}
		
		
	}
	
	static void printAL() {
		for(int i=0;i<tape.size();i++) {
			System.out.print(tape.get(i));
		}
		System.out.println();
	}
	
	static void increaseBoundary() {
		if (tape_pos<0) {
			tape.add(0,"B");
			tape_pos++;
		}
		
		if (tape_pos>=tape.size()) {
			tape.add("B");
		}
	}
	
	static void operate(String after, String direction) {
		tape.set(tape_pos,String.valueOf(after));
		
		if(direction.charAt(0) == 'R') {
			tape_pos++;
		}else if (direction.charAt(0) == 'L'){
			tape_pos--;
		}		
		increaseBoundary();
	}
	
	static void q0() {
		if(record_on == true) {
			System.out.println("q0");
		}
		
		if(tape.get(tape_pos).equals("0")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape.get(tape_pos).equals("1")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape.get(tape_pos).equals("B")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}	
	}
	
	static void q1() {
		if(record_on == true) {
			System.out.println("q1");
		}
		
		if(tape.get(tape_pos).equals("1")) {
			operate("1", "R");
			if(record_on == true) {
				printAL();
			}
			q2();
		}else if(tape.get(tape_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape.get(tape_pos).equals("B")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q1();
		}
	}
	
	static void q2() {
		if(record_on == true) {
			System.out.println("q2");
		}
		
		if(tape.get(tape_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q2();
		}else if(tape.get(tape_pos).equals("B")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}
	}
	
	static void q3() {
		if(record_on == true) {
			System.out.println("q3");
		}
		
		if(tape.get(tape_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape.get(tape_pos).equals("1")) {
			operate("1", "L");
			if(record_on == true) {
				printAL();
			}
			q4();
		}
	}
	
	static void q4() {
		if(record_on == true) {
			System.out.println("q4");
		}
		
		if(tape.get(tape_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape.get(tape_pos).equals("B")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}
	}
	
	static void q5() {
		int penambah = 0;
		int hasil = 0;
		
		System.out.println("State akhir:");
		printAL();
		boolean tanda_sudah = false;
		for(int i=0;i<tape.size();i++) {
			if(tape.get(i).equals("0") && tanda_sudah == false) {
				penambah = 1;
				tanda_sudah = true;
			}else if(tape.get(i).equals("B") && tanda_sudah == false) {
				penambah = -1;
				tanda_sudah = true;
			}else if(tape.get(i).equals("0") && tanda_sudah == true) {
				hasil++;
			}
		}
		
		System.out.println("Jawaban Akhir = "+ hasil);
	}

	public static void main(String[] argrs) {
		tape_pos = 0;
		
		record_on = false;
		
		int input_1 = 10;
		int input_2 = -2;
		
		System.out.println("Penjumlahan antara "+input_1+" dengan "+input_2+"\n");
		
		System.out.println("State Awal :");
		input_to_tape(input_1,input_2);
		printAL();
		
		q0();
				
	}
}

