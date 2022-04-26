package ponyExpress;

import org.junit.Assert;
import org.junit.Test;

public class testJinete {

	@Test 
	public void jinetes1() {
		
		Assert.assertEquals(1, Jinete.jinetes(new int[] {18, 15}));
	}

	@Test 
	public void jinetes2() {
		
	Assert.assertEquals(2, Jinete.jinetes(new int[] {43, 23, 40, 13}));
	}
	
	@Test 
	public void jinetes3() {
		
		Assert.assertEquals(3, Jinete.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
	}
	
	@Test 
	public void jinetes4() {
		
		Assert.assertEquals(3, Jinete.jinetes(new int[] {51, 51, 51}));
	}
	
	@Test 
	public void jinetes5() {
		
		Assert.assertEquals(4, Jinete.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
	}
	
	@Test 
	public void jinetes6() {
		
		Assert.assertEquals(2, Jinete.jinetes(new int[] {10,80,30}));
	}
	
	@Test 
	public void jinetes7() {
		
		Assert.assertEquals(3, Jinete.jinetes(new int[] {99, 10, 99}));
	}
	
	


}
