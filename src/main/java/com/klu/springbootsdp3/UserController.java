package com.klu.springbootsdp3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController
{
    @Autowired
    UserService empservice;

    @PostMapping("/User/add")
    @ResponseBody
    @CrossOrigin
    public Result addemprecord(@RequestBody User emp)
    {
        String id="SDP3"+emp.getStdid();
        emp.setId(id);
        return empservice.addUserrecord(emp);
    }

    @PutMapping("/User/update")
    @ResponseBody
    public Result updateemprecord(@RequestBody User emp)
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
    @CrossOrigin
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


    @PostMapping("/User/login")
    @ResponseBody
    @CrossOrigin
    public Result checkLogin(@RequestBody User emp)
    {
        Result res=empservice.loginCheck(emp.getId(),emp.getPassword());
    System.out.println(res.getRes());
    return res;
    }

    @GetMapping("/User/bmi")
    @ResponseBody
    @CrossOrigin
    public String checkLogin()
    {
        return empservice.bmi();
    }


}