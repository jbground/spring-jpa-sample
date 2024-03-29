//package com.jbground.jpa.config;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
//
//public class DataSourceConfiguration {
//
//    private final static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
//
//    @Autowired
//    private Environment env;
//
//    @Value("${jbground.database.debug}")
//    private boolean debug;
//
//    @Bean(name = "oracle_config")
//    @Primary
//    public HikariConfig oracleConfig() throws Exception{
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName(env.getProperty("com.jbground.oracle.driver-class-name"));
//        hikariConfig.setJdbcUrl(env.getProperty("com.jbground.oracle.url"));
//        hikariConfig.setUsername(env.getProperty("com.jbground.oracle.username"));
//        hikariConfig.setPassword(env.getProperty("com.jbground.oracle.password"));
//        hikariConfig.setPoolName(env.getProperty("com.jbground.oracle.pool-name"));
//        hikariConfig.setMaximumPoolSize(Integer.parseInt(env.getProperty("com.jbground.oracle.maximum-pool-size")));
//        hikariConfig.setMinimumIdle(Integer.parseInt(env.getProperty("com.jbground.oracle.minimum-idle")));
//        hikariConfig.setMaxLifetime(Long.parseLong(env.getProperty("com.jbground.oracle.max-life-time")));
//        hikariConfig.setConnectionTimeout(Long.parseLong(env.getProperty("com.jbground.oracle.connection-timeout")));
//        hikariConfig.setValidationTimeout(Long.parseLong(env.getProperty("com.jbground.oracle.validation-timeout")));
//        hikariConfig.setIdleTimeout(Long.parseLong(env.getProperty("com.jbground.oracle.idle-timeout")));
//        return hikariConfig;
//    }
//
//    @Bean(name = "hikari_oracle")
//    @Primary
//    public DataSource oracle(@Qualifier("oracle_config") HikariConfig hikariConfig) {
//        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
//        logger.info("create oracle hikari datasource");
//        return hikariDataSource;
//    }
//
//    //    @Primary
////    @Bean
////    @ConfigurationProperties(prefix = "spring.datasource")
////    public DataSource getDataSource() throws SQLException {
////        HikariDataSource hikariDataSource = new HikariDataSource();
////        logger.info("create dataSource");
////        logger.info("pool-name         : {}", hikariDataSource.getPoolName());
////        logger.info("driver-class-name : {}", hikariDataSource.getDriverClassName());
////        logger.info("jdbc-url          : {}", hikariDataSource.getJdbcUrl());
////        logger.info("username          : {}", hikariDataSource.getUsername());
////        logger.info("password          : {}", hikariDataSource.getPassword());
////        return hikariDataSource;
////    }
//
//    //    @Bean
////    @Primary
////    public DataSource dataSource() {
////        Map<Object, Object> targetDatasources = new HashMap<Object, Object>() {
////            private static final long serialVersionUID = 4740238371195333169L;
////            {
////                put(DataSourceType.DB1, dataSourceDB1());
////                put(DataSourceType.DB2, dataSourceDB2());
////            }
////        };
////        RoutingDataSource routingDataSource = new RoutingDataSource();
////        routingDataSource.setDefaultTargetDataSource(dataSourceDB1());
////        routingDataSource.setTargetDataSources(targetDatasources);
////        routingDataSource.afterPropertiesSet();
////        return routingDataSource;
////    }
//}
