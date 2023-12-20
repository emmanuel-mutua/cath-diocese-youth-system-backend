package com.quovadis.nyeriyouth.youthregistration.repositories;

import com.quovadis.nyeriyouth.youthregistration.models.Parish;
import com.quovadis.nyeriyouth.youthregistration.models.Youth;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ParishRepoJdbcTemplate {
    JdbcTemplate jdbcTemplate;
    public ParishRepoJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Parish> parishes = new ArrayList<>();

    public List<Parish> findAllByDeaneryId(Integer deaneryId) {
        String sql = "SELECT * FROM Parish WHERE deanery_id = ?";
        parishes = jdbcTemplate.query(sql, new Object[]{deaneryId},new ParishRowMapper());
        return parishes;
    }
}
class ParishRowMapper implements RowMapper<Parish> {
    @Override
    public Parish mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Parish(
                rs.getInt("parish_id"),
                rs.getInt("deanery_id"),
                rs.getString("parish_name")
        );
    }
}
