
/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
  Node fasterHead = head;
  while(head != null) {
    fasterHead = fasterHead.next;
    if(fasterHead == null) {
      return false;
    }
    fasterHead = fasterHead.next;
    head = head.next;
    if(head == null || fasterHead == null) {
      return false;
    }
    if(fasterHead == head) {
      return true;
    }
  }
  return false;
}
