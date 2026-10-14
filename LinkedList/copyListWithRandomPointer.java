/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> copiedNode = new HashMap<>();
        copiedNode.put(null,null);
        Node curr = head;

        while(curr != null){
            Node copy = new Node(curr.val);
            copiedNode.put(curr,copy);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            copiedNode.get(curr).next =  copiedNode.get(curr.next);
            copiedNode.get(curr).random =  copiedNode.get(curr.random);
            curr = curr.next;
        }
        return copiedNode.get(head);
        
    }
}
