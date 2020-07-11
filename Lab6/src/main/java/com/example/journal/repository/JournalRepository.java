package com.example.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.journal.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
