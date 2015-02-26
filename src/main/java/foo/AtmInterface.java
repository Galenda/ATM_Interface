package foo;

import java.util.HashMap;

public interface AtmInterface {
	/**
	 * 
	 * @param value
	 *            is denomination of banknote
	 * @param amount
	 *            is how much banknotes needs to deposit
	 * 
	 * @throws UnsupportedOperationException
	 */
	public void depositNotes(int value, int amount)
			throws UnsupportedOperationException;

	/**
	 * This method tries to take a cash with minimum of banknotes
	 * 
	 * @param value
	 *            is amount if cash you want to get
	 * @return <b>value</b> - if successful or <b>-1</b> if not
	 */
	public int getCash(int value);

	/**
	 * 
	 * @return amount of cash in ATM
	 */
	public int getBalance();

	/**
	 * 
	 * @return HashMap with pairs (denomination, amount) of each banknotes in
	 *         ATM
	 */
	public HashMap<Integer, Integer> getQuantity();
}
