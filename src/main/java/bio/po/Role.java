/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.po;

/**
 *
 * @author fafa
 */
public class Role {

    String role_id;
    String role_name;
    int role_type;
    String role_description;
    String role_father_id;
    public Role(String role_id,String role_name,int role_type,String role_description,String role_father_id){
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_father_id = role_father_id;
        this.role_type = role_type;
        this.role_description = role_description;
    }
    public Role(){}
    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getRole_type() {
        return role_type;
    }

    public void setRole_type(int role_type) {
        this.role_type = role_type;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public String getRole_father_id() {
        return role_father_id;
    }

    public void setRole_father_id(String role_father_id) {
        this.role_father_id = role_father_id;
    }
    public String toString(){
        String str=null;
        str = role_id+" "+role_name +" "+role_type +" " +role_father_id+" "+ role_description  ;
        return  str;
    }
    public boolean isFatherRole(Role role){
       boolean flag = false;
       if(role_id.equals(role.getRole_father_id()))
           flag = true;
       return flag;
    }
}
