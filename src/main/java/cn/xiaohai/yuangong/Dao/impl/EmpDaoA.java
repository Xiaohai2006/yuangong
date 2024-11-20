package cn.xiaohai.yuangong.Dao.impl;

import cn.xiaohai.yuangong.Contriller.Emp;
import cn.xiaohai.yuangong.Dao.EmpDao;
import cn.xiaohai.yuangong.html.html;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//数据访问层
@Repository
public class EmpDaoA implements EmpDao {


    //获取所有员工信息
    @Override
    public List<Emp> listEmp() {
        //获取emp.xml文件中的路径
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        //使用XmlParserUtils 工具类 解析xml文件
        List<Emp> empList = html.parse(file, Emp.class);
        return empList;



    }














}
