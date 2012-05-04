/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bio.dao.impl.RoleDaoImpl;
import bio.po.Role;

/**
 *
 * @author fafa
 */
public class Test_RoleDao {

    public static void main(String[] args) {
        RoleDaoImpl dao = new RoleDaoImpl();
        if (dao.delRole("A")) {
            //dao.existRole("A")
            System.out.println("delete ok");
        } else {
            System.out.println("start add");
            Role r = new Role("A", "A", 2, "A", "SA");
            if (dao.addRole(r)) {
                System.out.println("add ok");
                dao.addRole(r);
            } else {
                System.out.println("add false");
            }
            System.out.println(dao.viewRole("A"));
            System.out.println(dao.viewSubRole("A"));
            System.out.println(dao.viewSubAdminRole("C"));
            System.out.println(dao.viewSubUserRole("A"));
            System.out.println(dao.viewAllSubRole("A"));
        }
    }
    /*
     以上测试案例说明 delRole（）存在问题
     * 问题为 delRole（String） 返回值 一直为 true 无论是否成功
     * 问题 在于  public boolean executeSQL(String sql) throws Exception 
     */
}
