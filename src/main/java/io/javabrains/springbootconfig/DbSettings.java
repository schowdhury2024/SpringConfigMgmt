package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration      // Create a Spring Bean
@ConfigurationProperties("db")  // mention the prefix: Injects anything whose key starts with db. from .properties file(Int, Ext), cmd, sys var
public class DbSettings
{
    // Names have to Match ==> db.connection, db.host, db.port
    private String connection;
    private String host;
    private int port;
    private String values;

    // Must Have Getters & Setters
    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    // toString()

    @Override
    public String toString() {
        return "DbSettings{" +
                "connection='" + connection + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", values='" + values + '\'' +
                '}';
    }
}
