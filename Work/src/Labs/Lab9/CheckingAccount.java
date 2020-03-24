package Labs.Lab9;

public class CheckingAccount extends BankAccount {
  public static double FEE = .15;

  public CheckingAccount(String accountName, double initialAmount){
    super(accountName, initialAmount);
    setAccountNumber(getAccountNumber() + "-10");
  }

  @Override
  public boolean withdraw(double amount){
    return super.withdraw(amount + FEE);
  }
}
