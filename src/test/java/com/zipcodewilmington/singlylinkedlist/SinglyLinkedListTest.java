package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < 5; i++) {
            Integer actual = linkedList.get(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void removeTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        linkedList.remove(4);
        linkedList.remove(3);
        for (int i = 0; i < 3; i++) {
            Integer actual = linkedList.get(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void containsTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        Assert.assertTrue(linkedList.contains(30));
        Assert.assertFalse(linkedList.contains(110));
    }

    @Test
    public void findTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < 100; i++) {
            Integer actual = linkedList.find(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void findTest2(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 10; i > 0; i--) {
            linkedList.add(i);
        }
        for (int i = 0; i < 10; i++) {
            Integer actual = linkedList.find(10 - i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void sizeTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        Integer size = 100;
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        Integer actual = linkedList.size();
        Assert.assertEquals(size, actual);
    }

    @Test
    public void copyTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        SinglyLinkedList<Integer> copy = linkedList.copy();
        for (int i = 0; i < 100; i++) {
            Integer actual = copy.get(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void sortTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 99; i >= 0; i--) {
            linkedList.add(i);
        }
        linkedList.sort();
        for (int i = 0; i < 100; i++) {
            Integer actual = linkedList.get(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void sortTest2(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 5; i >= 0; i--) {
            linkedList.add(i);
        }
        linkedList.sort();
        for (int i = 0; i < 6; i++) {
            Integer actual = linkedList.get(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void reverseTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 99; i >= 0; i--) {
            linkedList.add(i);
        }
        SinglyLinkedList reverse = linkedList.reverse();
        for (int i = 0; i < 100; i++) {
            Integer actual = reverse.find(i);
            Assert.assertEquals((Integer) i, actual);
        }
    }

    @Test
    public void sliceTest1(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        SinglyLinkedList<Integer> slice = linkedList.slice(10, 15);
        for (int i = 0; i < 5; i++) {
            Integer actual = slice.get(i);
            Assert.assertEquals((Integer) (i + 10), actual);
        }
    }
}
