package cn.xiaohai.yuangong.Contriller;

import cn.xiaohai.yuangong.html.html;
import cn.xiaohai.yuangong.pojo.Result;
import cn.xiaohai.yuangong.service.EmpService;
import cn.xiaohai.yuangong.service.impl.EmpServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*") // 允许所有来源跨域请求
/*

    CrossOrigin 注解用于处理跨域请求。
    它可以配置允许的请求来源、请求方法、请求头等信息，以控制哪些请求可以被允许跨域访问。
    例如：
    @CrossOrigin(origins = "URL_ADDRESS    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/api/data")
    public String getData() {
        // 处理请求
        return "Hello, World!
    }
    这样，当请求 URL 为 URL_ADDRESS    这样，当请求 URL 为 http://localhost:8080/api/data 时，就会被允许跨域访问。
    注意：
    跨域请求是一种安全机制，它可以防止未经授权的访问。
    因此，在实际开发中，需要谨慎处理跨域请求，确保只有授权的请求可以被允许跨域访问。

 */



@RestController
public class HelloContriller {
    @RequestMapping("/listEmp")
    public Result list(){
        //1. 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        //System.out.println(file);

//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        //重写
        List<Emp> empList = html.parse(file, Emp.class);


        //2. 对数据进行转换处理 - gender, job
        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }



        });
        //3. 响应数据
        return Result.success(empList);
    }





    //业务层对象


    @Autowired
    private EmpService empService;

    @RequestMapping("/")
    public Result index(){
//        调用业务层方法
        List<Emp> empList = empService.listEmp();

        System.out.println("接口被调用了");
        //响应数据
        return Result.success(empList);
    }



//    public Result listEmp(){
//        //加载emp.xml文件
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        //解析xml文件
//        List<Emp> empList = html.parse(file, Emp.class);
//
//        //返回数据
//        return Result.success(empList);
//    }








}






