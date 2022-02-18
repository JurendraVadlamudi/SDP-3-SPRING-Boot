package com.klu.springbootsdp3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    UserRepository emprepository;

    public Result addUserrecord(User emp)
    {
        emprepository.save(emp);
        Result res=new Result();
        res.setRes("Record Added Successfully\nYour Unique Id is:"+emp.getId());
        return res;
        }
    public Result updateUserrecord(User emp)
    {Result res=new Result();
    String id=emp.getId();
    String mobile=emp.getMobile();
    String mail=emp.getEmail();
    try{
    User u= (User) emprepository.findById(id).get();
    //System.out.println(u.getId()+"    "+u.getPassword()+"    "+id+"     "+password);
    if(u.getId().equals(id)&&u.getMobile().equals(mobile)&&u.getEmail().equals(mail)){
    	emprepository.save(emp);
    	res.setRes("Updated");
    }
    else{
        res.setRes("NotFound");
    }
    }
    catch (Exception e){
 res.setRes("NotFound");
    }
    return res;

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

    public Result loginCheck(String id,String password)
    { Result res=new Result();
        try{
        User u= (User) emprepository.findById(id).get();
        System.out.println(u.getId()+"    "+u.getPassword()+"    "+id+"     "+password);
        if(u.getId().equals(id)&&u.getPassword().equals(password)){
            res.setRes(id);
        }
        else{
            res.setRes("NotFound");
        }
        }
        catch (Exception e){
     res.setRes("NotFound");
        }
        return res;
    }

    public String bmi(){
        String html="\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<!-- Include JS files -->\n" +
                "<script>\n" +
                "window.onload = () => {\n" +
                "\tlet button = document.querySelector(\"#btn\");\n" +
                "\n" +
                "\t// Function for calculating BMI\n" +
                "\tbutton.addEventListener(\"click\", calculateBMI);\n" +
                "};\n" +
                "\n" +
                "function calculateBMI() {\n" +
                "\n" +
                "\t/* Getting input from user into height variable.\n" +
                "\tInput is string so typecasting is necessary. */\n" +
                "\tlet height = parseInt(document\n" +
                "\t\t\t.querySelector(\"#height\").value);\n" +
                "\n" +
                "\t/* Getting input from user into weight variable.\n" +
                "\tInput is string so typecasting is necessary.*/\n" +
                "\tlet weight = parseInt(document\n" +
                "\t\t\t.querySelector(\"#weight\").value);\n" +
                "\n" +
                "\tlet result = document.querySelector(\"#result\");\n" +
                "\n" +
                "\t// Checking the user providing a proper\n" +
                "\t// value or not\n" +
                "\tif (height === \"\" || isNaN(height))\n" +
                "\t\tresult.innerHTML = \"Provide a valid Height!\";\n" +
                "\n" +
                "\telse if (weight === \"\" || isNaN(weight))\n" +
                "\t\tresult.innerHTML = \"Provide a valid Weight!\";\n" +
                "\n" +
                "\t// If both input is valid, calculate the bmi\n" +
                "\telse {\n" +
                "\n" +
                "\t\t// Fixing upto 2 decimal places\n" +
                "\t\tlet bmi = (weight / ((height * height)\n" +
                "\t\t\t\t\t\t\t/ 10000)).toFixed(2);\n" +
                "\n" +
                "\t\t// Dividing as per the bmi conditions\n" +
                "\t\tif (bmi < 18.6) result.innerHTML =\n" +
                "\t\t\t`Under Weight : <span>${bmi}</span>`;\n" +
                "\n" +
                "\t\telse if (bmi >= 18.6 && bmi < 24.9)\n" +
                "\t\t\tresult.innerHTML =\n" +
                "\t\t\t\t`Normal : <span>${bmi}</span>`;\n" +
                "\n" +
                "\t\telse result.innerHTML =\n" +
                "\t\t\t`Over Weight : <span>${bmi}</span>`;\n" +
                "\t}\n" +
                "}\n" +
                "</script>\n" +
                "<style type=\"text/css\">\n" +
                "\tbody\n" +
                "{\n" +
                "\tbackground-image: url('https://wallpaperaccess.com/full/488907.jpg');\n" +
                "\tbackground-repeat: no-repeat;\n" +
                "  background-attachment: fixed;  \n" +
                "  background-size: cover;\n" +
                "}\n" +
                "\t.container\n" +
                "{\n" +
                "\tposition:absolute;\n" +
                "\ttop:50%;\n" +
                "\tleft:50%;\n" +
                "\ttransform: translate(-50%, -50%);\n" +
                "\twidth:350px;\n" +
                "\theight:380px;\n" +
                "\tpadding:40px 40px;\n" +
                "\tborder-radius: 25px;\n" +
                "\tbox-sizing: border-box;\n" +
                "\tbackground:rgba(0,0,0,0.5) ;\n" +
                "\t\n" +
                "}\n" +
                "#result{\n" +
                "\ttext-align: center;\n" +
                "}\n" +
                ".container button\n" +
                "{\n" +
                "\tborder:none;\n" +
                "\toutline:none;\n" +
                "\theight: 40px;\n" +
                "\tcolor:#fff;\n" +
                "\tfont-size:16px;\n" +
                "\tbackground: rgb(255,38,126);\n" +
                "\tcursor:pointer;\n" +
                "\tborder-radius:20px;\n" +
                "}\n" +
                ".container button:hover\n" +
                "{\n" +
                "\tbackground: #efed40;\n" +
                "\tcolor: #262626;\n" +
                "}\n" +
                ".btn {\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".button {\n" +
                "    position: absolute;\n" +
                "    top: 50%;\n" +
                "}\n" +
                "#height,#weight{\n" +
                "\tborder: none;\n" +
                "  outline: none;\n" +
                "  background: none;\n" +
                "  color: white;\n" +
                "  font-size: 18px;\n" +
                "  width: 100%;\n" +
                "  overflow: hidden;\n" +
                "  font-size: 20px;\n" +
                "  padding: 8px 0;\n" +
                "  margin: 10px 0;\n" +
                "  border-bottom: 1px solid #4caf50;\n" +
                "}\n" +
                "/*#height input{\n" +
                "  border: none;\n" +
                "  outline: none;\n" +
                "  background: none;\n" +
                "  color: white;\n" +
                "  font-size: 18px;\n" +
                "  width: 80%;\n" +
                "  float: left;\n" +
                "  margin: 0 10px;\n" +
                "}*/\n" +
                "::placeholder\n" +
                "{\n" +
                "\tcolor:rgba(255,255,255,0.5); \n" +
                "\tfont-size: 15px;\n" +
                "}\n" +
                ".icon\n" +
                "{\n" +
                "\twidth:100px;\n" +
                "\theight:100px; \n" +
                "\toverflow:hidden;\n" +
                "\tposition:absolute;\n" +
                "\ttop:calc(-100px/2);\n" +
                "\tleft:calc(50% - 50px);\n" +
                "\tborder-radius:50%;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\t<div class=\"container\">\n" +
                "\t\t<img src=\"https://cdn2.iconfinder.com/data/icons/ios7-inspired-mac-icon-set/512/Calculator_512.png\" class=\"icon\">\n" +
                "\t\t<h1 style=\"text-align: center;\">BMI Calculator</h1>\n" +
                "\t\t<table>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td><p style=\"font-size: 18px;\"><b>Height (in cm)</b></p></td>\n" +
                "\t\t<td><input type=\"text\" id=\"height\" placeholder=\"Enter Your Height\"></td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t <td><p style=\"font-size: 18px;\"><b>Weight (in kg)</b></p></td>\n" +
                "\t\t<td><input type=\"text\" id=\"weight\" placeholder=\"Enter Your Weight\"></td>\n" +
                "\t\t</tr>\n" +
                "\t</table><div class=\"btn\">\n" +
                "\t\t<button id=\"btn\">Calculate</button>\n" +
                "\t\t</div>\n" +
                "\t\t<br>\n" +
                "\t\t<b><div id=\"result\" style=\"font-size: 18px; color: white;\"></div></b>\n" +
                "\t</div>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
        return  html;
    }

}
