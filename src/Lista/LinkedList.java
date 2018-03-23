package Lista;

public class LinkedList<AnyType> {
    private Node<AnyType> head;
    private int size;

    public LinkedList(){
        head = null;
    }

    public void add(AnyType item){
        if (head == null){
            head = new Node<>(item, null);
        }
        else{
            Node tmp = head;

            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node<>(item, null);
        }
        size++;
    }

    public void remove(int index) {
        Node tmp = head;
        int counter = 0;

        if (index >= size) throw new IndexOutOfBoundsException("Index out of range");

        if (head == null) throw new RuntimeException("Cannot delete");

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        counter++;

        while (tmp.next != null) {
            if (counter == index) {
                tmp.next = tmp.next.next;
                size--;
                return;
            }
            else{
                tmp = tmp.next;
                counter++;
            }
        }
    }

    public int length(){
        return size;
    }

    public AnyType get(int indice){
        Node<AnyType> tmp = head;
        int cont = 0;

        while (tmp != null){
            if (cont == indice) {
                return tmp.data;
            }

            cont++;
            tmp = tmp.next;
        }
        System.out.println("Error index out of range");
        return null;
    }


    public void printL(){
        Node tmp = head;
        System.out.print("[");
        while(tmp != null){
            if (tmp.next == null) System.out.print(tmp);
            else System.out.print(tmp + ", ");
            tmp = tmp.next;
        }
        System.out.print("]");
    }
}
