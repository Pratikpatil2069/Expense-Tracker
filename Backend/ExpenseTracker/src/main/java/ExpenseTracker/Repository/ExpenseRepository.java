package ExpenseTracker.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ExpenseTracker.Model.ExpenseModel;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseModel,String> {

}
