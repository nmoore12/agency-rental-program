public class TransactionNode {
    private Transaction tran;
    private TransactionNode next;

    public TransactionNode(Transaction tran, TransactionNode next) {
        this.tran = tran;
        this.next = next;
    }

    public Transaction getTrans() {
        return tran;
    }

    public TransactionNode getNext() {
        return next;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }
}
