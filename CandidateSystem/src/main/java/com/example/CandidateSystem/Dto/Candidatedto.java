package com.example.CandidateSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidatedto {

    String FirstName;
    String LastName;
    int Age;
    double Height;
    double Weight;
}
