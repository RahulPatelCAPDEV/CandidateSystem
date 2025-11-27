package com.example.CandidateSystem.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDetailsdto {

    String Address1;
    int Pincode;
    String LandMark;
    String City;
    String State;
    String Country;
}
