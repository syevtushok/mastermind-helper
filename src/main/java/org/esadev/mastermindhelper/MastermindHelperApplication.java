package org.esadev.mastermindhelper;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@RequiredArgsConstructor
public class MastermindHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MastermindHelperApplication.class, args);
    }

}
