/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.po;

/**
 *
 * @author fafa
 */
public class UserDetail {

    String usr_id;
    int usr_degree;
    String usr_univ;
    String usr_title;
    String usr_org;
    String usr_depart;
    String usr_group;
    String usr_fax;
    String usr_research;

    public String getUsr_id() {
        return usr_id;
    }

    public int getUsr_degree() {
        return usr_degree;
    }

    public String getUsr_univ() {
        return usr_univ;
    }

    public String getUsr_title() {
        return usr_title;
    }

    public String getUsr_org() {
        return usr_org;
    }

    public String getUsr_depart() {
        return usr_depart;
    }

    public String getUsr_group() {
        return usr_group;
    }

    public String getUsr_fax() {
        return usr_fax;
    }

    public String getUsr_research() {
        return usr_research;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public void setUsr_degree(int usr_degree) {
        this.usr_degree = usr_degree;
    }

    public void setUsr_univ(String usr_univ) {
        this.usr_univ = usr_univ;
    }

    public void setUsr_title(String usr_title) {
        this.usr_title = usr_title;
    }

    public void setUsr_org(String usr_org) {
        this.usr_org = usr_org;
    }

    public void setUsr_depart(String usr_depart) {
        this.usr_depart = usr_depart;
    }

    public void setUsr_group(String usr_group) {
        this.usr_group = usr_group;
    }

    public void setUsr_fax(String usr_fax) {
        this.usr_fax = usr_fax;
    }

    public void setUsr_research(String usr_research) {
        this.usr_research = usr_research;
    }

    public UserDetail() {
    }
    public UserDetail(int usr_degree, String usr_depart, String usr_fax,
            String usr_group, String usr_id, String usr_org,
            String usr_research, String usr_title, String usr_univ) {
        this.usr_degree = usr_degree;
        this.usr_depart = usr_depart;
        this.usr_fax = usr_fax;
        this.usr_group = usr_group;
        this.usr_id = usr_id;
        this.usr_org = usr_org;
        this.usr_research = usr_research;
        this.usr_title = usr_title;
        this.usr_univ = usr_univ;
    }
}
