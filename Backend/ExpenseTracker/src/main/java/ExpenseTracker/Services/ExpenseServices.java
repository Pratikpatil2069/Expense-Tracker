package ExpenseTracker.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ExpenseTracker.Exception.NotFoundResourceException;
import ExpenseTracker.ExpenseDTO.ExpenseRequest;
import ExpenseTracker.ExpenseDTO.ExpenseResponse;

import java.util.ArrayList;
import java.util.List;

import ExpenseTracker.Model.ExpenseModel;
import ExpenseTracker.Repository.ExpenseRepository;

@Service
public class ExpenseServices {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public ExpenseResponse addExpense(ExpenseRequest expenseRequest) {
		
		ExpenseModel expenseModel=new ExpenseModel();
		
		expenseModel.setTitle(expenseRequest.getTitle());
		expenseModel.setPaymentMethod(expenseRequest.getPaymentMethod());
		expenseModel.setDescription(expenseRequest.getDescription());
		expenseModel.setDate(expenseRequest.getDate());
		expenseModel.setCategory(expenseRequest.getCategory());
		expenseModel.setAmount(expenseRequest.getAmount());
		
		ExpenseModel response= expenseRepository.save(expenseModel);
		
		ExpenseResponse expenseResponse=new ExpenseResponse();
		
		expenseResponse.setTitle(response.getTitle());
		expenseResponse.setPaymentMethod(response.getPaymentMethod());
		expenseResponse.setDescription(response.getDescription());
		expenseResponse.setDate(response.getDate());
		expenseResponse.setCategory(response.getCategory());
		expenseResponse.setAmount(response.getAmount());
		
		return expenseResponse;
		
		
	}
	
	public List<ExpenseResponse> getAllExpense() {
		
		List<ExpenseModel> response= expenseRepository.findAll();
		
		List<ExpenseResponse>exr=new ArrayList<>();
		
		for(ExpenseModel expenseModel:response) {
			
			ExpenseResponse expenseResponse=new ExpenseResponse();
			
			expenseResponse.setTitle(expenseModel.getTitle());
			expenseResponse.setPaymentMethod(expenseModel.getPaymentMethod());
			expenseResponse.setDescription(expenseModel.getDescription());
			expenseResponse.setDate(expenseModel.getDate());
			expenseResponse.setCategory(expenseModel.getCategory());
			expenseResponse.setAmount(expenseModel.getAmount());
			
			exr.add(expenseResponse);
		}
		return exr;
	}
	
	public ExpenseResponse getExpenseById(String id){
		
		
		ExpenseModel response= expenseRepository.findById(id).orElseThrow(()->new NotFoundResourceException("Expense Not Found by id: "+id));
		
		ExpenseResponse expenseResponse=new ExpenseResponse();
		
		expenseResponse.setTitle(response.getTitle());
		expenseResponse.setPaymentMethod(response.getPaymentMethod());
		expenseResponse.setDescription(response.getDescription());
		expenseResponse.setDate(response.getDate());
		expenseResponse.setCategory(response.getCategory());
		expenseResponse.setAmount(response.getAmount());
		
		return expenseResponse;
	}
	
	public void deleteExpenseById(String id) {
		if(expenseRepository.existsById(id)) {
			
			expenseRepository.deleteById(id);
			
		}else {
			
			 throw new NotFoundResourceException("Expense Not Found with id: "+id);
			 
		}
		
	}
	
	public ExpenseResponse updateExpenseById(ExpenseRequest expenseRequest,String id) {
		ExpenseModel old=expenseRepository.findById(id).orElseThrow(()->new NotFoundResourceException("Expense Not Found by id: "+id));
		
		ExpenseModel expenseModel=new ExpenseModel();
		
		expenseModel.setTitle(expenseRequest.getTitle());
		expenseModel.setPaymentMethod(expenseRequest.getPaymentMethod());
		expenseModel.setDescription(expenseRequest.getDescription());
		expenseModel.setDate(expenseRequest.getDate());
		expenseModel.setCategory(expenseRequest.getCategory());
		expenseModel.setAmount(expenseRequest.getAmount());

		ExpenseModel response= expenseRepository.save(old);
		
		ExpenseResponse expenseResponse=new ExpenseResponse();

		expenseResponse.setTitle(response.getTitle());
		expenseResponse.setAmount(response.getAmount());
		expenseResponse.setCategory(response.getCategory());
		expenseResponse.setDescription(response.getDescription());
		expenseResponse.setDate(response.getDate());
		expenseResponse.setPaymentMethod(response.getPaymentMethod());
		
		return expenseResponse;
		
	}
	

}
