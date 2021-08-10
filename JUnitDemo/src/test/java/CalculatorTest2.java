import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest2 {
	@Test
	public void addNumberTest() {
		// Arrange
		Calculator cal = new Calculator();
		
		// Act
		int actualResult = cal.addNumber(10, 20);
		
		// Assert
		int expectedResult = 30;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
