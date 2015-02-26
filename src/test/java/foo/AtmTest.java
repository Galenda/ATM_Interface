package foo;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class AtmTest {
	private AtmInterface testAtm = new Atm();
		
	@Test
    public void testGetBalance(){    	   	
    	assertEquals(3000, (int) testAtm.getBalance());
    	testAtm.getCash(200);
    	assertEquals(2800, (int) testAtm.getBalance());
    }
    
    @Test    
    public void testGetQuantity(){    	
    	HashMap <Integer, Integer> expectedQuantities = new HashMap <Integer, Integer>();
    	expectedQuantities.put(500, 2);
    	expectedQuantities.put(200, 4);
    	expectedQuantities.put(100, 7);
    	expectedQuantities.put(50, 10);    	
    	assertEquals(expectedQuantities,  testAtm.getQuantity());
    }

      
    @Test (expected = UnsupportedOperationException.class)
    public void testDepositNotesWrongNoteException(){
    	testAtm.depositNotes(300, 1);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testDepositNotesWrongAmountException(){
    	testAtm.depositNotes(500, 10);
    }
    
    @Test (expected = UnsupportedOperationException.class)
    public void testDepositNotesOutOfRangeException(){    	
    	testAtm.getCash(100);     	
    	testAtm.depositNotes(100, -1);
    }
    
    @Test
    public void testDepositNotes(){
    	testAtm.getCash(1000);
    	testAtm.depositNotes(500, 1);    	
    	assertEquals(1, (int) testAtm.getQuantity().get(500));    	
    }
        
    @Test
    public void testGetCaschFailure(){
    	assertEquals(-1, (int) testAtm.getCash(3500));
    	assertEquals(-1, (int) testAtm.getCash(320));
    	testAtm.getCash(450);
    	testAtm.getCash(450);
    	testAtm.getCash(450);
    	testAtm.getCash(450);
    	
    	assertEquals(-1, (int) testAtm.getCash(850));
    	assertEquals(-1, (int) testAtm.getCash(-150));
    }
    
    @Test
    public void testGetCachSuccess(){
    	assertEquals(600, (int) testAtm.getCash(600));
    	assertEquals(850, (int) testAtm.getCash(850));
    }

}
