package scd.lab.midproject;

import java.io.*;
import java.util.*;

public class TransactionHistory {

    // Variables
    private int userId;
    private List<Transaction> transactionList;

    // Constructor with user ID
    public TransactionHistory(int userId) {
        this.userId = userId;
        transactionList = new ArrayList<>();
    }

    // Add transaction and store in file
    public void addTransaction(Transaction newTransaction) {
        transactionList.add(newTransaction);
        keepTransactionInFile(newTransaction);
    }

    // Store transaction in user-specific file
    private void keepTransactionInFile(Transaction transaction) {
        File file = new File("TransactionHistory_User_" + userId + ".txt");
       // System.out.println("Attempting to create transaction file at: " + file.getAbsolutePath());
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(transaction.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Failed to create or write to the transaction file.");
            e.printStackTrace();  // This will print the detailed error in the console
        }
    }


 // In TransactionHistory class
    public void viewTransactionHistoryFromFile() {
        File file = new File("TransactionHistory_User_" + userId + ".txt");
        if (!file.exists()) {
            System.out.println("No transaction history found for User ID: " + userId);
            return;
        }

        System.out.println("Transaction History for User ID: " + userId);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
