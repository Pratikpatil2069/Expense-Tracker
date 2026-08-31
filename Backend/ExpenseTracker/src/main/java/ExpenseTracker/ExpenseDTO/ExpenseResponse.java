package ExpenseTracker.ExpenseDTO;

import java.time.LocalDate;


import lombok.Data;

@Data
public class ExpenseResponse {
	
	private String id;
	
	private String title;
	
	private double amount;
	
	private String category;
	
	private String description;
	
	private LocalDate date;
	
	private String paymentMethod;
}
