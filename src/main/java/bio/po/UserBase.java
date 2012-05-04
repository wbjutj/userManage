/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.po;

/**
 *
 * @author fafa
 */
public class UserBase {

    public String getUsr_id() {
        return usr_id;
    }

    public String getUsr_account() {
        return usr_account;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public int getUsr_pri_gender() {
        return usr_pri_gender;
    }

    public String getUsr_birth() {
        return usr_birth;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public String getUsr_cell() {
        return usr_cell;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public void setUsr_account(String usr_account) {
        this.usr_account = usr_account;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public void setUsr_pri_gender(int usr_pri_gender) {
        this.usr_pri_gender = usr_pri_gender;
    }

    public void setUsr_birth(String usr_birth) {
        this.usr_birth = usr_birth;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    public void setUsr_cell(String usr_cell) {
        this.usr_cell = usr_cell;
    }

    public UserBase(String passwd, String usr_account, String usr_birth,
            String usr_cell, String usr_email, String usr_id, String usr_name,
            int usr_pri_gender) {
        this.passwd = passwd;
        this.usr_account = usr_account;
        this.usr_birth = usr_birth;
        this.usr_cell = usr_cell;
        this.usr_email = usr_email;
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_pri_gender = usr_pri_gender;
    }
    String usr_id;
    String usr_account;
    String passwd;
    String usr_name;
    int usr_pri_gender;
    String usr_birth;
    String usr_email;
    String usr_cell;
}
