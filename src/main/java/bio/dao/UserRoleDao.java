/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao;

import java.util.List;
import bio.po.Role;

/**
 *
 * @author fafa
 */
public interface UserRoleDao {

 //   boolean delUser(String user_id);

//    String viewUserRole(String user_id);

 //   int countUser(String role_id);    used in RoleDao function delRole(String role_id)

    Role viewRole(String user_id);
    
    List<Role> viewSubRole(String user_id);

    List<Role> viewSubAdminRole(String user_id);

    List<Role> viewSubUserRole(String user_id);

    boolean addUserRole(String user_id, String child_user_id, String role_id);//first add
    
    boolean modUserRole(String user_id, String child_user_id, String newroleid);// modify
}
