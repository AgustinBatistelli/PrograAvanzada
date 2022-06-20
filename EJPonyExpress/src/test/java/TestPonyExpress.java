import static org.junit.Assert.*;

import org.junit.Test;



public class TestPonyExpress {	
	
	@Test
	public void test1() {	
		assertEquals(1, Jinetes.jinetes(new int[] {18, 15}));	
	}
	
	@Test
	public void test2() {
		assertEquals(2, Jinetes.jinetes(new int[] {43, 23, 40, 13}));
	}
	
	@Test
	public void test3() {
		assertEquals(3, Jinetes.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));	
	}
	
	@Test
	public void test4() {
		assertEquals(3, Jinetes.jinetes(new int[] {51, 51, 51}));		
	}
	
	@Test
	public void test5() {	
		assertEquals(4, Jinetes.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
	}


}
