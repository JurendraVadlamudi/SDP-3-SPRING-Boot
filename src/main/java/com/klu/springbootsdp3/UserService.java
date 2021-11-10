package com.klu.springbootsdp3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository emprepository;

    public String addUserrecord(User emp)
    {
        emprepository.save(emp);
        return "Record Added Successfully\nYour Unique Id is:"+emp.getId();
    }
    public String updateUserrecord(User emp)
    {
        emprepository.save(emp);
        return "Record Updated Successfully";
    }
    public String deleteemprecordbyid(String empid)
    {
        emprepository.deleteById(empid);
        return "Record Deleted Successfully";
    }
    public List<User> getallemprecords()
    {

        return (List<User>) emprepository.findAll();

    }
    public User getemprecordbyid(String id)
    {
        return emprepository.findById(id).get();
    }
}
