/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dao.impl;

import bio.dao.ResourceDao;
import java.util.Map;
import bio.util.DBUtil;
import bio.util.Map2Bean;
import bio.po.Resource;

/**
 *
 * @author fafa
 */
public class ResourceDaoImpl implements  ResourceDao{
    private DBUtil dbutil = new DBUtil();

    public boolean addResource(Resource resource) {
        boolean flag = false;
        String res_id = resource.getRes_id();
        String res_name = resource.getRes_name();
        int res_type = resource.getRes_type();
        String sql = "insert into Resource(res_id,res_name,res_type) values (?,?,?)";
        try {
            Object[] params = new Object[]{res_id, res_name, res_type};
            flag = dbutil.executeSQLwithParams(sql, params);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return flag;
    }

    public boolean delResource(String resource_id) {
        boolean flag = false;
        String sql = "delete  from Resource where res_id='" + resource_id + "'";
        RoleResourceDaoImpl dao = new RoleResourceDaoImpl();
        if (dao.countResourceRole(resource_id) == 0) {
            try {
                flag = dbutil.executeUpdateSQL(sql);
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }else{
           System.out.println("the resource is been used");
        }
        return flag;
    }

    public Resource viewResource(String resource_id) {
        String sql = "select * from Resource where res_id = '" + resource_id+"'";
        Resource resource = new Resource();
        try {
            Map map = dbutil.getUniqueObject(sql);
            resource = (Resource) Map2Bean.convertMapToBean(resource, map);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return resource;
    }

}
