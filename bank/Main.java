package bank;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
//		HashMap<String, BankAccount> map=new HashMap<>();
		boolean flag = true;
		while (flag) {
			System.out.println("\n 1)create account\n 2)print Account details\n 3)Debit\n 4)credit\n 5)transfer\n "
					+ "6)TotalDeposit\n 7)Change AccountHolder name\n 8)print all accountdetails\n 9)exit");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter accountnumber");
				String accountnumber = s.next();
				System.out.println("Enter accountholdername");
				String accountholdername = s.next();

				System.out.println("Enter accountbalance");
				double accountbalance = s.nextDouble();
				// accounttype=getAccount(accounttype,accountholdername,accountbalance);
				System.out.println("Enter Bankname");
				String bankname = s.next();
				System.out.println("Enter accountType 1)SAVING 2)CURRENT 3)FIXED");
				int a = s.nextInt();
				switch (a) {
				case 1:
					BankAccount.map.put(accountnumber, new BankAccount(accountnumber, accountholdername,
							AccountType.SAVING, accountbalance, bankname));
					break;
				case 2:
					BankAccount account11 = new BankAccount(accountnumber, accountholdername, AccountType.CURRENT,
							accountbalance, bankname);
					BankAccount.map.put(accountnumber, account11);
					break;
				case 3:
					BankAccount account111 = new BankAccount(accountnumber, accountholdername, AccountType.FIXED,
							accountbalance, bankname);
					BankAccount.map.put(accountnumber, account111);
					break;

				}

				break;
			case 2:
				System.out.println("Enter accountnumber");
				String account = s.next();
				if (BankAccount.map.get(account).getAccountNumber().equals(account)) {
					System.out.println(BankAccount.map.get(account).toString());
//							BankAccount.map.get(account).getAccountNumber() + " " + BankAccount.map.get(account).getAccountHolderName() + " "
//									+ BankAccount.map.get(account).getAccountBalance() + " " + BankAccount.map.get(account).getBankName());
				} else {
					throw new Exception("Account not found");
				}
				break;
			case 3:
				System.out.println("Enter accountnumber");
				String account1 = s.next();
				System.out.println("Enter amount");
				double amount = s.nextDouble();
				BankAccount account111 = new BankAccount();
				account111.Debit(account1, amount, BankAccount.map);
//				if (BankAccount.map.get(account1).getAccountNumber().equals(account1)) {
//					if (BankAccount.map.get(account1).getAccountBalance() >= amount) {
//						BankAccount.map.get(account1).setAccountBalance(BankAccount.map.get(account1).getAccountBalance() - amount);
//						BankAccount.totalDepoosit -= amount;
//					} else {
//						throw new Exception("LowBalance");
//					}
//				} else
//					throw new Exception("Account not found");

				break;

			case 4:
				System.out.println("Enter accountnumber");
				String account11 = s.next();
				System.out.println("Enter amount");
				double amount1 = s.nextDouble();
				BankAccount account2 = new BankAccount();
				account2.Credit(account11, amount1, BankAccount.map);
//				if (BankAccount.map.get(account11).getAccountNumber().equals(account11)) {
//					BankAccount.map.get(account11).setAccountBalance(BankAccount.map.get(account11).getAccountBalance() + amount1);
//					BankAccount.totalDepoosit += amount1;
//				} else {
//					throw new Exception("Account not found");
//				}
				break;
			case 5:
				System.out.println("Enter accountnumber");
				String accountnumber1 = s.next();
				System.out.println("Enter transfer accountnumber");
				String accountnumber2 = s.next();
				System.out.println("Enter amount");
				double amount11 = s.nextDouble();
				BankAccount account1111 = new BankAccount();
				account1111.transfer(accountnumber1, accountnumber2, amount11);
				break;
			case 6:
				System.out.println(BankAccount.getTotalDeposit());
				break;
			case 7:
				System.out.println("Enter accountNumber");
				String accountnumber11 = s.next();
				System.out.println("Enter change name");
				String name = s.next();
				if (BankAccount.map.get(accountnumber11).getAccountNumber().equals(accountnumber11)) {
					BankAccount.map.get(accountnumber11).setAccountHolderName(name);
				}

				break;
			case 8:
				System.out.println(BankAccount.map);
				break;
			case 9:
				System.exit(0);
			}
		}

	}

}
