package csi405.lecture03;

/**
 * A {@code BankAccount} represents a bank account.
 * 
 * @author Jeong-Hyon Hwang (jhh@cs.albany.edu)
 */
public class BankAccount {

	/**
	 * The identifier of this {@code BankAccount}.
	 */
	protected String accoutID;

	/**
	 * The balance of this {@code BankAccount}.
	 */
	protected double balance;

	/**
	 * The number of {@code BankAccount}s constructed so far.
	 */
	static protected int numberAccounts = 0;

	/**
	 * Constructs a {@code BankAccount}.
	 * 
	 * @param accountID
	 *            the identifier of the {@code BankAccount}.
	 * @param balance
	 *            the balance of the {@code BankAccount}.
	 */
	public BankAccount(String accountID, double balance) {
		this.accoutID = accountID;
		this.balance = balance;
		numberAccounts++;
	}

	/**
	 * Constructs a {@code BankAccount}.
	 * 
	 * @param accountID
	 *            the identifier of the {@code BankAccount}.
	 */
	public BankAccount(String accountID) {
		this(accountID, 0);
	}

	/**
	 * Deposits the specified amount into this {@code BankAccount}.
	 * 
	 * @param amount
	 *            the amount to deposit.
	 */
	public void deposit(double amount) {
		System.out.println("% depositing " + double2Dollar(amount) + " to " + this);
		balance += amount;
	}

	/**
	 * Withdraws the specified amount from this {@code BankAccount}.
	 * 
	 * @param amount
	 *            the amount to withdraw.
	 */
	public void withdraw(double amount) {
		System.out.println("% withdrawing " + double2Dollar(amount) + " from " + this);
		balance -= amount;
	}

	/**
	 * Returns the current balance of this {@code BankAccount}.
	 * 
	 * @return the current balance of this {@code BankAccount}.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Returns a {@code String} representation of this {@code BankAccount}.
	 */
	@Override
	public String toString() {
		return "[ID: " + accoutID + ", balance: " + double2Dollar(balance) + "]";
	}

	/**
	 * Determines whether or not this {@code BankAccount} is equal to the specified {@code Object}.
	 * 
	 * @param o
	 *            an {@code Object}to compare with.
	 * @return true if this {@code BankAccount} is equal to the specified {@code Object}; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		return equals((BankAccount) o);
	}

	/**
	 * Determines whether or not this {@code BankAccount} is equal to the specified {@code BankAccount}.
	 * 
	 * @param b
	 *            a {@code BankAccount} to compare with.
	 * @return true if this {@code BankAccount} is equal to the specified {@code BankAccount}; false otherwise.
	 */
	protected boolean equals(BankAccount b) {
		return accoutID == b.accoutID;
	}

	/**
	 * Returns a US dollar representation of the specified amount.
	 * 
	 * @param amount
	 *            the amount of money.
	 * @return a US dollar representation of the specified amount.
	 */
	public static String double2Dollar(double amount) {
		return "$" + String.format("%.2f", amount);
	}

	/**
	 * The main method of the {@code BankAccount} class which demonstrates some use cases of {@code BankAccount}.
	 * 
	 * @param args
	 *            the program arguments.
	 */
	public static void main(String[] args) {

		BankAccount a = new BankAccount("100", 100); // account creation

		a.withdraw(50); // withdrawal
		System.out.println(a); // display information about the account
		System.out.println(a.toString()); // display information about the account
		System.out.println();

		a.deposit(100); // deposit
		System.out.println(a);
		System.out.println();

		// value mutation (primitive types)
		int c = 1;
		int d = c;
		System.out.println(c + " vs. " + d);
		d++;
		System.out.println(c + " vs. " + d);
		System.out.println();

		BankAccount b = a;
		// object mutation (reference types)
		b.withdraw(10);
		System.out.println(a + " vs. " + b);
		System.out.println();

		// equality examples
		BankAccount e = new BankAccount("100", 140);
		System.out.println(a + " == " + b + "? " + (a == b));
		System.out.println(a + ".equals(" + b + ")? " + (a.equals(b)));
		System.out.println(a + " == " + e + "? " + (a == e));
		System.out.println(a + ".equals(" + e + ")? " + (a.equals(e)));

		System.out.println("# of accounts: " + BankAccount.numberAccounts);
	}

}
