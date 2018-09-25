
    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
      Set<SinglyLinkedListNode> set = new HashSet<>();
      while(head1 != null) {
        set.add(head1);
        head1 = head1.next;
      }
      while(head2 != null) {
        if(set.contains(head2)) {
          return head2.data;
        }
        head2 = head2.next;
      }
      return -1;
    }
