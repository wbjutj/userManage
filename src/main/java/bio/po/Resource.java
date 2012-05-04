/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bio.po;

/**
 *
 * @author fafa
 */
public class Resource {

    String res_id;
    String res_name;
    int res_type;
    public Resource(){};
    public Resource(    String res_id,String res_name,int res_type){
        this.res_id = res_id;
        this.res_name = res_name;
        this.res_type = res_type;
    }
    public String getRes_id() {

        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public int getRes_type() {
        return res_type;
    }

    public void setRes_type(int res_type) {
        this.res_type = res_type;
    }
    public String toString(){
        String str = res_id +" "+ res_name +" "+res_type;
        return str;
    }
}
