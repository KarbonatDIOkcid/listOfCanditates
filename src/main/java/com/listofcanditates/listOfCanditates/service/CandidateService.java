package com.listofcanditates.listOfCanditates.service;

import com.listofcanditates.listOfCanditates.model.Candidate;
import com.listofcanditates.listOfCanditates.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

	private final CandidateRepository candidateRepository;

	@Autowired
	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}

	public List<Candidate> getCandidates() {
		return candidateRepository.findAll();
	}

	public Optional<Candidate> getCandidate(Long id) {
		return candidateRepository.findById(id);
	}

	public void addCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	public void deleteCandidate(Long id) {
		candidateRepository.deleteById(id);
	}

	public List<Candidate> findBySurnameAndInitials(String surname, String initials) {
		return candidateRepository.findBySurnameAndInitials(surname, initials);
	}

	public boolean voteForCandidate(Long id) {
		Optional<Candidate> candidateOpt = candidateRepository.findById(id);
		if(candidateOpt.isPresent()){
			Candidate candidate = candidateOpt.get();
			candidate.setVotes(candidate.getVotes() + 1);
			candidateRepository.save(candidate);
			return true;
		}
		return false;
	}
}
