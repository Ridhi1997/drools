package com.drools.sample.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Rate {
    private String loanStatus;
    private double loanRate;
}
