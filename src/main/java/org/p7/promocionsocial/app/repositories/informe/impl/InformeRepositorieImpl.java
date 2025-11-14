package org.p7.promocionsocial.app.repositories.informe.impl;

import org.p7.promocionsocial.app.models.Informe;
import org.p7.promocionsocial.app.repositories.error.Log;
import org.p7.promocionsocial.app.repositories.informe.IInformeRepositorie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InformeRepositorieImpl implements IInformeRepositorie {

    private JdbcTemplate jdbc;
    public InformeRepositorieImpl(@Qualifier("desa_template") JdbcTemplate pJdbc){
        this.jdbc = pJdbc;
    }

    @Override
    public List<Informe> listar(String codSeguro, String codTipoInforme) {
        String sql = "SELECT CODIGO,NOMBRE FROM sf_list_informes(?,?)";
        try{
            return (List<Informe>) this.jdbc.query(sql,new Object[]{codSeguro,codTipoInforme}, BeanPropertyRowMapper.newInstance(Informe.class));
        }catch (Exception e){
            Log.logMessage(e);
            return null;
        }
    }
}
