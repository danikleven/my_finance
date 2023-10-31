package com.kleven.myFinance.finances;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FinancesRepository extends JpaRepository<Finance, Long> {
    Page<Finance> findAllByActiveTrue(Pageable pageable);


}
