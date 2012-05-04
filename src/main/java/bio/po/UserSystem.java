/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.po;

/**
 *
 * @author fafa
 */
public class UserSystem {

    String usr_id;
    String usr_father_id;
    String usr_cluster_uid;
    String usr_cluster_gid;
    String usr_cluster_account;
    String usr_cluster_passwd;
    String usr_cluster_datapath;
    String usr_status;
    public UserSystem(){}
    public UserSystem( String usr_id, String usr_father_id, String usr_cluster_uid, String usr_cluster_gid,
    String usr_cluster_account,String usr_cluster_passwd,String usr_cluster_datapath,String usr_status){
    this.usr_id = usr_id;
    this.usr_father_id = usr_father_id;
    this.usr_cluster_uid = usr_cluster_uid;
    this.usr_cluster_gid = usr_cluster_gid;
    this.usr_cluster_account = usr_cluster_account;
    this.usr_cluster_passwd = usr_cluster_passwd;
    this.usr_cluster_datapath =  usr_cluster_datapath;
    this.usr_status = usr_status;
    }
    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_father_id() {
        return usr_father_id;
    }

    public void setUsr_father_id(String usr_father_id) {
        this.usr_father_id = usr_father_id;
    }

    public String getUsr_cluster_uid() {
        return usr_cluster_uid;
    }

    public void setUsr_cluster_uid(String usr_cluster_uid) {
        this.usr_cluster_uid = usr_cluster_uid;
    }

    public String getUsr_cluster_gid() {
        return usr_cluster_gid;
    }

    public void setUsr_cluster_gid(String usr_cluster_gid) {
        this.usr_cluster_gid = usr_cluster_gid;
    }

    public String getUsr_cluster_account() {
        return usr_cluster_account;
    }

    public void setUsr_cluster_account(String usr_cluster_account) {
        this.usr_cluster_account = usr_cluster_account;
    }

    public String getUsr_cluster_passwd() {
        return usr_cluster_passwd;
    }

    public void setUsr_cluster_passwd(String usr_cluster_passwd) {
        this.usr_cluster_passwd = usr_cluster_passwd;
    }

    public String getUsr_cluster_datapath() {
        return usr_cluster_datapath;
    }

    public void setUsr_cluster_datapath(String usr_cluster_datapath) {
        this.usr_cluster_datapath = usr_cluster_datapath;
    }

    public String getUsr_status() {
        return usr_status;
    }

    public void setUsr_status(String usr_status) {
        this.usr_status = usr_status;
    }
    public String toString(){
        String str=null;
        str = usr_id+" "+usr_father_id +" "+usr_cluster_uid +" " +usr_cluster_gid+" "+
                usr_cluster_account+" " +usr_cluster_passwd+" "+usr_cluster_datapath+" "+usr_status ;
        return  str;
    }
    public boolean  isFatherUser(UserSystem us){
        boolean flag = false;
        if(usr_id.equals(us.getUsr_father_id()))
             flag = true;
        return  flag;
    }
}
