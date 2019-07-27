package com.smallking.learninglog.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @program: learn
 * @description: PostgreSql Mybatis数据源配置
 * @author: smallking
 * @data: 2019-07-27 19:46
 **/

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgreSqlManagerFactory",
        transactionManagerRef = "postgreSqlTransactionManager",
        basePackages = {"com.smallking.learninglog.service.impl.postgresqlrepository"})
public class PostgreSqlDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("postgreSqlDataSource")
    private DataSource dataSource;

    @Primary
    @Bean("postgreSqlDataSourceTransactionManager")
    public DataSourceTransactionManager postgreSqlDataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean("postgreSqlSqlSessionFactory")
    public SqlSessionFactory postgreSqlSqlSessionFactory(@Qualifier("postgreSqlDataSource") DataSource dataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        return sqlSessionFactory.getObject();
    }

    @Primary
    @Bean(name = "postgreSqlManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }
    @Primary
    @Bean(name = "postgreSqlManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .properties(getVendorProperties())
                //设置实体类所在位置
                .packages("com.smallking.learninglog.model")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }
    @Primary
    @Bean(name = "postgreSqlTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}

