package org.example.fooddeliverysystem.repository;

import org.example.fooddeliverysystem.entity.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
}
