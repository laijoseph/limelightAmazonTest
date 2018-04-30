package tests.amazonTest;

import static org.junit.Assert.*;

import org.junit.Test;

import results.Result;

public class AmazonTestTest {

	@Test
	public void testSortPrice() {
		Result one = new Result("", 8.00, 5);
		Result two = new Result("", 234.43, 5);
		Result three = new Result("", 2.23, 5);
		Result four = new Result("", 98.43, 5);
		Result five = new Result("", 82.75, 5);
		Result six = new Result("", 53.46, 5);
		Result seven = new Result("", 76.99, 5);
		Result eight = new Result("", 12.00, 5);
		Result nine = new Result("", 21.10, 5);
		Result ten = new Result("", 18.23, 5);
		Result eleven = new Result("", 75.38, 5);
		Result twelve = new Result("", 99.99, 5);
		Result thirteen = new Result("", 1234.43, 5);
		Result fourteen = new Result("", 867.34, 5);
		
		Result[] testArr = new Result[] {one, two, three, four, five, six, seven, eight, nine,
				ten, eleven, twelve, thirteen, fourteen};
		
		AmazonTest.sortPrice(testArr);
		for (int i = 1; i < testArr.length;i++){
			assertTrue(testArr[i].getPrice() > testArr[i-1].getPrice());
		}
	}

}
