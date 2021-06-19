/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;

public class perpangkatan {
	static ArrayList<String> tape1 = new ArrayList<String>();
	static int tape1_pos;
	static boolean record_on;
	
	static void input_to_tape_1(int a, int b) {	
		for(int i=0;i<Math.abs(a);i++) {
			tape1.add("0");
		}
		
		tape1.add("1");
		
		for(int i=0;i<Math.abs(b);i++) {
			tape1.add("0");
		}
	}
	
	static void printAL() {
		for(int i=0;i<tape1.size();i++) {
			System.out.print(tape1.get(i));
		}
		System.out.println();
		System.out.println();
	}
	
	static void increaseBoundary() {
		if (tape1_pos<0) {
			tape1.add(0,"B");
			tape1_pos++;
		}
		
		if (tape1_pos>=tape1.size()) {
			tape1.add("B");
		}
	}
	
	static void operate(String after, String direction) {
		tape1.set(tape1_pos,after);
		
		if(direction.equals("R")) {
			tape1_pos++;
		}else if (direction.equals("L")){
			tape1_pos--;
		}else if (direction.equals("N")) {
			tape1_pos = tape1_pos;
		}
		
		increaseBoundary();
	}
	
	static void q0() {
		if(record_on == true) {
			System.out.println("q0");
		}
		
		if(tape1.get(tape1_pos).equals("Y")) {
			operate("Y", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("X")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("1")) {
			operate("1", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("B")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "R");
			if(record_on == true) {
				printAL();
			}
			q6();
		}
	}
	
	static void q1() {
		if(record_on == true) {
			System.out.println("q1");
		}
		
		if(tape1.get(tape1_pos).equals("D")) {
			operate("D", "L");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("1")) {
			operate("1", "R");
			if(record_on == true) {
				printAL();
			}
			q2();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q7();
		}
	}
	
	static void q2() {
		if(record_on == true) {
			System.out.println("q2");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("Y", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("B", "L");
			if(record_on == true) {
				printAL();
			}
			q6();
		}
	}
	
	static void q3() {
		if(record_on == true) {
			System.out.println("q3");
		}
		
		if(tape1.get(tape1_pos).equals("X")) {
			operate("X", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape1.get(tape1_pos).equals("Y")) {
			operate("Y", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape1.get(tape1_pos).equals("1")) {
			operate("1", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("X", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("B")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q0();
		}
	}
	
	static void q4() {
		if(record_on == true) {
			System.out.println("q4");
		}
		
		if(tape1.get(tape1_pos).equals("D")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("C")) {
			operate("C", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("X")) {
			operate("X", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("Y")) {
			operate("Y", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("1")) {
			operate("1", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "R");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("B")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q5();
		}
	}
	
	static void q5() {
		if(record_on == true) {
			System.out.println("q5");
		}
		
		if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape1.get(tape1_pos).equals("0") ) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape1.get(tape1_pos).equals("Y") ) {
			operate("Y", "L");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape1.get(tape1_pos).equals("C") ) {
			operate("C", "L");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape1.get(tape1_pos).equals("D") ) {
			operate("D", "L");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape1.get(tape1_pos).equals("1") ) {
			operate("1", "L");
			if(record_on == true) {
				printAL();
			}
			q3();
		}
	}
	
	static void q6() {
		if(record_on == true) {
			System.out.println("q6");
		}
				
		if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q6();
		}else if(tape1.get(tape1_pos).equals("D") ) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q6();
		}else if(tape1.get(tape1_pos).equals("Y") ) {
			operate("B", "L");
			if(record_on == true) {
				printAL();
			}
			q18();
		}else if(tape1.get(tape1_pos).equals("C") ) {
			operate("C", "L");
			if(record_on == true) {
				printAL();
			}
			q8();
		}
		else if(tape1.get(tape1_pos).equals("B") ) {
			operate("C", "L");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("A") ) {
			operate("A", "R");
			if(record_on == true) {
				printAL();
			}
			q1();
		}
	}
	
	static void q7() {
		if(record_on == true) {
			System.out.println("q7");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q7();
		}else if(tape1.get(tape1_pos).equals("Y")) {
			operate("Y", "R");
			if(record_on == true) {
				printAL();
			}
			q2();
		}
	}
	
	static void q8() {
		if(record_on == true) {
			System.out.println("q8");
		}
				
		if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q8();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "R");
			if(record_on == true) {
				printAL();
			}
			q9();
		}else if(tape1.get(tape1_pos).equals("D")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q9();
		}
	}
	
	static void q9() {
		if(record_on == true) {
			System.out.println("q9");
		}
		
		if(tape1.get(tape1_pos).equals("C")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q16();
		}else if(tape1.get(tape1_pos).equals("D")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q9();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q10();
		}
	}
	
	static void q10() {
		if(record_on == true) {
			System.out.println("q10");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q10();
		}else if(tape1.get(tape1_pos).equals("C")) {
			operate("C", "R");
			if(record_on == true) {
				printAL();
			}
			q10();
		}else if(tape1.get(tape1_pos).equals("B")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q11();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q11();
		}
	}
	
	static void q11() {
		if(record_on == true) {
			System.out.println("q11");
		}
		
		if(tape1.get(tape1_pos).equals("X")) {
			operate("X", "L");
			if(record_on == true) {
				printAL();
			}
			q11();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("X", "R");
			if(record_on == true) {
				printAL();
			}
			q12();
		}else if(tape1.get(tape1_pos).equals("C")) {
			operate("C", "R");
			if(record_on == true) {
				printAL();
			}
			q14();
		}
	}
	
	static void q12() {
		if(record_on == true) {
			System.out.println("q12");
		}
		
		if(tape1.get(tape1_pos).equals("X")) {
			operate("X", "R");
			if(record_on == true) {
				printAL();
			}
			q12();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q12();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "R");
			if(record_on == true) {
				printAL();
			}
			q12();
		}else if(tape1.get(tape1_pos).equals("B")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q13();
		}
	}
	
	static void q13() {
		if(record_on == true) {
			System.out.println("q12");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q13();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q13();
		}else if(tape1.get(tape1_pos).equals("X")) {
			operate("X", "L");
			if(record_on == true) {
				printAL();
			}
			q11();
		}
	}
	
	static void q14() {
		if(record_on == true) {
			System.out.println("q14");
		}
		
		if(tape1.get(tape1_pos).equals("X")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q14();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "L");
			if(record_on == true) {
				printAL();
			}
			q15();
		}
	}
	
	static void q15() {
		if(record_on == true) {
			System.out.println("q15");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "L");
			if(record_on == true) {
				printAL();
			}
			q15();
		}else if(tape1.get(tape1_pos).equals("C")) {
			operate("C", "L");
			if(record_on == true) {
				printAL();
			}
			q15();
		}else if(tape1.get(tape1_pos).equals("D")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q9();
		}
	}
	
