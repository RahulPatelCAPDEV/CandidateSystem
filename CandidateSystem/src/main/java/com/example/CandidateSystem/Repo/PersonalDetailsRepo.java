package com.example.CandidateSystem.Repo;
import com.example.CandidateSystem.Model.PersonalDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetailsModel,Integer> {
}
