package ExpenseTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ExpenseModel addExpense(@Valid @RequestBody ExpenseModel expenseModel){
		return expenseServices.addExpense(expenseModel);
	}
	
	@GetMapping("/getAllExpense")
	public List<ExpenseModel> getAllExpense(){
		return expenseServices.getAllExpense();
	}
	
	@GetMapping("/getExpenseById/{id}")
	public ExpenseModel getExpenseById(@PathVariable String id){
		return expenseServices.getExpenseById(id);
	}
	
	@DeleteMapping("/deleteExpenseById/{id}")
	public ExpenseModel deleteExpenseById(@PathVariable String id) {
		 return expenseServices.deleteExpenseById(id);
	}
	
	@PutMapping("/updateExpenseById/{id}")
	public ExpenseModel updateExpenseById(@Valid @RequestBody ExpenseModel expenseModel, @PathVariable String id) {
		return expenseServices.updateExpenseById(expenseModel, id);
	}
	

}
