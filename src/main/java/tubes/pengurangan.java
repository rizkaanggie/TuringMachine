/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;

public class pengurangan {
	static ArrayList<String> tape1 = new ArrayList<String>();
	static ArrayList<String> tape2 = new ArrayList<String>();
	static ArrayList<String> tape3 = new ArrayList<String>();
	static int tape1_pos, tape2_pos, tape3_pos;
	static boolean record_on;
	
	static void input_to_tape_1(int a, int b) {
		if(a<0) {
			tape1.add("-");
		} else {
			tape1.add("+");
		}
		
		for(int i=0;i<Math.abs(a);i++) {
                    tape1.add("0");
		}
		
		tape1.add("1");
                
                if(b<0) {
			tape1.add("-");
		} else {
			tape1.add("+");
		}
		
		for(int i=0;i<Math.abs(b);i++) {
			tape1.add("0");
                }
                
	}
	
	static void filltape2tape3() {
		for(int i=0;i<tape1.size();i++) {
			tape2.add("B");
			tape3.add("B");
		}
	}
	
	static void printAL() {
		for(int i=0;i<tape1.size();i++) {
			System.out.print(" " + tape1.get(i));
//                        System.out.print(i);
		}
		System.out.println();
		for(int i=0;i<tape2.size();i++) {
			System.out.print(" "+ tape2.get(i));
//                        System.out.print(i);
		}
		System.out.println();
		for(int i=0;i<tape3.size();i++) {
			System.out.print(" "+ tape3.get(i));
//                        System.out.print(i);
		}
		System.out.println();
		System.out.println();
	}
	
	static void increaseBoundary() {
		if (tape1_pos<0 || tape2_pos<0 || tape3_pos<0) {
			tape1.add(0,"B");
			tape3.add(0,"B");
			tape2.add(0,"B");
			tape1_pos++;
			tape2_pos++;
			tape3_pos++;
		}
		
		if (tape1_pos>=tape1.size() || tape2_pos>=tape1.size() || tape3_pos>=tape1.size()) {
			tape1.add("B");
			tape3.add("B");
			tape2.add("B");
		}
	}
	
	//syntax, after = 1BB or 0BB, direction = RNL (right, not move, left)
        
	static void operate(String after, String direction) {
     
		tape1.set(tape1_pos,String.valueOf(after.charAt(0)));
		tape2.set(tape2_pos,String.valueOf(after.charAt(1)));
		tape3.set(tape3_pos,String.valueOf(after.charAt(2)));
	 
		if(direction.charAt(0) == 'R') {
			tape1_pos++;
		}else if (direction.charAt(0) == 'L'){
			tape1_pos--;
		}else if (direction.charAt(0) == 'N') {
			tape1_pos = tape1_pos;
		}
		
		if(direction.charAt(1) == 'R') {
			tape2_pos++;
		}else if (direction.charAt(1) == 'L'){
			tape2_pos--;
		}else if (direction.charAt(1) == 'N') {
			tape2_pos = tape2_pos;
		}

		if(direction.charAt(2) == 'R') {
			tape3_pos++;
		}else if (direction.charAt(2) == 'L'){
			tape3_pos--;
		}else if (direction.charAt(2) == 'N') {
			tape3_pos = tape3_pos;
		}
		
		increaseBoundary();
	}
	
