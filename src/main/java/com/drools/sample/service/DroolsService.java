package com.drools.sample.service;

import com.drools.sample.model.Participant;
import com.drools.sample.model.Rate;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {
    @Autowired
    private KieContainer kieContainer;
    public Rate getRate(Participant applicantRequest) {
        Rate rate = new Rate();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rate",rate);
        kieSession.insert(applicantRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return  rate;
    }
}
