package com.startnet.cqj.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by ztt on 2017-07-31.
 */
@SpringBootApplication
@MapperScan("com.startnet.cqj.test.dao")
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return new DataSource();
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = resolver();
        MybatisProperties mybatisProperties = mybatisProperties();
        bean.setConfigLocation(resolver.getResource(mybatisProperties.getConfigLocation()));
        bean.setMapperLocations(resolver.getResources(mybatisProperties.getMapperLocations()[0]));
        return bean.getObject();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix="mybatis")
    public MybatisProperties mybatisProperties(){
        return new MybatisProperties();
    }

    @Bean
    public PathMatchingResourcePatternResolver resolver(){
        return new PathMatchingResourcePatternResolver();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8088);
    }
}
