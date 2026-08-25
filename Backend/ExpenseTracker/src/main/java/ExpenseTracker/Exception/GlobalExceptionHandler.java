package ExpenseTracker.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ExpenseTracker.Model.ExpenseModel;
import ExpenseTracker.Response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundResourceException.class)
	public ResponseEntity<ApiResponse<ExpenseModel>> ResourceNotFound(NotFoundResourceException ex){
		
		ApiResponse<ExpenseModel>response=new ApiResponse<>(false, ex.getMessage(), null, LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Map<String, String>>> MethodArgumentNotValid(MethodArgumentNotValidException ex){
		
		Map<String, String>errors = new HashMap<>();

 	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
 	        errors.put(error.getField(), error.getDefaultMessage());
 	    }
 	    
		ApiResponse<Map<String, String>>response=new ApiResponse<>(false, "Validation failed", errors, LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<ExpenseModel>> HandleGlobalException(Exception ex){
		
		ApiResponse<ExpenseModel>response=new ApiResponse<>(false, "Something went wrong", null, LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

}
