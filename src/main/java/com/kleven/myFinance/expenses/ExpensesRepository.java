package com.kleven.myFinance.expenses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExpensesRepository extends JpaRepository<Expense, Long>{

    Page<Expense> findAllByActiveTrue(Pageable pageable);
}
