package foo;

import java.util.HashMap;

public interface AtmInterface {
	public void depositNotes(int value, int amount);
	public int getCach(int value);
	public int getBalance();
	public HashMap<Integer, Integer> getQuantity();
}
