package com.example.CandidateSystem.Controller;


import com.example.CandidateSystem.Dto.Candidatedto;
import com.example.CandidateSystem.Dto.PersonalDetailsdto;
import com.example.CandidateSystem.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController     
@RequestMapping("/Candidate")
public class CandidateSystemContoller {

    @Autowired
    private CandidateService  candidateservice;


    @PostMapping("/add/candidate")
    public ResponseEntity<Candidatedto> CreateCandidateDetails(@RequestBody Candidatedto candidatedto){
        Candidatedto candidatedto1 = candidateservice.createCandidate( candidatedto );
        return ResponseEntity.status(HttpStatus.CREATED).body(candidatedto1);
    }

    @PostMapping("/add/personal")
    public ResponseEntity<PersonalDetailsdto> CreatePersonalDetails(@RequestBody PersonalDetailsdto personalDetailsdto){
        PersonalDetailsdto personalDetailsdto1  = candidateservice.createPersonalDetails(personalDetailsdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(personalDetailsdto1);
    }

    @GetMapping("/get/personal")
    public ResponseEntity<PersonalDetailsdto> GetPersonalDetails(@RequestParam Integer id){
        PersonalDetailsdto personalDetailsdto = candidateservice.getPersonalDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(personalDetailsdto);
    }

    @GetMapping("/get/candidate")
    public ResponseEntity<?> GetCandidateDetails(@RequestParam Integer id){
       Candidatedto candidatedto = candidateservice.getCandidate(id);
       return ResponseEntity.status(HttpStatus.OK).body(candidatedto);
    }

    @DeleteMapping("/delete/candidate")
    public ResponseEntity<?> DeleteCandidateDetails(@RequestParam Integer id){
        candidateservice.deleteCandidate(id);
      return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/delete/personal")
    public ResponseEntity<?> DeletePersonalDetails(@RequestParam Integer id){
        candidateservice.deletePersonalDetails(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update/candidate")
    public ResponseEntity<Candidatedto> UpdateCandidateDetails(@RequestParam Integer id, @RequestBody Candidatedto candidatedto){
        candidateservice.updateCandidate(id, candidatedto);
        return ResponseEntity.status(HttpStatus.OK).body(candidatedto);
    }

    @PutMapping("/update/personal")
    public ResponseEntity<PersonalDetailsdto> UpdatePersonalDetails(@RequestParam Integer id ,@RequestBody PersonalDetailsdto personalDetailsdto){
        candidateservice.updatePersonalDetails(id, personalDetailsdto);
        return ResponseEntity.status(HttpStatus.OK).body(personalDetailsdto);
    }


}
