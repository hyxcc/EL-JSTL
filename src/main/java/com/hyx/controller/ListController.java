package com.hyx.controller;

import com.hyx.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        //将数据放在全局作用域
        ServletContext context = request.getServletContext();
        if(context.getAttribute("employees") == null) {
            List list = new ArrayList();
            Employee emp = new Employee(7731 , "翠花" , "市场部" , "客户经理" , 8500f);
            list.add(emp);
            list.add(new Employee(8871,"王庆","研发部","java工程师",12000f));
            context.setAttribute("employees", list);
        }
        return "/demo/employee.jsp";
    }

    @RequestMapping("/create")
    public String lisdt(Employee employee,HttpServletRequest request, HttpServletResponse response){

        ServletContext context = request.getServletContext();
        List employees = (List)context.getAttribute("employees");
        employees.add(employee);
        context.setAttribute("employees", employees);
        return "/demo/employee.jsp";
    }
}
