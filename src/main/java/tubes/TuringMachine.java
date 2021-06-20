package tubes;

import java.util.ArrayList;

public class TuringMachine {
	
	public int totalSteps;
	private ArrayList<String> rec_tape_1, rec_tape_2, rec_tape_3;
	private ArrayList<Integer> rec_head_1, rec_head_2, rec_head_3;
	
	private ArrayList<String[]> rec_states, rec_symbol;
	private ArrayList<String> rec_direction;
	
	TuringMachine() {
		totalSteps = 0;
		rec_tape_1 = new ArrayList<String>();
		rec_tape_2 = new ArrayList<String>();
		rec_tape_3 = new ArrayList<String>();
		rec_head_1 = new ArrayList<Integer>();
		rec_head_2 = new ArrayList<Integer>();
		rec_head_3 = new ArrayList<Integer>();
		rec_states = new ArrayList<String[]>();
		rec_symbol = new ArrayList<String[]>();
		rec_direction = new ArrayList<String>();
	}
	
	public void addRecord(String tape, int head) {
		totalSteps++;
		rec_tape_1.add(tape);
		rec_head_1.add(head);
	}
	
	public void addRecord(String tape_1, String tape_2, String tape_3, int head_1, int head_2, int head_3) {
		totalSteps++;
		rec_tape_1.add(tape_1);
		rec_tape_2.add(tape_2);
		rec_tape_3.add(tape_3);
		rec_head_1.add(head_1);
		rec_head_2.add(head_2);
		rec_head_3.add(head_3);
	}
	
	public void addTransition(String[] states, String[] symbol, String direction) {
		rec_states.add(states);
		rec_symbol.add(symbol);
		rec_direction.add(direction);
	}
	
	public String getTape1Record(int stepAt) {
		return rec_tape_1.get(stepAt);
	}
	
	public String getTape2Record(int stepAt) {
		return rec_tape_2.get(stepAt);
	}
	
	public String getTape3Record(int stepAt) {
		return rec_tape_3.get(stepAt);
	}
	
	public int getHead1Record(int stepAt) {
		return rec_head_1.get(stepAt);
	}
	
	public String getStateBefore(int stepAt) {
		return rec_states.get(stepAt)[0];
	}
	
	public String getStateAfter(int stepAt) {
		return rec_states.get(stepAt)[1];
	}

	public String getSymbolBefore(int stepAt) {
		return rec_symbol.get(stepAt)[0];
	}
	
	public String getSymbolAfter(int stepAt) {
		return rec_symbol.get(stepAt)[1];
	}
	
	public String getNextSymbol(int stepAt) {
		char symbol_1 = getTape1Record(stepAt).charAt(getHead1Record(stepAt));
		char symbol_2 = getTape2Record(stepAt).charAt(getHead2Record(stepAt));
		char symbol_3 = getTape3Record(stepAt).charAt(getHead3Record(stepAt));
		String next_symbol = String.valueOf(symbol_1) + String.valueOf(symbol_2) + String.valueOf(symbol_3); 
		return next_symbol;
	}
	
	public String getNextSymbolTape1(int stepAt) {
		char symbol_1 = getTape1Record(stepAt).charAt(getHead1Record(stepAt));
		String next_symbol = String.valueOf(symbol_1); 
		return next_symbol;
	}
	
	public int getHead2Record(int stepAt) {
		return rec_head_2.get(stepAt);
	}
	
	public int getHead3Record(int stepAt) {
		return rec_head_3.get(stepAt);
	}
	
	public int getResult() {
		int count = 0;
		int lastIndex = rec_tape_3.size();
		String lastRecord = rec_tape_3.get(lastIndex - 1);
		for (String i : lastRecord.split("")){
            if (i.equals("0")) {
                count++;
            }
        }
		return count;
	}
	
	public int getResultTape1() {
		int count = 0;
		int lastIndex = rec_tape_1.size();
		String lastRecord = rec_tape_1.get(lastIndex - 1);
		for (String i : lastRecord.split("")){
            if (i.equals("Y") ) {
                count++;
            }
        }
		return count;
	}
	
	public int getResultPlusMin() {
		int pengkali = 0;
		int hasil = 0;
		boolean tanda_sudah = false;
		int lastIndex = rec_tape_3.size();
		String lastRecord = rec_tape_3.get(lastIndex - 1);
		
		for(String i : lastRecord.split("")) {
			if(i.equals("0") && tanda_sudah == false) {
				pengkali = 1;
				tanda_sudah = true;
			} else if(i.equals("1") && tanda_sudah == false) {
				pengkali = -1;
				tanda_sudah = true;
			}else if(i.equals("0") && tanda_sudah == true) {
				hasil++;
			}
		}
		
		return pengkali*hasil;
	}
	
	public int getResultAdd() {
		int pengkali = 0;
		int hasil = 0;
		boolean tanda_sudah = false;
		int lastIndex = rec_tape_3.size();
		String lastRecord = rec_tape_3.get(lastIndex - 1);
		
		for(String i : lastRecord.split("")) {
			if(i.equals("+") && tanda_sudah == false) {
				pengkali = 1;
				tanda_sudah = true;
			} else if(i.equals("-") && tanda_sudah == false) {
				pengkali = -1;
				tanda_sudah = true;
			}else if(i.equals("0") && tanda_sudah == true) {
				hasil++;
			}
		}
		
		return pengkali*hasil;
	}
	
	public int getResultPow() {
		int hasil = 0;

		int lastIndex = rec_tape_1.size();
		String lastRecord = rec_tape_1.get(lastIndex - 1);
		
		for(String i : lastRecord.split("")) {
			if(i.equals("0")) {
				hasil++;
			}
		}
		
		return hasil;
	}
	
	public void readMachine() {
		
	}
}
