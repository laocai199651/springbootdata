package com.cwk.springbootdata01.springbootdata.mapper;


import com.cwk.springbootdata01.springbootdata.bean.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
