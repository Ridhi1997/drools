package com.drools.sample.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Participant {

     private String name;
     private int age;
     private int creditScore;
     private long annualSalary;
     private long existingDebt;
     private long loanAmount;


}
