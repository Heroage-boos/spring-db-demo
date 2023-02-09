package org.example;

import org.example.entity.Nation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
        //new UserEntity()
        // 1.读取xml配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 2.根据bean的id获取bean对象
        Nation Nation = classPathXmlApplicationContext.getBean("userEntity", org.example.entity.Nation.class);
        System.out.println(Nation);
        Nation.addNation();
    }

}
