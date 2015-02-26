package foo;

public class Note implements Comparable<Note> {
	private int amount;
	private int maxAmount;
	private int value;

	public Note(int value, int amount, int maxAmount){
		this.value = value;
		this.amount = amount;
		this.maxAmount = maxAmount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public int compareTo(Note compareNote) {	
	       int compareValue=((Note)compareNote).getValue();
	        return compareValue-this.value;		
	}
}
