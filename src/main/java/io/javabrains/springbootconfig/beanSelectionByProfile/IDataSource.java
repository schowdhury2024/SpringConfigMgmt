package io.javabrains.springbootconfig.beanSelectionByProfile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


public interface IDataSource
{
    public String getName();
    public int getAge();

}
