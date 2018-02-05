package com.alex.liman.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.alex.liman.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
