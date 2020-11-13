public class LinkedList <T extends Comparable<T>> implements List<T>{

    private Node <T> head;
    private Node <T> tail;
    private boolean isSorted;

    public LinkedList(){
        head = new Node <T>(null);
        head.setNext(tail);
        tail = null;
        isSorted = true;
    }//constructor

    public boolean add(T element){
        if(element == null){
            return false;
        }//if element is null
        else{
            if(tail == null){
                tail = new Node <T> (element);
                return true;
            }//if list is empty
            else{
                Node <T> addNode = new Node <T> (element);
                tail.setNext(addNode);
                tail = addNode;
                isSorted = false;
                return true;
            }//adding to end of list
        }

    }//add to end of list


    public boolean add(int index, T element){
        if(element == null || index < 0 || index >= this.size()){
            return false;
        }//index checking
        else{
            if(index == 0){
                Node <T> addedNode = new Node <T>(element);
                Node <T> ptr = head.getNext();
                head.setNext(addedNode);
                addedNode.setNext(ptr);
                isSorted = false;
                return true;
            }//adding to very front of list
            else{
                Node <T> ptr = head.getNext();
                Node <T> trl = head;
                int counter = 0;
                while(counter != index){
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
        tail = null;
        head.setNext(tail);
    }


    public T get(int index){
        if (index >= this.size()){
            return null;
        }//index out of range
        else{
            int counter = 0;
            Node <T> ptr = head.getNext();
            while (counter != index){
                ptr = ptr.getNext();
                counter = counter + 1;
            }
            return ptr.getData();
        }
    }

    //TODO finish method
    //public int indexOf(T element){

    //}

    public boolean isEmpty(){
        if (tail == null){
            return true;
        }
        return false;
    }


    public int size(){
        int counter = 0;
        if (tail == null){
            return counter;
        }
        else {
            Node ptr = head.getNext();
            while (ptr.getNext() != null) {
                counter = counter + 1;
                ptr = ptr.getNext();
            }
            return counter;
        }

    }//size

    public T remove(int index){
        Node <T> ptr = head.getNext();
        Node <T> trl = head;
        int counter = 0;
        while (counter != index - 1){
            ptr = ptr.getNext();
            trl = trl.getNext();
            counter = counter + 1;
        }
        trl.setNext(ptr.getNext());
        return ptr.getData();
    }

    public void sort(){
        int i,j;
        Node <T> ptr;
        Node <T> temp;
        for (i = 1; i < this.size(); i++){

        }



    }




    public static void main(String[]args){
        System.out.println("Hello World");
    }

}//class LinkedList