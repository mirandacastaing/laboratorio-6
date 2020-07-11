package com.example.journal.service;

import java.util.List;

import com.example.journal.domain.Journal;

public interface JournalService {
	public void saveJournal(Journal newJournal);

	public List<Journal> getAllJournals();
}
