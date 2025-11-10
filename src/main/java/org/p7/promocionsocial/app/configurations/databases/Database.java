package org.p7.promocionsocial.app.configurations.databases;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Database {

    @Profile("prod")
    @Bean(name = {"prod_datasource"})
    @ConfigurationProperties(prefix = "prod.datasource")
    public DataSource prodDataSource(){
        return DataSourceBuilder.create().build();
    }
    public JdbcTemplate prodTemplate(@Qualifier("prod_datasource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Profile("desa")
    @Bean(name = {"desa_datasource"})
    @ConfigurationProperties(prefix = "desa.datasource")
    public DataSource desaDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = {"desa_template"})
    public JdbcTemplate desaTemplate(@Qualifier("desa_datasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
