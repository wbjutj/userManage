/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import bio.dao.impl.FeedbackDaoImpl;
import bio.dao.impl.RoleDaoImpl;

/**
 * test for the connection to the database
 * @author fafa
 */
public class Test_Connection {
    public static void main(String[] args) {
        FeedbackDaoImpl dao=new FeedbackDaoImpl();
        System.out.println(dao.viewFeedback("lili").get(0).getFb_description());
//       RoleDaoImpl  dao = new RoleDaoImpl();
//        System.out.println(dao.viewRole("A"));
//        System.out.println(dao.viewSubRole("A"));
//        System.out.println(dao.viewSubAdminRole("A"));
//        System.out.println(dao.viewSubUserRole("A"));
    }
}
