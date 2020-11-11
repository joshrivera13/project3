public class LinkedList <T extends Comparable<T>> implements List<T>{

    private Node head;
    private Node tail;
    private boolean isSorted;

    public LinkedList(){
        head = null;
        tail = null;
        isSorted = true;
    }//constructor

    public boolean add(T element){
        if(element == null){
            return false;
        }//if element is null
        else{
            if(head == null){
                head = new Node <T> (element);

            }//if list is empty
        }
    }//add to end of list


    public boolean add(int index, T element){
        if(element == null || index < 0 || index >= this.size()){
            return false;
        }//index checking
        else{
            if(index == 0){
                Node <T> addedNode = new Node <T>(element);
                addedNode.setNext(head);
                head = addedNode;
                isSorted = false;
                return true;
            }//adding to very front of list
            else{
                Node ptr = head.getNext();
                Node trl = head;
                int counter = 0;
                while(counter != (index - 1)){
                    ptr = ptr.getNext();
                    trl = trl.getNext();
                    counter = counter + 1;
                }
                Node <T> addedNode = new Node <T>(element);
                trl.setNext(addedNode);
                addedNode.setNext(ptr);
                isSorted = false;
                return true;
            }//adding after front
        }
    }//add to specified index

    public void clear(){
        this = null;
    }


    public int size(){
        int counter = 0;
        Node ptr = head.getNext();
        while(ptr.getNext() != null){
            counter = counter + 1;
            ptr = ptr.getNext();
        }
        return counter;
    }//size





}//class LinkedList