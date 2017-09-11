package com.ebao.spxjunior.spittr.data;

import com.ebao.spxjunior.spittr.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dondavid on 17/9/6.
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository{
  private JdbcOperations jdbc;
  @Autowired
  public JdbcSpittleRepository(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  @Override public List<Spittle> findSpittles(long max, int count) {
    return jdbc.query(
        "select id, message, created_at, latitude, longitude" +
            " from Spittle" +
            " where id < ?" +
            " order by created_at desc limit 20",
        new SpittleRowMapper(), max);
  }

  private static class SpittleRowMapper implements RowMapper<Spittle> {
    public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Spittle(
          rs.getLong("id"),
          rs.getString("message"),
          rs.getDate("created_at"),
          rs.getDouble("longitude"),
          rs.getDouble("latitude"));
    }
  }

  public Spittle findOne(long id) {
    return jdbc.queryForObject(
        "select id, message, created_at, latitude, longitude" +
            " from Spittle" +
            " where id = ?",
        new SpittleRowMapper(), id);
  }

}
