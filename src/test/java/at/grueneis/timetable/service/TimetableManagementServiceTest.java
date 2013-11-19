/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.service;

import at.grueneis.timetable.repositoryjpa.RepositoryJpaConfiguration;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Import(value = {RepositoryJpaConfiguration.class, ServiceConfiguration.class})
public class TimetableManagementServiceTest {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Test
    public void aTest() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(TimetableManagementServiceTest
                .class);
        TimetableManagementService timetableManagementService = context.getBean(TimetableManagementService.class);
        Assert.assertNotNull(timetableManagementService);
    }
}