	static void q16() {
		if(record_on == true) {
			System.out.println("q16");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("D", "R");
			if(record_on == true) {
				printAL();
			}
			q16();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("D", "L");
			if(record_on == true) {
				printAL();
			}
			q17();
		}
	}
	
	static void q17() {
		if(record_on == true) {
			System.out.println("q17");
		}
		
		if(tape1.get(tape1_pos).equals("D")) {
			operate("D", "L");
			if(record_on == true) {
				printAL();
			}
			q17();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q17();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("A", "R");
			if(record_on == true) {
				printAL();
			}
			q6();
		}
	}
	
	static void q18() {
		if(record_on == true) {
			System.out.println("q18");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("B", "L");
			if(record_on == true) {
				printAL();
			}
			q18();
		}else if(tape1.get(tape1_pos).equals("1")) {
			operate("B", "L");
			if(record_on == true) {
				printAL();
			}
			q18();
		}else if(tape1.get(tape1_pos).equals("Y")) {
			operate("B", "L");
			if(record_on == true) {
				printAL();
			}
			q18();
		}
		else if(tape1.get(tape1_pos).equals("B")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q19();
		}
	}
	
	static void q19() {
		if(record_on == true) {
			System.out.println("q19");
		}
		
		if(tape1.get(tape1_pos).equals("B")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q19();
		}else if(tape1.get(tape1_pos).equals("A")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q19();
		}else if(tape1.get(tape1_pos).equals("D")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q19();
		}else if(tape1.get(tape1_pos).equals("0")) {
			operate("0", "R");
			if(record_on == true) {
				printAL();
			}
			q19();
		}else if(tape1.get(tape1_pos).equals("C")) {
			operate("B", "R");
			if(record_on == true) {
				printAL();
			}
			q20();
		}
	}
	
	static void q20() { //FINAL
		int hasil = 0;
		
		System.out.println("State akhir:");
		printAL();
		for(int i=0;i<tape1.size();i++) {
			if(tape1.get(i).equals("0")) {
				hasil++;
			}
		}
		
		System.out.println("Jawaban Akhir = "+hasil);
	}
	
	public static void main(String[] argrs) {
		tape1_pos = 0;
		
		record_on = false;
		
		int input_1 = 4;
		int input_2 = 3;
		
		System.out.println("Hasil dari "+input_1+" pangkat "+input_2+" adalah: \n");
		
		System.out.println("State Awal :");
		input_to_tape_1(input_1,input_2);
		printAL();
		
		q0();
				
	}
}

