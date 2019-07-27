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
        entityManagerFactoryRef = "mySqlManagerFactory",
        transactionManagerRef = "mySqlTransactionManager",
        basePackages = {"com.smallking.learninglog.service.impl.mysqlrepository"})
public class MySqlDataSourceConfig {

    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("mySqlDataSource")
    private DataSource dataSource;




    @Bean("mySqlDataSourceTransactionManager")
    public DataSourceTransactionManager mySqlDataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("mySqlSqlSessionFactory")
    public SqlSessionFactory mySqlSqlSessionFactory(@Qualifier("mySqlDataSource") DataSource dataSource) throws Exception{
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);

        return sqlSessionFactory.getObject();
    }

    @Bean(name = "mySqlManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    @Bean(name = "mySqlManagerFactory")
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

    @Bean(name = "mySqlTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}

