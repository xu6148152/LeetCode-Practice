package com.binea.www.leetcodepractice;

import com.binea.www.leetcodepractice.algorithm.TwoSum;
import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTest {

    @Test public void testTwoSum() {
        int[] numbers = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        final int[] ints = twoSum.twoSum(numbers, 13);
        for(int i = 0;i<ints.length;i++){
            System.out.print(ints[i] + " ");
        }
    }
}