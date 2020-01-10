package com.mohammad.banking;

import com.mohammad.banking.service.ITransferServiceRemote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@SpringBootApplication
public class BankingClientApplication {

    public static void main(String[] args) {
         SpringApplication.run(BankingClientApplication.class, args);
    }
}


@Configuration
class MyConfiguration {
    @Bean
    public Context context() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        jndiProps.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        jndiProps.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        jndiProps.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        jndiProps.put("org.omg.CORBA.ORBInitialPort", "3700");
        return new InitialContext(jndiProps);
    }

    @Bean
    public ITransferServiceRemote transferServiceRemote(Context context) throws NamingException {
        return (ITransferServiceRemote) context.lookup("BankingService");
    }

}