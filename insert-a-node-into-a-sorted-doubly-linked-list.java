    // Complete the sortedInsert function below.

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
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if(head == null) {
            return newNode;
        }
        if(head.data > data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        DoublyLinkedListNode node = head;
        while(data > node.data) {
            if(node.next == null) {
                newNode.prev = node;
                node.next = newNode;
                return head;
            }
            node = node.next;
        }
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        return head;
    }
