package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E> {
    // pointer to first node
    SLLNode first;
    // pointer to last node
    SLLNode last;

    public SinglyLinkedList() {
        first = null;
        last = null;
    }

    public void add(E element){
        if (first == null){
            first = new SLLNode(null, element, null);
            last = first;
        }
        else {
            SLLNode elementNode = new SLLNode(last, element, null);
            last.setNext(elementNode);
            last = elementNode;
        }
    }

    public void remove(int index){
        SLLNode node = getNodeOfIndex(index);
        if (node == first && node == last){
            first = null;
            last = null;
        }
        else if(node == first){
            node.getNext().setPrevious(null);
            first = node.getNext();
        }
        else if(node == last){
            node.getPrevious().setNext(null);
            last = node.getPrevious();
        }
        else {
            SLLNode before = node.getPrevious();
            SLLNode after = node.getNext();
            before.setNext(after);
            after.setPrevious(before);
        }
    }

    public boolean contains(E element){
        if (first != null){
            SLLNode currentNode = first;
            boolean flag = false;
            while (currentNode != null){
                if(element.equals(currentNode.getValue())){
                    flag = true;
                    break;
                }
                currentNode = currentNode.getNext();
            }
            return flag;
        }
        else {
            return false;
        }
    }

    public int find(E element){
        if (first != null){
            SLLNode currentNode = first;
            boolean flag = false;
            int index = 0;
            while (currentNode != null){
                if(element.equals(currentNode.getValue())){
                    flag = true;
                    break;
                }
                index++;
                currentNode = currentNode.getNext();
            }
            if (flag){
                return index;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    public int size(){
        int index = 0;
        SLLNode currentNode = first;
        while (currentNode != null){
            index++;
            currentNode = currentNode.getNext();
        }
        return index;
    }

    public E get(int index){
        return getNodeOfIndex(index).getValue();
    }

    public SinglyLinkedList<E> copy(){
        SinglyLinkedList copy = new SinglyLinkedList();
        SLLNode currentNode = first;
        while(currentNode != null){
            copy.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return copy;
    }

    public void sort(){
        for (int i = 0; i < this.size(); i++) {
            for (int j = 1; j < this.size() - i; j++) {
                Comparable first = (Comparable) getNodeOfIndex(j-1).getValue();
                Comparable second = (Comparable) getNodeOfIndex(j).getValue();
                if(first.compareTo(second) > 0){
                    swap(getNodeOfIndex(j-1), getNodeOfIndex(j));
                }
            }
        }
    }

    private void swap(SLLNode first, SLLNode second) {
        // Sets the next of first
        first.setNext(second.getNext());
        if (first.getNext() != null) {
            first.getNext().setPrevious(first);
        }
        else {
            this.last = first;
        }
        second.setPrevious(first.getPrevious());
        if (second.getPrevious() != null) {
            second.getPrevious().setNext(second);
        }
        else {
            this.first = second;
        }
        first.setPrevious(second);
        second.setNext(first);
    }

    public SinglyLinkedList<E> reverse(){
        SinglyLinkedList reverse = new SinglyLinkedList();
        SLLNode current = last;
        while (current != null){
            reverse.add(current.getValue());
            current = current.getPrevious();
        }
        return reverse;
    }

    public SinglyLinkedList<E> slice(int start, int end){
        SLLNode begin = getNodeOfIndex(start);
        int numberToAdd = end - start;
        SinglyLinkedList<E> sliced = new SinglyLinkedList<E>();
        for (int i = 0; i < numberToAdd; i++) {
            sliced.add(begin.getValue());
            begin = begin.getNext();
        }
        return sliced;
    }

    private SLLNode getNodeOfIndex(int index) {
        try {
            SLLNode currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public class SLLNode {
        private SLLNode previous;
        private E value;
        private SLLNode next;

        public SLLNode(SLLNode previous, E value, SLLNode next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

        public SLLNode getPrevious() {
            return previous;
        }

        public void setPrevious(SLLNode previous) {
            this.previous = previous;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public SLLNode getNext() {
            return next;
        }

        public void setNext(SLLNode next) {
            this.next = next;
        }
    }
}
