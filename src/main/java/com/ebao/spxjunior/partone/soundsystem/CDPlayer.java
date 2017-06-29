package com.ebao.spxjunior.partone.soundsystem;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * Created by dondavid on 17/6/15.
 */
//@Component("cdPlayer")
public class CDPlayer implements MediaPlayer{

//	@Resource(name = "sgtPepper")
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
