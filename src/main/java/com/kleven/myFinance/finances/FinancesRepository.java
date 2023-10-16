package com.kleven.myFinance.finances;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancesRepository extends JpaRepository<Finance, Long> {
}
