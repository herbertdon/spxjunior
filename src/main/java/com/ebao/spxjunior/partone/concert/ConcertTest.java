package com.ebao.spxjunior.partone.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dondavid on 17/6/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/application-context.xml")
public class ConcertTest {

    @Resource(name = "concert")
    private Performance concert;

    @Test
    public void testAop(){
        concert.perform();
    }
}
