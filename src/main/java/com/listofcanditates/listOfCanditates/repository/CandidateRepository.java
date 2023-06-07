package com.listofcanditates.listOfCanditates.repository;

import com.listofcanditates.listOfCanditates.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findBySurnameAndInitials(String surname, String initials);
}
