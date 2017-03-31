package fr.unice.polytech.qgl.qbd.exception;

public class NoSingularResourceDatabaseFoundException extends RuntimeException {
    public NoSingularResourceDatabaseFoundException(){
        super("The SingularResourceDatabase has not been found");
    }
}