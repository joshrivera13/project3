public class ArrayList <T extends Comparable<T>> implements List<T>{

    private T[] arr;
    private boolean isSorted;

    public ArrayList(){
        arr = (T[]) new Comparable[2];
        isSorted = true;
    }//constructor

    public boolean add(T element){
        if (element == null){
            return false;
        }
        else {
            if (arr[arr.length - 1] != null) {
                arr = addFull(arr);
                arr[this.size() + 1] = element;
                isSorted = false;
                return true;
            }//adding when full
            else {
                arr[this.size() + 1] = element;
                isSorted = false;
                return true;
            }//not full
        }
    }//add

    public boolean add(int index, T element){
        if (element == null || index >= arr.length){
            return false;
        }
        else{
            if (this.size() >= arr.length){
                arr = addFull(arr);
            }//if arr will become full
            for (int i = this.size() - 1; i >= index; i--){
                arr[i - 1] = arr[i];
            }
            arr[index] = element;
            isSorted = false;
            return true;
        }
    }//add

    public void clear(){
        arr = (T[]) new Comparable[2];
    }//clear

    public void sort(){
    int i ,j;
    T n;
    for (i = 1; i < this.size(); i++){
        n = arr[i];
        for(j = i -1; j >= 0 && n.compareTo(arr[j]) < 0; j--){
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = n;
    }
    }//sort

    public T get(int index){
        if (index > arr.length){
            return null;
        }
        else{
            return arr[index];
        }
    }//get

    public int indexOf(T element){
        int counter = -1;
        for (int i = 0; i < this.size(); i++){
            if (arr[i] == element){
                counter = i;
                break;
            }
        }
        return counter;
    }//indexOf

    public boolean isEmpty(){
        int counter = 0;
        for (int i = 0; i < this.size(); i++){
            if (arr[i] == null){
                counter += 1;
            }
        }
        if (counter == this.size()){
            return true;
        }
        else{return false;}
    }//isEmpty

    public T remove(int index){
        if (index >= arr.length){
            return null;
        }
        else{
            T data = arr[index];
            for (int i = index; i < this.size(); i++){
                if (i == this.size() - 1){
                    arr[i] = null;
                }
                else{
                    arr[i] = arr[i + 1];
                }
            }
            return data;
        }
    }//remove

    public void greaterThan(T element){
        if (isSorted == false) {
            for (int i = 0; i < this.size(); i++) {
                if (arr[i].compareTo(element) < 0){
                    if (i == arr.length - 1 && arr[i].compareTo(element) < 0){
                        arr[i] = null;
                        continue;
                    }
                    this.remove(i);
                }
            }
        }//not sorted
        else{
            for (int i = 0; i != this.indexOf(element); i++){
                this.remove(i);
            }
        }//sorted
    }//greaterThan

    public void lessThan(T element){
        if (isSorted == false){
            for(int i = 0; i < this.size(); i++){
                if (arr[i].compareTo(element) > 0){
                    if (i == arr.length - 1 && arr[i].compareTo(element) > 0){
                        arr[i] = null;
                        continue;
                    }
                    this.remove(i);
                }
            }
        }//not sorted
        else{
            for (int i = this.indexOf(element); i < this.size(); i++){
                if (i == arr.length - 1 && arr[i].compareTo(element) > 0){
                    arr[i] = null;
                    continue;
                }
                this.remove(i);
            }
        }//sorted
    }//lessThan

    public void equalTo(T element){
        for (int i = 0; i < this.size(); i++){
            if (arr[i].compareTo(element) != 0){
                if (i == arr.length - 1 && arr[i].compareTo(element) != 0){
                    arr[i] = null;
                    continue;
                }
                this.remove(i);
            }
        }
    }//equalTo

    public int size(){
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null){
                counter += 1;
            }
        }
        return counter;
    }//size

    public String toString(){
        String listStr = "";
        for (int i = 0; i < arr.length; i++){
            listStr = listStr + arr[i] + "\n";
        }
        return listStr;
    }

    public T[] addFull(T[] orig){
        T[] copy = (T[]) new Comparable[(orig.length * 2)];
        for (int i = 0; i < orig.length; i++){
            copy[i] = orig[i];
        }
        return copy;
    }

    public static void main(String[]args){
        String breaker = "----------------------------------";
        ArrayList <String> testList = new ArrayList<String>();
        testList.add("hello");
        testList.add("hi");
        testList.add("yo");
        testList.add("whats good");
        System.out.println(testList.toString());
        System.out.println(breaker);






    }

}//ArrayList