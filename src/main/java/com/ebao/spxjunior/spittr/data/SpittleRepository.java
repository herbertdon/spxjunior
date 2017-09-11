package com.ebao.spxjunior.spittr.data;

import com.ebao.spxjunior.spittr.Spittle;

import java.util.List;

/**
 * Created by dondavid on 17/8/30.
 */
public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
	Spittle findOne(long id);
}
