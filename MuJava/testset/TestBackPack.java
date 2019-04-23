import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestBackPack {
	@Test
	public void testTakeOut() {
        int[][] expected = new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4}, 
				{0, 0, 0, 4, 5, 5, 5, 9, 9, 9, 9}, 
				{0, 0, 0, 4, 5, 6, 6, 9, 10, 11, 11}};
        int m = 10;
        int n = 3;
        int[] w = new int[]{3,4,5};
        int[] p = new int[]{4,5,6};
		assertArrayEquals(expected, BackPack.BackPack_Solution(m, n, w, p));
	}
}
