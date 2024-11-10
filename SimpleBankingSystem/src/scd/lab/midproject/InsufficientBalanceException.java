package scd.lab.midproject;

//Exception for insufficient balance
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}
