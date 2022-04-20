package ejercicio02;

import org.junit.Assert;
import org.junit.Test;

import jinete.Jinete;

public class JineteTest {

	@Test
	public void test() {
		Assert.assertEquals(1, Jinete.jinetes(new int[] {18, 15}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, Jinete.jinetes(new int[] {43, 23, 40, 13}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(3, Jinete.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(3, Jinete.jinetes(new int[] {51, 51, 51}));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(4, Jinete.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
	}

}
