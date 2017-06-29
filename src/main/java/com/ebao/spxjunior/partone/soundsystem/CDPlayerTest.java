package com.ebao.spxjunior.partone.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=CDPlayerConfig.class)
@ContextConfiguration("classpath*:/application-context.xml")
public class CDPlayerTest {

  @Resource(name = "sgtPepper")
  private CompactDisc cd;

/*  @Resource(name = "cdPlayer")
  private MediaPlayer cdPlayer;*/

  @Resource(name = "blankDisk")
  private CompactDisc blankDisk;

//  @Test
  public void cdShouldNotBeNull(){
    assertNotNull(cd);
  }

/*  @Test
  public void play(){
    cdPlayer.play();
  }*/

  @Test
  public void testAopWithArgs(){
    blankDisk.playTrack(1);
  }
  
 /* public static void main(String[] args){
	  
  }*/
}