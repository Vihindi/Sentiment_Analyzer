class MyLinkedList {
    Node head;

    // Method to insert a new node with the given data at the end of the linked list.
    public static void insert(MyLinkedList list, String data)
    {
        Node new_node = new Node(data);
        new_node.next = null;

        if(list.head ==null){
            // If the list is empty, set the new node as the head.
            list.head=new_node;
        }
        else{
            // If the list is not empty, find the last node and append the new node to it.
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
    }
    // Method to get the number of nodes (size) in the linked list.
    public static int getSize(MyLinkedList list) {
        Node currNode = list.head;
        int count = 0;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }
    // Method to get the value at the specified index in the linked list.
    public static String getValueAtIndex(MyLinkedList list, int index) {
        Node currNode = list.head;
        int count = 0;
        while (currNode != null) {
            if (count == index) {
                return currNode.data;
            }
            count++;
            currNode = currNode.next;
        }
        return null; // Index out of bounds
    }


}
class Node {
    String data;
    Node next;

    Node(String d) {
        data = d;
        next = null;
    }
}