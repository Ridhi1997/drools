package com.drools.sample.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    private   static final KieServices kieServices = KieServices.Factory.get();
    private  static  final  String CUSTOMER_RULES_DRL = "rules/loan_rate.drl";

    @Bean
    public KieContainer kieContainer(){
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(CUSTOMER_RULES_DRL));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer =  kieServices.newKieContainer(kieModule.getReleaseId());
        return  kieContainer;

    }

}
