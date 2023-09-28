public class AccountNode {
    private Account acct;
    private AccountNode next;

    public AccountNode(Account acct, AccountNode next) {
        this.acct = acct;
        this.next = next;
    }

    public Account getAcct() {
        return acct;
    }

    public AccountNode getNext() {
        return next;
    }

    public void setNext(AccountNode next) {
        this.next = next;
    }
}
