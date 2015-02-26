package foo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Atm implements AtmInterface {
	private ArrayList<Note> notes = new ArrayList<Note>();
	private ArrayList<Integer> presentNotes = new ArrayList<Integer>();
	private int balance = 0;
	
	public Atm() {
		notes.add(new Note(500, 2, 2));
		notes.add(new Note(200, 4, 4));
		notes.add(new Note(100, 7, 7));
		notes.add(new Note(50, 10, 10));
		presentNotes.add(500);
		presentNotes.add(200);
		presentNotes.add(100);
		presentNotes.add(50);
		balance = 3000;
		Collections.sort(notes);
		Collections.sort(presentNotes, Collections.reverseOrder());
	}

	private Boolean isNotePresent(Integer noteValue) {
		return presentNotes.contains(noteValue);
	}

	@Override
	public void depositNotes(int value, int amount)
			throws UnsupportedOperationException {
		if (!isNotePresent(value) || (amount < 0)) {
			throw new UnsupportedOperationException();
		} else {
			Note currentNote = notes.get(presentNotes.indexOf(value));
			if (currentNote.getAmount() + amount > currentNote.getMaxAmount()) {
				throw new UnsupportedOperationException();
			} else {
				currentNote.setAmount(currentNote.getAmount() + amount);
				balance += value * amount;
			}
		}
	}

	@Override
	public int getCash(int value) {
		if ((value > getBalance()) || (value % 50 > 0) || (value < 0)) {
			return -1;
		} else {
			Integer currentValue = value;
			ArrayList<Note> notesDuringTransaction = new ArrayList<Note>();
			for (Note currentNote : notes) {
				notesDuringTransaction.add(currentNote);
			}
			for (Note currentNote : notesDuringTransaction) {
				if (currentValue != 0) {
					Integer notesInValue = currentValue
							/ currentNote.getValue();
					if (notesInValue >= currentNote.getAmount()) {
						currentValue -= currentNote.getValue()
								* currentNote.getAmount();
						currentNote.setAmount(0);
					} else {
						currentNote.setAmount(currentNote.getAmount()
								- notesInValue);
						currentValue -= currentNote.getValue() * notesInValue;
					}
				}
			}
			if (currentValue == 0) {
				balance -= value;
				Collections.copy(notesDuringTransaction, notes);
				return value;
			} else {
				return -1;
			}
		}

	}

	@Override
	public int getBalance() {
		return balance;
	}

	@Override
	public HashMap<Integer, Integer> getQuantity() {
		HashMap<Integer, Integer> quantity = new HashMap<Integer, Integer>();
		for (Note currentNote : notes) {
			quantity.put(currentNote.getValue(), currentNote.getAmount());
		}
		return quantity;
	}
}
