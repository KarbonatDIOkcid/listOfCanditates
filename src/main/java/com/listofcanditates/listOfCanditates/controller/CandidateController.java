package com.listofcanditates.listOfCanditates.controller;

import com.listofcanditates.listOfCanditates.model.Candidate;
import com.listofcanditates.listOfCanditates.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CandidateController {

	private final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@GetMapping("/candidates")
	public String getCandidates(Model model) {
		model.addAttribute("candidates", candidateService.getCandidates());
		return "candidates_list";
	}

	@GetMapping("/candidates/add")
	public String addCandidate(Model model) {
		model.addAttribute("candidate", new Candidate());
		return "add_candidate";
	}

	@PostMapping("/candidates/add")
	public String saveCandidate(Candidate candidate) {
		candidateService.addCandidate(candidate);
		return "redirect:/candidates";
	}

	@GetMapping("/candidates/search")
	public String displaySearchForm() {
		return "candidates_list";
	}

	@PostMapping("/candidates/search")
	public String searchCandidate(@RequestParam(name="surname", required = false) String surname,
								  @RequestParam(name="initials", required = false) String initials, Model model) {
		if(surname != null && !surname.isEmpty() && initials != null && !initials.isEmpty()) {
			model.addAttribute("candidates", candidateService.findBySurnameAndInitials(surname, initials));
		} else {
			model.addAttribute("errorMessage", "No surname and initials entered.");
		}
		return "candidates_list";
	}

	@GetMapping("/candidates/{id}")
	public String getCandidate(@PathVariable Long id, Model model) {
		Optional<Candidate> candidate = candidateService.getCandidate(id);
		if(candidate.isPresent()){
			model.addAttribute("candidate", candidate.get());
			return "candidate_details";
		}
		return "redirect:/candidates";
	}

	@GetMapping("/candidates/delete/{id}")
	public String deleteCandidate(@PathVariable Long id) {
		candidateService.deleteCandidate(id);
		return "redirect:/candidates";
	}

	@PostMapping("/candidates/vote/{id}")
	@ResponseBody
	public String voteForCandidate(@PathVariable Long id) {
		boolean isVoted = candidateService.voteForCandidate(id);
		if(isVoted){
			return "Vote is successfully counted.";
		} else {
			return "Vote couldn't be counted. Please check candidate id.";
		}
	}
}
