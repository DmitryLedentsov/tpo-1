package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpo.lab1.algorithm.LeftListHeap;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HeapTest {
    LeftListHeap<Integer> heap;
    List<Integer> test;
    @BeforeEach
    void init() {
        heap = new LeftListHeap<>();
        test = new LinkedList<>();
        fillWithValues();
    }


    void fillWithValues(){
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(4);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(5);
        test.add(4);
    }
    
    
    void assertCollectionsEquals(){
        Collections.sort(test);
        List<Integer> result = heap.getList();
        Collections.sort(result);
        assertIterableEquals(result,test);
    }

    @Test
    void checkInsert() {
        fillWithValues();
        assertCollectionsEquals();
    }

    @Test
    void removeSmallest() {
        test.remove(Collections.min(test));
        heap.deleteMin();
        assertCollectionsEquals();
    }

    @Test
    void clear(){

        test.clear();
        heap.makeEmpty();
        assertCollectionsEquals();
    }

    
}
