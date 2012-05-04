/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.po;

/**
 *
 * @author fafa
 */
public class  Operation {
	public String getOp_id() {
		return op_id;
	}
	public String getOp_name() {
		return op_name;
	}
	public String getOp_description() {
		return op_description;
	}
	public void setOp_id(String op_id) {
		this.op_id = op_id;
	}
	public void setOp_name(String op_name) {
		this.op_name = op_name;
	}
	public void setOp_description(String op_description) {
		this.op_description = op_description;
	}
	public Operation(String op_description, String op_id, String op_name) {
		this.op_description = op_description;
		this.op_id = op_id;
		this.op_name = op_name;
	}
	String op_id;
	String op_name;
	String op_description;
}
