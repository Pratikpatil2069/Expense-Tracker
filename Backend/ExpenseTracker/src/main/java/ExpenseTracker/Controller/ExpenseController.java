package ExpenseTracker.Controller;

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

import ExpenseTracker.Model.ExpenseModel;
import ExpenseTracker.Services.ExpenseServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseServices expenseServices;
	
	@PostMapping("/addExpense")
	public ResponseEntity<ExpenseModel> addExpense(@Valid @RequestBody ExpenseModel expenseModel){
		ExpenseModel expense= expenseServices.addExpense(expenseModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(expense);
	}
	
	@GetMapping("/getAllExpense")
	public ResponseEntity<List<ExpenseModel>> getAllExpense(){
		List<ExpenseModel>list =expenseServices.getAllExpense();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getExpenseById/{id}")
	public ResponseEntity<ExpenseModel> getExpenseById(@PathVariable String id){
		ExpenseModel expense= expenseServices.getExpenseById(id);
		return ResponseEntity.ok(expense);
	}
	
	@DeleteMapping("/deleteExpenseById/{id}")
	public ResponseEntity<Void> deleteExpenseById(@PathVariable String id) {
		 expenseServices.deleteExpenseById(id);
		 return ResponseEntity.noContent().build();
		 
	}
	
	@PutMapping("/updateExpenseById/{id}")
	public ResponseEntity<ExpenseModel> updateExpenseById(@Valid @RequestBody ExpenseModel expenseModel, @PathVariable String id) {
		ExpenseModel expense= expenseServices.updateExpenseById(expenseModel, id);
		return ResponseEntity.ok(expense);
	}
	

}
