package org.p7.promocionsocial.app.repositories.informesadjuntos.impl;

import org.p7.promocionsocial.app.models.dto.TipoAdjunto;
import org.p7.promocionsocial.app.repositories.informesadjuntos.IInfoAdjuRepositorie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class InfoAdjuRepositoriImpl implements IInfoAdjuRepositorie {

    private final JdbcTemplate jdbc;

    public InfoAdjuRepositoriImpl(@Qualifier("desa_template") JdbcTemplate pJdbc){
        this.jdbc = pJdbc;
    }

    @Override
    public List<TipoAdjunto> listar() {
        try{
            String sql = "SELECT CODIGO,NOMBRE,ESTADO FROM SF_LIST_TIPO_ADJU()";
            return (List<TipoAdjunto>) jdbc.query(sql,BeanPropertyRowMapper.newInstance(TipoAdjunto.class));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