	static void q0() {
		if(record_on == true) {
			System.out.println("q0");
		}
		
		if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("0BB", "RNN");
			if(record_on == true) {
                            System.out.println(tape1_pos);
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("+") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("+BB", "RNN");
			if(record_on == true) {
                            System.out.println(tape1_pos);
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("-") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("-BB", "RNN");
			if(record_on == true) {
                            System.out.println(tape1_pos);
				printAL();
			}
			q0();
		}else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("1BB", "RNN");
			if(record_on == true) {
                            System.out.println(tape1_pos);
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("BBB", "NNN");
			if(record_on == true) {
                            System.out.println(tape1_pos);
				printAL();
			}
			qFinal();
		}
               
	}
	
	static void q1() {
		if(record_on == true) {
			System.out.println("q1");
		}
		
		if(tape1.get(tape1_pos).equals("0")) {
			operate("B0B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("+")) {
			operate("B+B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("-")) {
			operate("B-B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q1();
		}else if(tape1.get(tape1_pos).equals("B")) {
			operate("BBB", "LLN");
			if(record_on == true) {
				printAL();
			}
			q2();
		}
	
	}
	
	static void q2() {
		if(record_on == true) {
			System.out.println("q2");
		}
		
		if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("0")) {
			operate("B0B", "LLN");
			if(record_on == true) {
				printAL();
			}
			q2();
		}else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("0")) {
			operate("00B", "LLN");
			if(record_on == true) {
				printAL();
			}
			q2();
		}else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("+")) {
			operate("0+B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("-")) {
			operate("0-B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("+")) {
			operate("B+B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("-")) {
			operate("B-B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("0")) {
			operate("B0B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("+")) {
			operate("B+B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("-")) {
			operate("B-B", "LNN");
			if(record_on == true) {
				printAL();
			}
			q2();
                }else if(tape1.get(tape1_pos).equals("-") && tape2.get(tape2_pos).equals("+") && tape3.get(tape3_pos).equals("B")) {
			operate("-+-", "RNR");
			if(record_on == true) {
				printAL();
			}
			q3();
                }else if(tape1.get(tape1_pos).equals("+") && tape2.get(tape2_pos).equals("-") && tape3.get(tape3_pos).equals("B")) {
			operate("+-+", "RNR");
			if(record_on == true) {
				printAL();
			}
			q3();
                }else if(tape1.get(tape1_pos).equals("+") && tape2.get(tape2_pos).equals("+") && tape3.get(tape3_pos).equals("B")) {
			operate("++B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q4();
                }else if(tape1.get(tape1_pos).equals("-") && tape2.get(tape2_pos).equals("-") && tape3.get(tape3_pos).equals("B")) {
			operate("--B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q5();
                }else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("BBB", "LRN");
			if(record_on == true) {
				printAL();
			}
			q8();
		}else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("-") && tape3.get(tape3_pos).equals("B")) {
			operate("B-B", "NNN");
			if(record_on == true) {
				printAL();
			}
			q9();
		}else if(tape1.get(tape1_pos).equals("1") && tape2.get(tape2_pos).equals("+") && tape3.get(tape3_pos).equals("B")) {
			operate("B-B", "NNN");
			if(record_on == true) {
				printAL();
			}
			q9();
		}
            
               
	}
	
	static void q3() {
		if(record_on == true) {
			System.out.println("q3");
		}
		
		if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("+")) {
			operate("0+0", "RNR");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("-")) {
			operate("0-0", "RNR");
			if(record_on == true) {
				printAL();
			}
			q3();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("+")) {
			operate("B+B", "NRN");
			if(record_on == true) {
				printAL();
			}
			q7();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("-")) {
			operate("B-B", "NRN");
			if(record_on == true) {
				printAL();
			}
			q7();
		}
	}
	
	static void q4() {
		if(record_on == true) {
			System.out.println("q4");
		}
		
		if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("00B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q4();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("B0-", "NNR");
			if(record_on == true) {
				printAL();
			}
			q6();
		}else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("0B+", "NNR");
			if(record_on == true) {
				printAL();
			}
			q6();
		}
	}
	
	static void q5() {
		if(record_on == true) {
			System.out.println("q5");
		}
		
		if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("00B", "RRN");
			if(record_on == true) {
				printAL();
			}
			q5();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("B0+", "NNR");
			if(record_on == true) {
				printAL();
			}
			q6();
		}else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("0B-", "NNR");
			if(record_on == true) {
				printAL();
			}
			q6();
		}
	}
	
	static void q6() {
		if(record_on == true) {
			System.out.println("q6");
		}
		
		if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("0B0", "RNR");
			if(record_on == true) {
				printAL();
			}
			q6();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("B00", "NRR");
			if(record_on == true) {
				printAL();
			}
			q6();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("BBB", "NNN");
			if(record_on == true) {
				printAL();
			}
			qFinal();
		}

	}
	
        static void q7() {
		if(record_on == true) {
			System.out.println("q7");
		}
		
		if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("B00", "NRR");
			if(record_on == true) {
				printAL();
			}
			q7();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("BBB", "NNN");
			if(record_on == true) {
				printAL();
			}
			qFinal();
		}

	}
        
        static void q8() {
		if(record_on == true) {
			System.out.println("q7");
		}
		
		if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("0BB", "LNN");
			if(record_on == true) {
				printAL();
			}
			q8();
		}else if(tape1.get(tape1_pos).equals("+") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("+BB", "NNN");
			if(record_on == true) {
				printAL();
			}
			q10();
		}else if(tape1.get(tape1_pos).equals("-") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("-BB", "NNN");
			if(record_on == true) {
				printAL();
			}
			q10();
		}

	}
        static void q9() {
		if(record_on == true) {
			System.out.println("q7");
		}
		
		if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("+") && tape3.get(tape3_pos).equals("B")) {
			operate("B++", "NRR");
			if(record_on == true) {
				printAL();
			}
			q9();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("-") && tape3.get(tape3_pos).equals("B")) {
			operate("B-+", "NRR");
			if(record_on == true) {
				printAL();
			}
			q9();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("0") && tape3.get(tape3_pos).equals("B")) {
			operate("B00", "NRR");
			if(record_on == true) {
				printAL();
			}
			q9();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("BBB", "NNN");
			if(record_on == true) {
				printAL();
			}
			qFinal();
		}

	}
        static void q10() {
		if(record_on == true) {
			System.out.println("q7");
		}
		
		if(tape1.get(tape1_pos).equals("+") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("+B+", "RNR");
			if(record_on == true) {
				printAL();
			}
			q10();
		}else if(tape1.get(tape1_pos).equals("-") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("-B-", "RNR");
			if(record_on == true) {
				printAL();
			}
			q10();
		}else if(tape1.get(tape1_pos).equals("0") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("0B0", "RNR");
			if(record_on == true) {
				printAL();
			}
			q10();
		}else if(tape1.get(tape1_pos).equals("B") && tape2.get(tape2_pos).equals("B") && tape3.get(tape3_pos).equals("B")) {
			operate("BBB", "NNN");
			if(record_on == true) {
				printAL();
			}
			qFinal();
		}

	}
        
	static void qFinal() {
		int pengkali = 0;
		int hasil = 0;
		
		System.out.println("State akhir:");
		printAL();
		boolean tanda_sudah = false;
		for(int i=0;i<tape3.size();i++) {
			if(tape3.get(i).equals("+") && tanda_sudah == false) {
				pengkali = 1;
				tanda_sudah = true;
			}else if(tape3.get(i).equals("-") && tanda_sudah == false) {
				pengkali = -1;
				tanda_sudah = true;
			}else if(tape3.get(i).equals("0") && tanda_sudah == true) {
				hasil++;
			}
		}
		
		System.out.println("Jawaban Akhir = "+(pengkali*hasil));
	}
	
	public static void main(String[] argrs) {
		tape1_pos = tape2_pos = tape3_pos = 0;
		
		record_on = true;
		
		int input_1 = 10;
		int input_2 = 5;
		
		System.out.println("Penjumlahan "+input_1+" dengan "+input_2+"\n");
		
		System.out.println("State Awal :");
		input_to_tape_1(input_1,input_2);
		filltape2tape3();
		printAL();
		
		q0();
				
	}
}

