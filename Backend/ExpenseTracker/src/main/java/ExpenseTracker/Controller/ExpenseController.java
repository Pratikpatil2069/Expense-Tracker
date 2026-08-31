package ExpenseTracker.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExpenseTracker.ExpenseDTO.ExpenseRequest;
import ExpenseTracker.ExpenseDTO.ExpenseResponse;
import ExpenseTracker.Model.ExpenseModel;
import ExpenseTracker.Response.ApiResponse;
import ExpenseTracker.Services.ExpenseServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseServices expenseServices;
	
	@PostMapping("/addExpense")
	public ResponseEntity<ApiResponse<ExpenseResponse>> addExpense(@Valid @RequestBody ExpenseRequest expenseRequest){
		
		ExpenseResponse expense= expenseServices.addExpense(expenseRequest);
		
		ApiResponse<ExpenseResponse>response=new ApiResponse<>(true,"Expense Successfully Creted",expense,LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/getAllExpense")
	public ResponseEntity<ApiResponse<List<ExpenseResponse>>> getAllExpense(){
		
		List<ExpenseResponse>list =expenseServices.getAllExpense();
		
		ApiResponse<List<ExpenseResponse>>response=new ApiResponse<>(true, "All Expense Fetched Successfully", list, LocalDateTime.now());
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getExpenseById/{id}")
	public ResponseEntity<ApiResponse<ExpenseResponse>> getExpenseById(@PathVariable String id){
		
		ExpenseResponse expense= expenseServices.getExpenseById(id);
		
		ApiResponse<ExpenseResponse>response=new ApiResponse<>(true,"Expense Fetched Successfully",expense,LocalDateTime.now());

		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/deleteExpenseById/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteExpenseById(@PathVariable String id) {
		
		 expenseServices.deleteExpenseById(id);
		 
		 ApiResponse<Void>response=new ApiResponse<>(true,"Expense Deleted Successfully ",null,LocalDateTime.now());

		 return ResponseEntity.ok(response);
		 
	}
	
	@PutMapping("/updateExpenseById/{id}")
	public ResponseEntity<ApiResponse<ExpenseResponse>> updateExpenseById(@Valid @RequestBody ExpenseRequest expenseRequest, @PathVariable String id) {
		
		ExpenseResponse expense= expenseServices.updateExpenseById(expenseRequest, id);
		
		ApiResponse<ExpenseResponse>response=new ApiResponse<>(true,"Expense Updated Successfully ",expense,LocalDateTime.now());

		return ResponseEntity.ok(response);
	}
	

}
