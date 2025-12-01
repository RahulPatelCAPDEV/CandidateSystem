package com.example.CandidateSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CandidateSystem.Model.CandidateModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateModel, Integer> {
}
