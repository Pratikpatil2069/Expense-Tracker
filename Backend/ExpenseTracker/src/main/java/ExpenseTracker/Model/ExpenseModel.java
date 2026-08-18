package ExpenseTracker.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="expense")
@NoArgsConstructor()
@AllArgsConstructor()
@Data()
public class ExpenseModel {
	
	@Id
	private String id;
	
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
