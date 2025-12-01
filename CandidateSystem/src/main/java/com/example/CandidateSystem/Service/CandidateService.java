
package com.example.CandidateSystem.Service;

import com.example.CandidateSystem.Dto.Candidatedto;
import com.example.CandidateSystem.Dto.PersonalDetailsdto;
import com.example.CandidateSystem.Model.CandidateModel;
import com.example.CandidateSystem.Model.PersonalDetailsModel;
import com.example.CandidateSystem.Repo.CandidateRepository;
import com.example.CandidateSystem.Repo.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidaterepo;

    @Autowired
    private PersonalDetailsRepository personalDetailsrepo;


    public Candidatedto createCandidate(Candidatedto dto) {

        CandidateModel candidate = new CandidateModel();
        candidate.setFirstName(dto.getFirstName());
        candidate.setLastName(dto.getLastName());
        candidate.setAge(dto.getAge());
        candidate.setHeight(dto.getHeight());
        candidate.setWeight(dto.getWeight());


        CandidateModel saved = candidaterepo.save(candidate);
        return new Candidatedto(saved.getFirstName(), saved.getLastName(), saved.getAge(), saved.getHeight(), saved.getWeight());

    }


    public Candidatedto getCandidate(Integer id) {
        Optional<CandidateModel> candidate = candidaterepo.findById(id);
        Candidatedto candidatedto = candidate.map(c -> new Candidatedto(c.getFirstName(), c.getLastName(), c.getAge(), c.getHeight(), c.getWeight())).orElse(null);

        return candidatedto;
    }


    public Candidatedto updateCandidate(Integer id, Candidatedto dto) {
        CandidateModel candidate = candidaterepo.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.setFirstName(dto.getFirstName());
        candidate.setLastName(dto.getLastName());
        candidate.setAge(dto.getAge());
        candidate.setHeight(dto.getHeight());
        candidate.setWeight(dto.getWeight());
        CandidateModel updated = candidaterepo.save(candidate);
        return new Candidatedto(updated.getFirstName(), updated.getLastName(), updated.getAge(), updated.getHeight(), updated.getWeight());
    }


    public void deleteCandidate(Integer id) {
        candidaterepo.deleteById(id);
    }


    public PersonalDetailsdto createPersonalDetails(PersonalDetailsdto dto) {
        PersonalDetailsModel details = new PersonalDetailsModel();
        details.setAddress1(dto.getAddress1());
        details.setPincode(dto.getPincode());
        details.setLandMark(dto.getLandMark());
        details.setCity(dto.getCity());
        details.setState(dto.getState());
        details.setCountry(dto.getCountry());
        PersonalDetailsModel saved = personalDetailsrepo.save(details);
        return new PersonalDetailsdto(saved.getAddress1(), saved.getPincode(), saved.getLandMark(), saved.getCity(), saved.getState(), saved.getCountry());
    }


    public PersonalDetailsdto getPersonalDetails(Integer id) {
        Optional<PersonalDetailsModel> details = personalDetailsrepo.findById(id);
        return details.map(d -> new PersonalDetailsdto(d.getAddress1(), d.getPincode(), d.getLandMark(), d.getCity(), d.getState(), d.getCountry())).orElse(null);
    }


    public PersonalDetailsdto updatePersonalDetails(Integer id, PersonalDetailsdto dto) {
        PersonalDetailsModel details = personalDetailsrepo.findById(id).orElseThrow(() -> new RuntimeException("Details not found"));
        details.setAddress1(dto.getAddress1());
        details.setPincode(dto.getPincode());
        details.setLandMark(dto.getLandMark());
        details.setCity(dto.getCity());
        details.setState(dto.getState());
        details.setCountry(dto.getCountry());
        PersonalDetailsModel updated = personalDetailsrepo.save(details);
        return new PersonalDetailsdto(updated.getAddress1(), updated.getPincode(), updated.getLandMark(), updated.getCity(), updated.getState(), updated.getCountry());
    }


    public void deletePersonalDetails(Integer id) {
        personalDetailsrepo.deleteById(id);
    }
}
