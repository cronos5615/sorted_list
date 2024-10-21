
/*
 *
 *  SortedList.java
 * test the code here with example_iterlist code.
 */
import java.util.Iterator;

public class SortedList<E extends Comparable<? super E>> extends List<E> {
    public void insert(E data) {
        head = insert(data, head);
    }

    private Node<E> insert(E data, Node<E> curr) {
        if(curr == null){
            Node<E> temp = new Node<E>(data);
            temp.next = curr;
            curr = temp;
        }
        else if (curr.next == null) {
            Node<E> temp = new Node<E>(data);
            curr.next = temp;
        }
        else if (curr.data.compareTo(data) < 0) {
            curr.next = insert(data, curr.next);
        } 
        else {
            Node<E> temp = new Node<E>(data);
            temp.next = curr;
            curr = temp;
        }

        return curr;

    }

    public void remove(E data) {
        head = remove(data, head);
    }

    private Node<E> remove(E data, Node<E> curr) {
        if(curr == null){
            return curr;
        }
        else if(curr.data.compareTo(data)==0){
            curr = curr.next;
            
        }
        else{
            curr.next = remove(data,curr.next);
        }
        return curr;
    }

    public E retrieve(int index) {
        if(index<0)
            return null;
        return retrieve(index,head,-1);
    }
    private E retrieve(int index,Node<E> curr,int curr_index) {
        curr_index++;
        if(curr == null){
            return null;
        }
        else if(curr_index==index){
            return curr.data;
        }
        else{
            return retrieve(index,curr.next,curr_index);
        }
        
    }
    public boolean search(E data) {
        return search(data,head);
    }
    private boolean search(E data, Node<E> curr) {
        if(curr == null){
            return false;
        }
        else if(curr.data == data){
            return true;
        }
        else{
            return search(data,curr.next);
        }
    }
    
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Node<E> curr = head;

            public boolean hasNext() {
                return (curr != null);
            }

            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }

        };
    }
}