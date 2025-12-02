package com.example.CandidateSystem.Repo;
import com.example.CandidateSystem.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepo extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
