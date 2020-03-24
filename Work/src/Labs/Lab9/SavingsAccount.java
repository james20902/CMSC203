package Labs.Lab9;

public class SavingsAccount extends BankAccount {
  private double rate = .025;
  private int savingsNumber = 0;
  private String accountNumber;

  public SavingsAccount(String name, double initalAmount){
    super(name, initalAmount);
    accountNumber = super.getAccountNumber() + "-" + savingsNumber;
  }

  public SavingsAccount(SavingsAccount original, double initialAmount){
    super(original, initialAmount);
    savingsNumber = original.savingsNumber + 1;
    accountNumber = super.getAccountNumber() + "-" + savingsNumber;
  }

  public void postInterest(){
    super.deposit(super.getBalance() * rate);
  }

  @Override
  public String getAccountNumber(){
    return this.accountNumber;
  }
}
