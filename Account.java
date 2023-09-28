public class Account {
  private String company_name;
  private String credit_card;
  private boolean prime_customer;

  public Account(String company_name, String credit_card, boolean prime_customer) {
    this.company_name = company_name;
    this.credit_card = credit_card;
    this.prime_customer = prime_customer;
  }

  public String getCompanyName() {
  return company_name;
}

  public String getCreditCardNumber() {
    return credit_card;
  }

  public boolean primeCustomer() {
    return prime_customer;
  }

  public String toString() {
    return ""+company_name+" "+credit_card;
  }
}