package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpo.lab1.algorithm.LeftListHeap;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

public class HeapTest {
    LeftListHeap<Integer> heap;
    List<Integer> test;
    @BeforeEach
    void init() {
        heap = new LeftListHeap<>();
        test = new LinkedList<>();
    }


    void fillWithValues(){
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        test.add(1);
        test.add(2);
        test.add(3);
    }
    @Test
    public void checkInsert() {
        fillWithValues();
        assertIterableEquals(heap.getList(),test);
    }
    
    /*@Test
    public void checkSortedValues() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        radixSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void checkReversedValues() {
        int[] input = {7, 6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        radixSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void checkEqualsValues() {
        int[] input = {0, 0, 0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        radixSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void checkEmpty() {
        int[] input = {};
        radixSort.sort(input);
        assertArrayEquals(new int[]{}, input);
    }

    @Test
    void checkNull() {
        assertThrows(NullPointerException.class, () -> radixSort.sort(null));
    }

    @Test
    void checkDifferentRanksValues() {
        int[] input = {100001, 10002, 1003, 104, 6, 1000000, 15};
        int[] expected = {6, 15, 104, 1003, 10002, 100001, 1000000};
        radixSort.sort(input);
        assertArrayEquals(expected, input);
    }*/
}
