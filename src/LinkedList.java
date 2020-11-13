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
                head.setNext(tail);
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

    public int indexOf(T element){
        if (element == null){
            return -1;
        }
        Node<T> ptr = head.getNext();
        int counter = 0;
        while (ptr.getData() != element){
            ptr = ptr.getNext();
            counter = counter + 1;
            if (counter == this.size() - 1 && ptr.getData() != element){
                return -1;
            }
        }

        return counter;
    }

    public boolean isEmpty(){
        if (tail == null){
            return true;
        }
        return false;
    }

    public int size(){

        if (tail == null){
            return 0;
        }
        else {
            int counter = 1;
            Node ptr = head.getNext();
            while (ptr.getNext() != null) {
                counter = counter + 1;
                ptr = ptr.getNext();
            }
            return counter;
        }

    }//size

    public T remove(int index){
        if (index >= this.size()){
            return null;
        }
        Node <T> ptr = head.getNext();
        Node <T> trl = head;
        int counter = 0;
        while (counter != index){
            ptr = ptr.getNext();
            trl = trl.getNext();
            counter = counter + 1;
        }
        trl.setNext(ptr.getNext());
        return ptr.getData();
    }

    public void sort(){
        T tempData;
        Node <T> trl = head.getNext();
        Node <T> ptr = trl.getNext();
        while(ptr != null){
            trl = head.getNext();
            while (trl != ptr){
                if (ptr.getData().compareTo(trl.getData()) < 0){
                    tempData = ptr.getData();
                    ptr.setData(trl.getData());
                    trl.setData(tempData);
                }//check swap
                else{
                 trl = trl.getNext();
                }
            }//inner loop
            ptr = ptr.getNext();
        }//outer loop
        isSorted = true;
    }//sort

    public void greaterThan(T element){
        if (isSorted == true) {
            Node <T> ptr = head.getNext();
            while (ptr.getData() != element){
                ptr = ptr.getNext();
            }
            head.setNext(ptr.getNext());
        }//sorted
        else{
            Node<T> ptr = head.getNext();
            Node<T> trl = head;
            while (ptr != null){
                if (ptr.getData().compareTo(element) < 0 || ptr.getData().compareTo(element) == 0){
                    ptr = ptr.getNext();
                    trl.setNext(ptr);
                }
                else{
                    ptr = ptr.getNext();
                    trl = trl.getNext();
                }
            }
        }//not sorted
    }//greaterThan

    public void lessThan(T element){
        if (isSorted == true){
            Node <T> ptr = head.getNext();
            while (ptr.getData() != element){
                ptr = ptr.getNext();
            }
            ptr.setNext(null);
        }//sorted
        else {
            Node <T> ptr = head.getNext();
            Node<T> trl = head;
            while (ptr != null){
                if (ptr.getData().compareTo(element) < 0){
                    ptr = ptr.getNext();
                    trl = trl.getNext();
                }
                else{
                    ptr = ptr.getNext();
                    trl.setNext(ptr);
                }
            }
        }//not sorted
    }//lessThan

    public void equalTo(T element){
        Node <T> ptr = head.getNext();
        Node <T> trl = head;
        while (ptr != null){
            if (ptr.getData().equals(element)){
                ptr = ptr.getNext();
                trl = trl.getNext();
            }
            else{
                ptr = ptr.getNext();
                trl.setNext(ptr);
            }
        }
    }//equalTo

    public String toString(){
        String listStr = "";
        Node <T> ptr = head.getNext();
        while (ptr != null){
            listStr = listStr + ptr.getData() + "\n";
            ptr = ptr.getNext();
        }
        return listStr;
    }




    public static void main(String[]args){

        String breaker = "----------------------------------";

        LinkedList<String> testList = new LinkedList<String>();

        testList.add("Hello World");
        testList.add("Dog");
        testList.add("cat");
        testList.add("poop");
        testList.add("zoom");
        testList.add("Zoom");
        System.out.println(testList.size());
        System.out.println(testList.toString());
        System.out.println(breaker);

        System.out.println(testList.indexOf(null));

    }

}//class LinkedList