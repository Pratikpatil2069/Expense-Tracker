package ExpenseTracker.Exception;

public class NotFoundResourceException extends RuntimeException{
	public NotFoundResourceException(String message){
		super(message);
	}
}
