package scd.lab.midproject;

import java.io.*;
import java.util.*;

public class TransactionHistory {
    private int userId; // Unique ID for each user
    private List<Transaction> transactionList; // Stores all transactions

    // Constructor with user ID
    public TransactionHistory(int userId) {
        this.userId = userId;
        this.transactionList = new ArrayList<>();
    }

    // Add a transaction and store it in the file
    public void addTransaction(Transaction newTransaction) {
        transactionList.add(newTransaction);
        saveTransactionToFile(newTransaction);
    }

    // Store each transaction in a user-specific file
    private void saveTransactionToFile(Transaction transaction) {
        File file = new File("TransactionHistory_User_" + userId + ".txt");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(transaction.toString() + "\n");
        } catch (IOException e) {
            System.err.println("Failed to create or write to the transaction file.");
            e.printStackTrace();
        }
    }

    // View transaction history from the user-specific file
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
