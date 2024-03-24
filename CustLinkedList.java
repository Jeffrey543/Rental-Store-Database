public class CustLinkedList {
    public CustNode head;

    public CustLinkedList() {
        head = null;
    }

    public void custAdd(CustNode c) {
        c.next = head;
        head = c;
    }

    public Customer findPhoneNum(String search) {
        CustNode current = head;
        while (current != null) {
            if (current.c.phoneNum.equals(search)) {
                return current.c;
            }
            current = current.next;
        }
        return null;
    }
}