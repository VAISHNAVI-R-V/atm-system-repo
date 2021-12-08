package com.bridgelabz.atmsystem.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose : To implement atm-configuration in atm-system Program.
 *
 * @author : VAISHNAVI R. VISHWAKARMA.
 * @since  : 7-12-2021.
 */

@Configuration
public class AtmConfiguration {

        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
}
