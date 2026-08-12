package ExpenseTracker.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import ExpenseTracker.Model.ExpenseModel;
import ExpenseTracker.Repository.ExpenseRepository;

@Service
public class ExpenseServices {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public ExpenseModel addExpense(ExpenseModel expenseModel) {
		return expenseRepository.save(expenseModel);
	}
	
	public List<ExpenseModel> getAllExpense() {
		return expenseRepository.findAll();
	}
	
	public ExpenseModel getExpenseById(String id) {
		return expenseRepository.findById(id).orElse(null);
	}
	
	public void deleteExpense(String id) {
		 expenseRepository.deleteById(id);
	}
	
	public ExpenseModel updateExpense(ExpenseModel expenseModel,String id) {
		ExpenseModel old=expenseRepository.findById(id).orElse(null);
		if(old!=null) {
			old.setTitle(expenseModel.getTitle());
			old.setAmount(expenseModel.getAmount());
			old.setCategory(expenseModel.getCategory());
			old.setDescription(expenseModel.getDescription());
			old.setDate(expenseModel.getDate());
			old.setPaymentMethod(expenseModel.getPaymentMethod());
			return expenseRepository.save(old);
		}else {
			return expenseRepository.save(expenseModel);
		}
		
	}
	

}
