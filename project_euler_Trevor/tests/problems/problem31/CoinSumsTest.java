package problems.problem31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problems.problem31.CoinSums;
import problems.problem31.CoinSums.ArrayWrapper;
import java.util.*;

class CoinSumsTest{

	
	void testArrayWrapperEquals(){
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {1, 2, 3, 4, 4};
		ArrayWrapper wrapper1 = new ArrayWrapper(array1);
		ArrayWrapper wrapper2 = new ArrayWrapper(array2);
		assertFalse(wrapper1.equals(wrapper2));
		assertTrue(wrapper1.equals(new ArrayWrapper(wrapper1)));
	}
	
	@Test
	void testArrayWrapperSet(){
		ArrayWrapper wrapper = new ArrayWrapper(new int[]{1, 2, 3, 4, 5});
		Set<ArrayWrapper> set = new HashSet<ArrayWrapper>();
		set.add(wrapper);
		assertFalse(set.add(new ArrayWrapper(wrapper)));
	}

}
