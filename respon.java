class Node {
    String nama;
    Node next;
    Node prev;

    public Node(String nama){
        this.nama = nama;
        this.next = null;
        this.prev = null;
    }   
}

class LinkList {
    Node head;
    Node tail;

    public LinkList() {
        head = null;
        tail = null;
    }

    public void addFirst(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head; 
            head.prev = newNode; 
            head = newNode; 
        }
    }

    public void delete(String name){
        Node temp = head;
        while (temp != null) {
            if (temp.nama.equals(name)) {
                if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                break;
            }
            temp = temp.next;
        }
    }

    public void addLast(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode; 
        } else {
            tail.next = newNode; 
            newNode.prev = tail; 
            tail = newNode;
        }
    }

    public void printReverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev; 
    }

    public void display() {
        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.nama);
            temp = temp.next;
            index++; 
        }
    }

    public void tukar(String nama1, String nama2) {
        Node prev1 = null, prev2 = null;
        Node node1 = head, node2 = head;

        while (node1 != null && node1.nama != nama1) {
            prev1 = node1;
            node1 = node1.next;
        }

        while (node2 != null && node2.nama!= nama2) {
            prev2 = node2;
            node2 = node2.next;
        }

        if (prev1 != null) {
            prev1.next = node2;
        } else {
            head = node2;
        }

        if (prev2 != null) {
            prev2.next = node1;
        } else {
            head = node1;
        }

        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }
}

public class respon{
    public static void main(String[] args) {
        LinkList l = new LinkList();
        
        System.out.println("========================================");
        System.out.println("      Daftar Praktikan Kelompok 11      ");
        System.out.println("========================================");
        l.addLast("Nayla");
        l.addLast("Nini");
        l.addLast("Wira");
        l.addLast("Ananta");
        l.addLast("Salsa");
        l.addLast("Raja");
        l.addLast("Alfath");
        l.addLast("Nopal");
        l.display();

        System.out.println("========================================");
        System.out.println(" List Presensi Setelah Wira Tidak Hadir ");
        System.out.println("========================================");
        l.delete("Wira");
        l.display();

        System.out.println("========================================");
        System.out.println("  List Presensi Setelah Tengah Dibalik  ");
        System.out.println("========================================");
        l.tukar("Alfath", "Nini");
        l.tukar("Raja", "Ananta");
        l.display();
        
        System.out.println("========================================");
        System.out.println("      List Presensi Setelah Dibalik     ");
        System.out.println("========================================");
        l.printReverse();
        l.display();
    }
}