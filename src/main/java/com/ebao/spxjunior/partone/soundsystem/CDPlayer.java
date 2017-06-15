package com.ebao.spxjunior.partone.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dondavid on 17/6/15.
 */
public class CDPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }


    public void play() {
        cd.play();
    }
}
