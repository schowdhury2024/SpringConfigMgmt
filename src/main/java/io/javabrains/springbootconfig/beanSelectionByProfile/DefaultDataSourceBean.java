package io.javabrains.springbootconfig.beanSelectionByProfile;

import io.javabrains.springbootconfig.beanSelectionByProfile.IDataSource;
import org.springframework.stereotype.Repository;


@Repository
public class DefaultDataSourceBean implements IDataSource
{
    private String name = "Shamik";
    private int age = 36;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "DefaultDataSourceBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
