/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
            } catch (Exception ex) {
                System.out.println("Ex: "+ ex);
            }
        }
        return id;
    }

    @Override
    public E findById(Long id) {
        try(PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(getFindByIdStatement())){
            pstmt.setLong(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next())
                return extractObject(resultSet);
        return null;
        }catch(Exception ex){
            System.out.println("Ex: "+ex);
        }
        return null;
    }

    @Override
    public List<E> fidAll() {
        try ( PreparedStatement pstsmt = DbConnection.getConnection().prepareStatement(getFindAllStatement())) {
            ResultSet resultSet = pstsmt.executeQuery();
            return extractObjects(resultSet);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement pstmt = DbConnection.getConnection().prepareStatement(getDeleteStatement())){
            ResultSet resultSet = pstmt.executeQuery();
            System.out.println("Exclusão executada com sucesso.");
        } catch (Exception ex) {
            System.out.println("Ex:" + ex);
        }
    }
    
}
