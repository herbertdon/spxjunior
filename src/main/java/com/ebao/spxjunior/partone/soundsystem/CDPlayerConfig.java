package com.ebao.spxjunior.partone.soundsystem;

import org.springframework.context.annotation.Bean;

//@Configuration
//@ComponentScan
public class CDPlayerConfig {
    @Bean
    public CompactDisc sgtPepper(){
        return new SgtPepper();
    }
}
