package luchadores_japoneses;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import torneo.Torneo;

public class LuchadoresJaponesesTest {

	@Test
	public void test() throws Exception {
		
		Torneo t = new Torneo();
				
		assertArrayEquals(new int[] {1, 2, 1, 6, 3, 3, 2, 5, 0, 0}, t.resolver());
	}

}