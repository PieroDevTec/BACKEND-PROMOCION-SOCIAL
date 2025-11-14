package org.p7.promocionsocial.app.repositories.seguro.impl;

import org.p7.promocionsocial.app.models.Seguro;
import org.p7.promocionsocial.app.repositories.seguro.ISeguroRepositorie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeguroRepositorieImpl implements ISeguroRepositorie {

    private JdbcTemplate jdbcTemplate;

    public SeguroRepositorieImpl(@Qualifier("desa_template") JdbcTemplate pJdbc){
        this.jdbcTemplate = pJdbc;
    }

    @Override
    public List<Seguro> listar() {
        String sql = "SELECT CODIGO,NOMBRE,IMAGEN FROM sf_list_segu()";
        try{
            return (List<Seguro>) this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Seguro.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
