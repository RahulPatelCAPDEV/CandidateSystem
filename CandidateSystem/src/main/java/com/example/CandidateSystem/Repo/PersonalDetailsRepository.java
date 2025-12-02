package com.example.CandidateSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CandidateSystem.Model.PersonalDetailsModel;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetailsModel, Integer> {
}
