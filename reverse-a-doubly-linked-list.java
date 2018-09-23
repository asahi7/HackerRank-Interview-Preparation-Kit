    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode tail = null;
        if(head == null) {
            return null;
        }
        DoublyLinkedListNode node = head;
        while(node.next != null) {
            node = node.next;
        }
        tail = node;
        if(tail == head) {
            return head;
        }
        node = tail;
        // 1 3 4 -> null 4 3 1 
        // 
        while(node != null) {
            DoublyLinkedListNode temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            node = node.next;
        }
        return tail;
    }
