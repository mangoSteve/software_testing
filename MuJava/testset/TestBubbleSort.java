import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestBubbleSort {
	@Test
	public void test() {
		int[] expected = new int[]{1,2,2,2,2,5,6};
		assertArrayEquals(expected, BubbleSort.BubbleSort(new int[]{1,6,2,2,2,2,5}));
	}
}
