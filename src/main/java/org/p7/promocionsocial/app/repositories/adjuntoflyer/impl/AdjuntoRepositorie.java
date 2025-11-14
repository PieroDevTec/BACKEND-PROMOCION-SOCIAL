package org.p7.promocionsocial.app.repositories.adjuntoflyer.impl;

import org.p7.promocionsocial.app.models.Adjunto;
import org.p7.promocionsocial.app.repositories.adjuntoflyer.IAdjuntoRepositorie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdjuntoRepositorie implements IAdjuntoRepositorie {
    private JdbcTemplate jdbc;
    public AdjuntoRepositorie(@Qualifier("desa_template") JdbcTemplate pJdbc){
        this.jdbc = pJdbc;
    }
    @Override
    public List<Adjunto> listar(String codFlyer) {
        String sql = "SELECT CODIGO,NOMBRE,DOCUMENTO,URL_DRIVE FROM SF_LIST_ADJU_FLYER(?)";
        try{
            return this.jdbc.query(sql,new Object[]{codFlyer}, BeanPropertyRowMapper.newInstance(Adjunto.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
