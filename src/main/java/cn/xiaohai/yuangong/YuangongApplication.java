package cn.xiaohai.yuangong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileDescriptor;

@SpringBootApplication
public class YuangongApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(YuangongApplication.class, args);
    }


//    pojo 实体类包
//    什么是pojo 实体类   简单来说就是一个普通的java类  里面有属性  有get set方法  有构造方法  有toString方法等等


    /*
    三层架构
    Controller 控制层  负责接收请求  处理请求  响应请求
    service  业务层  负责业务逻辑  处理业务逻辑
    dao  数据访问层  负责数据访问  处理数据访问   数据库操作  网络操作  文件操作  等等

    比如 开饭店
    Controller  服务员  负责接待客人  处理客人的请求  响应客人的请求
    service  厨师  负责烹饪  处理烹饪的业务逻辑
    dao  采购  负责采购  处理采购的业务逻辑  比如采购食材  采购食材的数量  采购食材的价格  等等


    运行顺序
    Controller 控制层  先运行  再运行  service 业务层  再运行  dao 数据访问层  最后运行
    Dao 返回   Service 返回  Controller 返回  浏览器显示  结束

     */



    /*
    分层解耦
    内聚：软件中的各个元素彼此结合的紧密程度
    耦合：软件中的各个元素之间的相互依赖关系
    软件设计原则: 高内聚  低耦合

    控制层是依赖业务逻辑层
    业务逻辑层依赖数据访问层

    内部联系越紧密 越好


    控制反转： Inversion of Control 简称 IOC。 对象的创建权由原来的程序员转移到了容器中，控制权发生了反转。
    依赖注入： Dependency Injection 简称 DI。 依赖关系由容器负责注入。 依赖关系由容器负责注入。
    Beam对象： IOC 容器中创建、管理的对象。 也称为 Bean 对象。







     */

    /*
要把某个对象交给IOC容器管理 ，需要在对应的类上加上如下注解注解

    Bean的声明
    注解    说明        位置
    @Component  声明Bean的基础注解       不属于以下三种注解
    @Service    声明业务逻辑层Bean       标注在上午类上
    @Controller  声明控制层Bean           标注在控制类上
    @Repository  声明数据访问层Bean       标注在数据访问类上（由于与mybatis整合，用的少）

    注意：
        · 声明brsn的时候，可以通过value属性指定bean的名字，如果没有指定，默认为类名首字母小写。//例如： EmpDao empDao
        · 使用以上四个注解都可以声明bean，但是在springboot 继承web开发中，声明控制器bean只能用@Controller注解。





     */




}




