package com.ebao.spxjunior.partone.soundsystem;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	private Map<Integer, Integer> trackMap = new HashMap<Integer, Integer>();
	
	@Pointcut("execution(* com.ebao.spxjunior.partone.soundsystem.CompactDisc.playTrack(int)) " +
			"&& args(trackNumber)")
	public void trackPlayed(int trackNumber){}
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber){
		int currentCount = getPlayCount(trackNumber);
		trackMap.put(trackNumber, currentCount + 1);
		System.out.println("trackNumber:" + trackNumber + " " + trackMap.get(trackNumber) + " times");
	}
	
	public int getPlayCount(int trackNumber){
		return trackMap.containsKey(trackNumber) ? trackMap.get(trackNumber) : 0;
	}
}
