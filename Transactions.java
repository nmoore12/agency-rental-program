public class Transactions {
    private TransactionNode transactions;
    private TransactionNode current;

    public void add(Transaction tran) {
        if(transactions == null) {
            transactions = new TransactionNode(tran, null);
        } else {
            getLastNode().setNext(new TransactionNode(tran, null));
        }
    }

    public void reset() {
        current = transactions;
    }

    public Transaction getNext() {
        Transaction currTrans = current.getTrans();
        current = current.getNext();
        return currTrans;
    }

  
    private boolean lastNode(TransactionNode node) {
        return node.getNext() == null;
    }

    private TransactionNode getLastNode() {
        TransactionNode temp = transactions;
        while(!lastNode(temp)) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean hasNext() {
        return current != null;
    }

}