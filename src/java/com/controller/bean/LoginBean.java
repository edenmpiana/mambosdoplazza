/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.bean;

import com.dao.LoginDao;
import com.model.pojo.User;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author mariompi
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    User user = new User ();
    LoginDao ld = new LoginDao();
    boolean result;
    public String checkUser()
    {
        FacesMessage message = null;
       
        result = ld.checkUserDao(user.getUsername(), user.getPassword());
        
        if(result == true) 
        {
           
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo", user.getUsername());
            return "Sucess.xhtml";
        }
        else  
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "";
        
        
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginDao getLd() {
        return ld;
    }

    public void setLd(LoginDao ld) {
        this.ld = ld;
    }
    
}
