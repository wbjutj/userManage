/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;
import bio.dao.impl.*;
import bio.po.Resource;
/**
 *
 * @author fafa
 */
public class Test_ResDao {
    public static void main(String[] args) {
        ResourceDaoImpl dao = new ResourceDaoImpl();
        System.out.println(dao.viewResource("1"));
        System.out.println(dao.viewResource("2"));
        System.out.println(dao.viewResource("23"));
        if(dao.delResource("1")){
            System.out.println("delete OK");
        }else{
            System.out.println("delete failer ");
            Resource res = new Resource("1","1",1);
            dao.addResource(res);
            System.out.println(dao.viewResource("1"));
            RoleResourceDaoImpl rrdao = new RoleResourceDaoImpl();
            rrdao.addRoleResource("A","1");
        }
    }
}
