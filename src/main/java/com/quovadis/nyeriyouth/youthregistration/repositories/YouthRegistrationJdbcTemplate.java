package com.quovadis.nyeriyouth.youthregistration.repositories;

import com.quovadis.nyeriyouth.youthregistration.models.Youth;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class YouthRegistrationJdbcTemplate {
    JdbcTemplate jdbcTemplate;

    public YouthRegistrationJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    private List<Youth> youthList = new ArrayList<>();
    public List<Youth> getYouthByParishId(Integer parishId){
        String sql = "SELECT * FROM Youth WHERE parish_id = ?";
        youthList = jdbcTemplate.query(sql, new Object[]{parishId},new YouthRowMapper());
        return youthList;
    }

    public void deleteYouthByCertOrIdNumber(String idOrBirthCertNumber){
        String sql = "DELETE FROM Youth WHERE id_or_birth_cert_number = ?";
        jdbcTemplate.update(sql, idOrBirthCertNumber);
    }

    public boolean validateUser(String username, String password, String userType) {
        String sql = "SELECT password, user_role FROM Userr WHERE username = ?";
        try {
            LoginUser user = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                String storedPassword = rs.getString("password");
                String role = rs.getString("user_role");

                return new LoginUser(storedPassword, role);
            }, username);

            // Check if the provided password matches the stored password
            if ("admin".equals(userType)){
                return user != null && password.equals(user.getStoredPassword()) && "super_admin".equalsIgnoreCase(user.getRole());
            }else {
                return user != null && password.equals(user.getStoredPassword()) && "parish_admin".equalsIgnoreCase(user.getRole());
            }
        } catch (EmptyResultDataAccessException e) {
            // Handle invalid username
            return false;
        }
    }

    public boolean checkIfExists(String idNumber) {
        String sql = "SELECT id_or_birth_cert_number FROM Youth WHERE id_or_birth_cert_number = ?";
        return true;
    }
}
 class LoginUser {
    private String storedPassword;
    private String role;

    public LoginUser(String storedPassword, String role) {
        this.storedPassword = storedPassword;
        this.role = role;
    }

     LoginUser() {
     }

     public String getStoredPassword() {
        return storedPassword;
    }

    public String getRole() {
        return role;
    }
}
 class YouthRowMapper implements RowMapper<Youth> {
    @Override
    public Youth mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Youth(
                rs.getInt("serial_number"),
                rs.getString("full_name"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("phone_number"),
                rs.getString("gender"),
                rs.getString("id_or_birth_cert_number"),
                rs.getString("local_church_name"),
                rs.getString("small_christian_community_name"),
                rs.getInt("parish_id"),
                rs.getInt("deanery_id"),
                rs.getBoolean("baptized"),
                rs.getBoolean("received_holy_communion"),
                rs.getBoolean("confirmation"),
                rs.getBoolean("married")
        );
    }
}
