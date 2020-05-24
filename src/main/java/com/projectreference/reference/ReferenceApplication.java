package com.projectreference.reference;

import com.projectreference.reference.springDependency.Triangle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ReferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReferenceApplication.class, args);
        //drawDetails();
    }

    /**
     * Dependency Injection
     * Reading properties from xmlFile
     * Using xmlBeanFactory and ApplicationContext
     */
    public static void drawDetails() {

        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource("springPropeties.xml"));

        //ApplicationContext context = new ClassPathXmlApplicationContext("springPropeties.xml");

        /*ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext("springPropeties.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();*/

        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("springPropeties.xml");

        //this is used to destroy the bean once bean bean
        // initialization in spring  was done
        /**
         * We need to implement InitizlizeBean and DisposableBean
         * to call init and destroy bean
         * BeanPostProcess implementation had methods to
         * perform after bean was initialized
         *
         * BeanFactoryPostProcessor is used to perform action
         * before bean has be intialized
         */
        abstractApplicationContext.registerShutdownHook();

    }

}
