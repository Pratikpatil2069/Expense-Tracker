package ExpenseTracker.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private String title;
	private double amount;
	private String category;
	private String description;
	private LocalDate date;
	private String paymentMethod;
	
}
