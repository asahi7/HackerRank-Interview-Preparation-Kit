
    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode originalHead = head;
        if(head == null) {
            return newNode;   
        }
        if(position == 0) {
            newNode.next = head;
            return newNode;
        }
        // 16 13 7, 1 3
        // 
        for(int i = 0; i < position - 1; i++) {
            head = head.next;
        }
        newNode.next = head.next;
        head.next = newNode;
        return originalHead;
    }
