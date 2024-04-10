package bank;

import java.util.HashMap;

public abstract class Bankinterface implements Bankinterface2 {

	public void Credit(String account11, double amount1, HashMap<String, BankAccount> map2) throws Exception {
		if (BankAccount.map.get(account11).getAccountNumber().equals(account11)) {
			BankAccount.map.get(account11)
					.setAccountBalance(BankAccount.map.get(account11).getAccountBalance() + amount1);
			BankAccount.totalDepoosit += amount1;
		} else {
			throw new Exception("Account not found");
		}

	}

}
