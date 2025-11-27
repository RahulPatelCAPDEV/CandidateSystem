package com.example.CandidateSystem.Repo;
import com.example.CandidateSystem.Model.CandiateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<CandiateModel,Integer> {

}