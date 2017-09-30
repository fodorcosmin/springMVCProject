//package ro.sci.restaurant;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScans;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * Created by cosmin on 9/26/17.
// */
//@Configuration
//@EnableTransactionManagement
//@ComponentScans(value ={@ComponentScan("ro.sci.restaurant.repository"),
//@ComponentScan("ro.sci.restaurant.service")})
//public class AppConfig {
//
//    @Bean
//    public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
//        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//        factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
//        return factoryBean;
//    }
//
//    @Bean
//    public JpaTransactionManager geJpaTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//}
