package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import Model.Fish;
import Model.FreshwaterFish;
import Model.SaltwaterFish;
import Model.Transaction;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<Fish> fishVec = new Vector<>();
	Vector<Transaction> transVec = new Vector<>();
	Connect connect = Connect.getConnection();
	int globalvar =0;
	private void initialize()
	{
		String q1 = "SELECT * FROM freshwaterfish";
		ResultSet rs = connect.executeQuery(q1);
		try {
			while(rs.next()==true)
			{
				FreshwaterFish freshfish = new FreshwaterFish(rs.getString("FishID"), rs.getString("FishName"), rs.getFloat("FishSize"), rs.getInt("FishSpeed"), 1, rs.getInt("FishAlgaeTolerance"));
				fishVec.add(freshfish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initialize2()
	{
		String q1 = "SELECT * FROM saltwaterfish";
		ResultSet rs2 = connect.executeQuery(q1);
		try {
			while(rs2.next()==true)
			{
				SaltwaterFish saltfish = new SaltwaterFish(rs2.getString("FishID"), rs2.getString("FishName"), rs2.getFloat("FishSize"), rs2.getInt("FishSpeed"), 1, rs2.getString("FishDepthTolerance"));
				fishVec.add(saltfish);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initialize3()
	{
		String q1 = "SELECT * FROM transaction";
		ResultSet rs3 = connect.executeQuery(q1);
		try {
			while(rs3.next()==true)
			{
				Transaction transaction = new Transaction(rs3.getInt("TransactionID"), rs3.getString("UserEmail"), rs3.getInt("Quantity"), rs3.getString("FishID"));
				transVec.add(transaction);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void Menu1()
	{
		int index =0;
		for (Fish fish : fishVec) {
			index++;
			System.out.printf("%d. ", index);
			fish.print();
		}
		String email;
		do
		{
			System.out.println("Input User Email [Ends with '.com' | contains '@']: ");
			email = scan.nextLine();
		}while(!email.endsWith(".com") && !email.contains("@"));
		int quantity;
		do
		{
			System.out.println("Input Quantity [Must be Greater than 0]: ");
			quantity = scan.nextInt();scan.nextLine();
		}while(quantity<0);
		String type;
		do
		{
			System.out.println("Input Fish Type [Freshwater|Saltwater] (Case Sensitive): ");
			type = scan.nextLine();
		}while(!type.equals("Freshwater") && !type.equals("Saltwater"));
		int indexer;
		do
		{
			System.out.println("Input Fish Index to Purchase[1-"+fishVec.size()+"]");
			indexer = scan.nextInt();scan.nextLine();
		}while(indexer<0 || indexer>fishVec.size());
		String FF = fishVec.elementAt(indexer-1).getId();
		String FFName = fishVec.elementAt(indexer-1).getName();
		int FFSize = (int) fishVec.elementAt(indexer-1).getSize();
		int FFSpeed = fishVec.elementAt(indexer-1).getSpeed();
		double FFPrice = 0;
		if(type.equals("Freshwater"))
		{
			FreshwaterFish FFAlgae = (FreshwaterFish) fishVec.elementAt(indexer-1);
			FFPrice = FFSize * FFSpeed * quantity * FFAlgae.getAlgae();
		}
		if(type.equals("Saltwater"))
		{
			SaltwaterFish FFDepth = (SaltwaterFish) fishVec.elementAt(indexer-1);
			FFPrice = FFSize * FFSpeed * quantity * 2.5;
		}
		System.out.println("Fish ID: "+ FF);
		System.out.println("Fish Name: "+FFName);
		System.out.println("Fish Size: "+FFSize+" Meter");
		System.out.println("Fish Speed: "+FFSpeed+" KMPH");
		System.out.printf("Price: %.1f $\n", FFPrice);
		Transaction transaction = new Transaction(globalvar+1, email, quantity, FF);
		transVec.add(transaction);
		String q1 = "INSERT INTO transaction VALUES(?,?,?,?)";
		PreparedStatement ps = connect.prepareStatement(q1);
		try {
			ps.setInt(1, globalvar+1);
			ps.setString(2, email);
			ps.setInt(3, quantity);
			ps.setString(4, FF);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successful!");
		
	}
	
	private void Menu2()
	{
		if(transVec.isEmpty())
		{
			System.out.println("No data available");
		}
		for (Transaction trans : transVec) {
			System.out.println("Transaction ID: "+trans.getTransactionID());
			System.out.println("User E-mail: "+trans.getUserEmail());
			System.out.println("Quantity: "+trans.getQuantity());
			System.out.println("Fish ID: "+trans.getFishID());
		}
	}
	
	private void Menu3()
	{
		int index = 0;
		do
		{
			System.out.println("Input Transaction ID to be Deleted:");
			index = scan.nextInt();scan.nextLine();
		}while(index<0 || index > fishVec.size());
		int index2 =0;
		for (Transaction transaction : transVec) {
			if(transaction.getTransactionID() == index)
			{
				index2++;
				transVec.remove(index2-1);
				String q1="DELETE FROM transaction WHERE TransactionID = ?";
				PreparedStatement ps = connect.prepareStatement(q1);
				try {
					ps.setInt(1, transaction.getTransactionID());
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Successful!");
				break;
			}
			else
			{
				System.out.println("Not found.");
				break;
			}
		}
		
		
	}
	private void view()
	{
		if(transVec.isEmpty())
		{
			System.out.println("No data available");
		}
		for (Transaction trans : transVec) {
			System.out.println("Transaction ID: "+trans.getTransactionID());
			System.out.println("User E-mail: "+trans.getUserEmail());
			System.out.println("Quantity: "+trans.getQuantity());
			System.out.println("Fish ID: "+trans.getFishID());
		}
	}
	public Main() {
		initialize();
		initialize2();
		initialize3();
		int menu = 0;
		do {
			System.out.println("EXOTIC FISH STORE");
			System.out.println("==================");
			System.out.println("1. Purchase Exotic Fish");
			System.out.println("2. View Transaction");
			System.out.println("3. Cancel Transaction");
			System.out.println("4. Exit Menu");
			System.out.println("Input [1-4]: ");
			menu = scan.nextInt();scan.nextLine();
			switch(menu)
			{
			case 1:
				Menu1();
				break;
			case 2:
				Menu2();
				break;
			case 3:
				view();
				Menu3();
				break;
			}
		} while (menu!=4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
