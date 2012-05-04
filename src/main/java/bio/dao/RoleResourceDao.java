/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.dao;

import java.util.List;
import bio.po.Resource;

/**
 *
 * @author fafa
 */
public interface RoleResourceDao {

//    boolean delRole(String role_id);   used in RoleDao function delRole(String role_id)

    boolean addRoleResource(String role_id, List<String> resource_id);

    boolean delRoleResource(String role_id, List<String> resource_id);  //级联删除

    List<Resource> viewResources(String role_id);

//    int countResourceRole(String resource_id); used in ResourceDao function  delResource(String resource_id)
    
}
