package com.ebao.spxjunior.partone.concert;

import org.springframework.stereotype.Component;

/**
 * Created by dondavid on 17/6/28.
 */
@Component("concert")
public class Concert implements Performance {
    public void perform() {
        System.out.println("Performing concert!");
    }
}
