package cn.xiaohai.yuangong.service.impl;

import cn.xiaohai.yuangong.Contriller.Emp;
import cn.xiaohai.yuangong.Dao.EmpDao;
import cn.xiaohai.yuangong.Dao.impl.EmpDaoA;
import cn.xiaohai.yuangong.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
/*
    Component 将当前对象交给IOC容器管理，成为IOC容器的bean




    Component 注解用于将一个类标记为 Spring 容器中的一个 Bean。
    它可以将一个类的实例化交给 Spring 容器来管理，从而实现依赖注入。
    例如：
    @Component
    public class UserService {
        // 业务逻辑
    }
    这样，当需要使用 UserService 类时，Spring 容器会自动创建一个 UserService 的实例，并将其注入到需要使用的地方。
    注意：
    Component 注解可以用于标记任何类，包括接口、抽象类、普通类等。
    同时，Component 注解也可以通过 @ComponentScan 注解来自动扫描并注册 Bean。

 */
@Service
/*
要把某个对象交给IOC容器管理 ，需要在对应的类上加上如下注解注解

    Service 注解用于将一个类标记为 Spring 容器中的一个 Bean。
    它可以将一个类的实例化交给 Spring 容器来管理，从而实现依赖注入。
    例如：
    @Service
    public class UserService {
        // 业务逻辑
    }
    这样，当需要使用 UserService 类时，Spring 容器会自动创建一个 UserService 的实例，并将其注入到需要使用的地方。
    注意：
    Service 注解可以用于标记任何类，包括接口、抽象类、普通类等。
    同时，Service 注解也可以通过 @ComponentScan 注解来自动扫描并注册 Bean。

 */
public class EmpServiceA implements EmpService {
    //dao层对象
    @Autowired
    /*
    Autowired 注解用于自动装配 Bean。
    Autowired 运行时，从IOC容器中获取该类型对象，并赋值给当前对象。

     */
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        //调用dao层方法
        List<Emp> list = empDao.listEmp();
        //处理集合
        for (Emp emp:list) {
            //处理性别
            if (emp.getGender().equals("1")){
                emp.setGender("男");
            }else {
                emp.setGender("女");
            }

            //处理职业
            if (emp.getJob().equals("1")){
                emp.setJob("讲师");
            }else if (emp.getJob().equals("2")){
                emp.setJob("班主任");
            }else {
                emp.setJob("就业指导");
            }

        }


        //返回结果



        return list;


    }

}
