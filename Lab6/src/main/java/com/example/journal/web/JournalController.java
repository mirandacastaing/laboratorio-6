package com.example.journal.web;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.journal.domain.Journal;
import com.example.journal.service.JournalService;

@Controller
public class JournalController {
	@Autowired
	JournalService journalService;

	@GetMapping("/form")
	public String journalForm(Model model) {
		model.addAttribute("journal", new Journal());
		return "form";
	}

	@PostMapping("/")
	public String journalSubmit(@ModelAttribute Journal journal, Model model) {
		journal.setCreated(Calendar.getInstance().getTime());
		journalService.saveJournal(journal);
		model.addAttribute("journal", journalService.getAllJournals());
		return "journal";
	}

	@GetMapping("/")
	public String journalSubmit(Model model) {
		model.addAttribute("journal", journalService.getAllJournals());
		return "journal";
	}

	@GetMapping("/entry")
	public String journalInfo(@RequestParam String id, Model model) {
		for (Journal journal : journalService.getAllJournals()) {
			if (journal.getId() == Long.parseLong(id)) {
				model.addAttribute("journal", journal);
				break;
			}
		}
		return "entry";
	}
}
