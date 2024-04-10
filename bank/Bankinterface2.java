package bank;

import java.util.HashMap;

interface Bankinterface2 {

	void transfer(String accountnumber2, String accountnumber22, double amount) throws Exception;

	void Debit(String account1, double amount, HashMap<String, BankAccount> map) throws Exception;

	void Credit(String account11, double amount1, HashMap<String, BankAccount> map2) throws Exception;

}
