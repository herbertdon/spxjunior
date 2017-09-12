package com.ebao.spxjunior.spittr.data;

import com.ebao.spxjunior.spittr.Spitter;

/**
 * Created by dondavid on 17/9/11.
 */
public interface SpitterRepository {
  Spitter save(Spitter spitter);
  Spitter findByUsername(String username);
}
