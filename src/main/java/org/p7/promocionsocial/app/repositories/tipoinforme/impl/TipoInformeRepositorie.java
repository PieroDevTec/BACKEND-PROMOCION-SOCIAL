package org.p7.promocionsocial.app.repositories.tipoinforme.impl;

import org.p7.promocionsocial.app.models.TipoInforme;
import org.p7.promocionsocial.app.repositories.error.Log;
import org.p7.promocionsocial.app.repositories.tipoinforme.ITipoInformeRepositorie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoInformeRepositorie implements ITipoInformeRepositorie {
    private JdbcTemplate jdbc;
    public TipoInformeRepositorie(@Qualifier("desa_template") JdbcTemplate pJdbc){
        this.jdbc = pJdbc;
    }

    @Override
    public List<TipoInforme> lista(String codSeguro) {
        String sql = "SELECT CODIGO,NOMBRE FROM sf_list_info_segu(?)";
        try{
            return (List<TipoInforme>)this.jdbc.query(sql,new Object[]{codSeguro}, BeanPropertyRowMapper.newInstance(TipoInforme.class));
        } catch (Exception e) {
            Log.logMessage(e);
            return null;
        }
    }
}
