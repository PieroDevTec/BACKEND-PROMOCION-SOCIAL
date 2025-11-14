package org.p7.promocionsocial.app.repositories.flyer.impl;

import org.p7.promocionsocial.app.models.Flyer;
import org.p7.promocionsocial.app.repositories.flyer.IFlyerRepositorie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlyerRepositorieImpl implements IFlyerRepositorie {

    private JdbcTemplate jdbc;

    public FlyerRepositorieImpl(@Qualifier("desa_template") JdbcTemplate pJdbc){
        this.jdbc = pJdbc;
    }

    @Override
    public List<Flyer> listar() {
        String sql = "SELECT CODIGO,NOMBRE,IMAGEN,ESTADO FROM SF_LIST_FLYER()";
        try{
            return (List<Flyer>) jdbc.query(sql, BeanPropertyRowMapper.newInstance(Flyer.class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
