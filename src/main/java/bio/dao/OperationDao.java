/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bio.dao;

import bio.po.Operation;

/**
 *
 * @author fafa
 */
public interface OperationDao {
    boolean  addOperation(Operation operation);
    boolean  delOperation(String operation_id);
    Operation viewOperations(String operation_id);
}
