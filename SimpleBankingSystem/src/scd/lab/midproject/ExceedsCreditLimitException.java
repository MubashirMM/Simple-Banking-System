package scd.lab.midproject;

//Exception for exceeding credit limit
class ExceedsCreditLimitException extends Exception {
 public ExceedsCreditLimitException(String message) {
     super(message);
 }
}