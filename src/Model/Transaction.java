package Model;

public class Transaction {
	protected int TransactionID;
	protected String userEmail;
	protected int quantity;
	protected String fishID;
	public Transaction(int transactionID, String userEmail, int quantity, String fishID) {
		super();
		TransactionID = transactionID;
		this.userEmail = userEmail;
		this.quantity = quantity;
		this.fishID = fishID;
	}
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFishID() {
		return fishID;
	}
	public void setFishID(String fishID) {
		this.fishID = fishID;
	}
	

}
