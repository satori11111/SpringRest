package ua.ExceptionHandling;

public class NoSuchEmployeeException  extends RuntimeException{
    public NoSuchEmployeeException(String message){
        super(message);
    }
}
