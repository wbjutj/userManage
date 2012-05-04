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
public class Test_RoleRes {

    public static void main(String[] args) {
        RoleResourceDaoImpl dao = new RoleResourceDaoImpl();
        if (dao.delRoleResource("B", "8")){
            System.out.println("delete OK");
        }else{
            System.out.println("delete failer");
        }
        /*
        System.out.println(dao.viewResources("D"));
        if (dao.delRole("E")) {
            System.out.println(dao.countResourceRole("8"));
            if (dao.delRoleResource("B", "8"));
            System.out.println(dao.countResourceRole("8"));
            System.out.println("delete OK");
        } else {
            System.out.println(dao.viewResources("D"));
            dao.addRoleResource("E", "1");
            dao.addRoleResource("E", "12");
            dao.addRoleResource("E", "8");
            dao.addRoleResource("E", "9");
            dao.addRoleResource("E", "10");
            System.out.println(dao.countResourceRole("8"));
            if (dao.delRoleResource("B", "8"));
            System.out.println(dao.countResourceRole("8"));
            System.out.println("delete failer");
        }
         *
         */
    }
}
