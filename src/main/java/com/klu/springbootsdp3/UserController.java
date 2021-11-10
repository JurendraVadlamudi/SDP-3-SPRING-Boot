package com.klu.springbootsdp3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController
{
    @Autowired
    UserService empservice;

    @PostMapping("/User/add")
    @ResponseBody
    public String addemprecord(@RequestBody User emp)
    {
        String id="SDP3"+emp.getStdid();
        emp.setId(id);
        return empservice.addUserrecord(emp);
    }

    @PutMapping("/User/update")
    @ResponseBody
    public String updateemprecord(@RequestBody User emp)
    {
        return empservice.updateUserrecord(emp);
    }

    @DeleteMapping("/User/delete/{empid}")
    @ResponseBody
    public String deleteemprecordbyid(@PathVariable("empid") String id)
    {
        return empservice.deleteemprecordbyid(id);
    }

    @GetMapping("/User/getall")
    @ResponseBody
    public List<User> getallemprecords()
    {
        return empservice.getallemprecords();
    }

    @GetMapping("/User/empbyid/{uid}")
    @ResponseBody
    public User getemprecordbyid(@PathVariable("uid") String id)
    {
        return empservice.getemprecordbyid(id);
    }

}