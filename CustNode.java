public class CustNode {
    public Customer c;
    public CustNode next;
   
    public CustNode(Customer c) {
        this.c = c;
        this.next = null;
    }
}