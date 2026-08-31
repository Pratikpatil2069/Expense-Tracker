package ExpenseTracker.ExpenseDTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExpenseRequest {
	
	@NotBlank(message="Please Enter your Title")
	private String title;
	
	@NotNull(message="Please Enter your amount")
	private double amount;
	
	@NotBlank(message="Please Enter your category")
	private String category;
	
	@NotBlank(message="Please Enter your description")
	private String description;
	
	@NotNull(message="Please Enter your date")
	private LocalDate date;
	
	@NotBlank(message="Please Enter your paymentMethod")
	private String paymentMethod;
}
