package com.kleven.myFinance.expenses;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExpensesRepository extends JpaRepository<Expense, Long>{
}
