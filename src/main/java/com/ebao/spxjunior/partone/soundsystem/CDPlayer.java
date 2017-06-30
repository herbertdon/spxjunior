package com.ebao.spxjunior.partone.soundsystem;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by dondavid on 17/6/15.
 */
@Component("cdPlayer")
public class CDPlayer implements MediaPlayer{

	@Resource(name = "sgtPepper")
    private CompactDisc cd;

    public void play() {
        cd.play();
    }
}
