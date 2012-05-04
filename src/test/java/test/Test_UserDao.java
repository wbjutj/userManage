/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bio.dao.impl.*;
import bio.po.*;

/**
 *
 * @author fafa
 */
public class Test_UserDao {

    public static void main(String[] args) {
        UserSystemDaoImpl dao = new UserSystemDaoImpl();
        UserSystem us = new UserSystem("o","g","5","5","5","5","o","5");
        if(dao.addUser(us)){
        System.out.println("add ok");
        }else{
                System.out.println("add false");
        }
        /*
        System.out.println(dao.viewUser("a"));
        System.out.println(dao.viewSubUsers("b"));
        System.out.println(dao.viewSubUser("a"));
        System.out.println(dao.viewSubAdmin("a"));
        System.out.println(dao.viewSubUser("g"));
         */
        /*
        System.out.println(dao.countSubUser("a"));    
        System.out.println(dao.countSubUser("b"));
        System.out.println(dao.countSubUser("g"));
        System.out.println(dao.countSubUser("f"));

         */
        /*
        if (dao.delUser("a","b") == true) {
        System.out.println("delete ok");
        } else {
        System.out.println("delete false");
        }
        if (dao.delUser("a","i") == true) {
        System.out.println("delete ok");
        } else {
        System.out.println("delete false");
        }
        if (dao.delUser("h","i") == true) {
        System.out.println("delete ok");
        } else {
        System.out.println("delete false");
        }
        if (dao.delUser("e","i") == true) {
        System.out.println("delete ok");
        } else {
        System.out.println("delete false");
        }
         */
    }
}
