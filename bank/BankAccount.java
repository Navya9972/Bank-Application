package bank;

import java.util.HashMap;

class BankAccount extends Bankinterface {
	static double totalDepoosit;
	private String accountNumber;
	private String accountHolderName;
	private double accountBalance;
	private AccountType accountType;
	private boolean accountStatus;
	private String bankName;
	static HashMap<String, BankAccount> map = new HashMap<>();

	// abstract void getAccount(String accountNumber,String accountHolderName,
	// AccountType accountType,double accountBalance,String bankName);
	// constructor
	BankAccount(String accountNumber, String accountHolderName, AccountType accountType, String bankName) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.bankName = bankName;
		this.accountStatus = true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + "]";
	}

	BankAccount(String accountNumber, String accountHolderName, AccountType accountType, double accountBalance,
			String bankName) {
		this(accountNumber, accountHolderName, accountType, bankName);
		this.accountBalance = accountBalance;
		totalDepoosit += accountBalance;
	}

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	// method
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public boolean isAccountActive() {
		return accountStatus;
	}

//	public void creditAmount(double amount) {
//		accountBalance+=amount;
//		totalDepoosit+=amount;
//		
//	}
//	public void debitAmount(double amount) throws Exception {
//		if(amount<=accountBalance&&accountStatus==true) {
//			accountBalance-=amount;
//			totalDepoosit-=amount;
//		}
//		else {
//			throw new Exception("insufficient balance");
//		}
//	}
	public void changeAccountHolderName(String name) {
		accountHolderName = name;
	}

	public void changeAccountType(AccountType type) {
		accountType = type;
	}

	public void closeAccount() {
		accountStatus = false;
	}

	public String getBankName() {
		return bankName;
	}

//	public void transfer(BankAccount toAccount,double amount) throws Exception {
//		if(accountStatus) {
//			if(amount<=accountBalance &&toAccount.isAccountActive()) {
//				debitAmount(amount);
//				toAccount.creditAmount(amount);
//			}
//			else {
//				throw new Exception("insufficient balance");
//			}
//		}else {
//			throw new Exception("Account inActive");
//		}
//	}
	public void transfer(String accountnumber2, String accountnumber22, double amount) throws Exception {
		// TODO Auto-generated method stub
		if (map.get(accountnumber2).getAccountNumber().equals(accountnumber2)) {
			if (map.get(accountnumber22).getAccountNumber().equals(accountnumber22)) {
				if (map.get(accountnumber2).isAccountActive()
						&& map.get(accountnumber2).getAccountBalance() >= amount) {
					map.get(accountnumber22).setAccountBalance(map.get(accountnumber22).getAccountBalance() + amount);
					map.get(accountnumber2).setAccountBalance(map.get(accountnumber2).getAccountBalance());
				}
			} else {
				throw new Exception("Account not found");
			}
		} else {
			throw new Exception("Account not found");
		}

	}

	// static method
	public static double getTotalDeposit() {
		return totalDepoosit;
	}

	public static AccountType getAccount(String type, String accountHolderName, double balance) {
		AccountType accountType = null;
		switch (type.toUpperCase()) {
		case "SAVING":
			accountType = AccountType.SAVING;
			break;
		case "CURRENT":
			accountType = AccountType.CURRENT;
			break;
		case "FIXED":
			accountType = AccountType.FIXED;
			break;
		}
		return accountType;
	}

	public void Debit(String account1, double amount, HashMap<String, BankAccount> map) throws Exception {
		if (map.get(account1).getAccountNumber().equals(account1)) {
			if (map.get(account1).getAccountBalance() >= amount) {
				map.get(account1).setAccountBalance(map.get(account1).getAccountBalance() - amount);
				totalDepoosit -= amount;
			} else {
				throw new Exception("LowBalance");
			}
		} else
			throw new Exception("Account not found");

	}

}
