package io.javabrains.springbootconfig.beanSelectionByProfile;

import io.javabrains.springbootconfig.beanSelectionByProfile.IDataSource;
import org.springframework.stereotype.Repository;

@Repository
// @Profile("test")
public class TestDataSourceBean implements IDataSource
{
    private String name = "Mahesh";
    private int age = 31;

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
        return "TestDataSourceBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
