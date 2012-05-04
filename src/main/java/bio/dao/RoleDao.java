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
public interface RoleDao {
    boolean  addRole(Role role);
    boolean  delRole(String role_id);
//    boolean   existRole(String role_id);
    Role    viewRole(String role_id);
//    List<Role>   viewSubRole(String role_id);    used in UserSystemDao
//    List<Role>   viewSubAdminRole(String role_id);  used in UserSystemDao
//    List<Role>   viewSubUserRole(String role_id);  used in UserSystemDao 

//    List<Role>   viewAllSubRole(String role_id);
}
