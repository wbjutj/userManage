/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author wj
 */
import bio.po.Feedback;
import bio.dao.impl.FeedbackDaoImpl;
import java.util.Date;
public class test_FeedbackDao {
     public static void main(String[] args) {
        FeedbackDaoImpl dao = new FeedbackDaoImpl();
        Date d=new Feedback().toDate("2011-12-01");
        Date d1=new Feedback().toDate("2011-12-26");
        System.out.println("here..........");
        Feedback us = new Feedback("fb1","lili",d,"fine");
        if(dao.addFeedback(us)){
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
