/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dao;
import java.util.List;
import  bio.po.Operation;
/**
 *
 * @author fafa
 */

public interface RoleOperationDao {
 //   boolean  delRole(String role_id);  used in the RoleDao function delRole(String role_id)
 //   boolean  delOpration(String opration_id); used in the Operation function  delOpration(String opration_id)
    boolean  addRoleOperations(String role_id, List<String> opration_id);
    boolean  delRoleOperations(String role_id, List<String> opration_id);
    List<Operation> viewOperations(String role_id);
}
/*



 * */
