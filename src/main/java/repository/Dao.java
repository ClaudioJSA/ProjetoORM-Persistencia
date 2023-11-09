/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 * @param <E>
 */
public abstract class Dao<E> implements IDao<E>{

    @Override
    public Long saveOrUpdate(E e) {
        Long id = 0L;
        
        if (((Entity) e).getId() == null|| ((Entity) e).getId() == 0){
            try(PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(getSaveStatement(),Statement.NO_GENERATED_KEYS)){
                coposeSaveOrUpdateStatement(pstmt, e);
                pstmt.executeUpdate();
                ResultSet resultSet = pstmt.getGeneratedKeys();
                if(resultSet.next()){
                    id = resultSet.getLong(1);
                }
            } catch (Exception ex) {
                System.out.println(">> " +ex);
            }
        } else{
            try(PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(getUpdateStatement())){
                coposeSaveOrUpdateStatement(pstmt, e);
                pstmt.executeUpdate();
                id = ((Entity)e).getId();
            } catch (SQLException ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }

    @Override
    public E fidById() {
        return null;
    }

    @Override
    public List fidAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
