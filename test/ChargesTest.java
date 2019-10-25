
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChargesTest {
	
	long numOfDays = 0;
	double price = 00.00;
	double expectedChargeWithoutTax = 0.00, expectedTaxes = 0.00, expectedTotalCharges = 0.00;
	MockFields mock;

	@Before
	public void setUp() throws Exception {
		
		numOfDays = 4;
		price = 250.00;
		mock = getMock(new GetMockParameter(price, numOfDays));
		
		expectedTotalCharges =price * numOfDays;
		expectedTaxes = (price * numOfDays) * 0.1;
		expectedChargeWithoutTax = expectedTotalCharges - expectedTaxes;
	}

	@Test
	public void testCalcTotalCharges() {
		
		assertTrue(expectedTotalCharges==mock.totalCharges && expectedTaxes==mock.taxes && 
				expectedChargeWithoutTax==mock.chargeWithoutTax);	
	}
	
	@After
	public void tearDown() throws Exception {
		mock = null;
	}

	private MockFields getMock(GetMockParameter parameterObject) {
		
		MockFields mock = new MockFields();
		mock.totalCharges = parameterObject.price * parameterObject.numOfDays;
		mock.taxes = (parameterObject.price * parameterObject.numOfDays) * 0.1;
		mock.chargeWithoutTax = mock.totalCharges - mock.taxes;
		
		return mock;
	}
	
	class MockFields {
		public double totalCharges, taxes, chargeWithoutTax;
		}
}
