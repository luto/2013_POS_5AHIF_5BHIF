/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.grueneis.timetable.repositoryjpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration to introduce pure JPA repositories.
 */
@Configuration
@ComponentScan(basePackageClasses = RepositoryJpaPackage.class)
public class RepositoryJpaConfiguration {}
