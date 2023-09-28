public class Accounts {
  private AccountNode accounts;
  private AccountNode current;

  public Accounts() {
    accounts = null;
    current = null;
  }

  public void add(Account acct) {
    if(accounts == null) {
      accounts = new AccountNode(acct, null);
    }
    else {
      getLastNode().setNext(new AccountNode(acct, null));
      }
    }

    public Account getAccount(String creditCardNumber) {
      if(accounts == null) {
        return null;
      } else {
        AccountNode tempNode = accounts.getNext();
        while(tempNode != null) {
          Account currentAcct = tempNode.getAcct();
          if(currentAcct.getCreditCardNumber() == creditCardNumber) {
            return currentAcct;
          }
        }
      }
      return null;
    }

    public void reset() {
      current = accounts;
    }

    public Account getNext() {
      Account currAcct = current.getAcct();
      current = current.getNext();
      return currAcct;
    }

    public boolean hasNext() {
      return current != null;
    }

    private boolean lastNode(AccountNode node) {
      return node.getNext() == null;
    }

  private AccountNode getLastNode() {
    AccountNode temp = accounts;
    while(!lastNode(temp)) {
      temp = temp.getNext();
    }
    return temp;
  }

  
}