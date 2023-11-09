/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import repository.Dao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public abstract class BookDao extends Dao<Book>{
    public final String TABLE = "book";

    @Override
    public String getSaveStatement(){
        return "INSET INTO "+ TABLE + "(title, authors, acquisition, pages, year, edition, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }
    
    @Override
    public String getUpdateStatement(){
        return "UPDATE " + TABLE + "SET title = ?, authors = ?, acquisition = ?, pages = ?, year = ?, edition = ?, price = ? WHERE id = ?";
    }
    
    @Override
    public String getFindByIdStatement(){
        return "SELECT title, authors, acquisition, pages, year, edition, price FROM" + TABLE + "WHERE id = ?";
    }
    
    @Override
    public String getFindAllStatement(){
        return "SELECT title, authors, acquisition, pages, year, edition, price FROM " + TABLE;
    }
    
    @Override
    public String getDeleteStatement(){
        return "DELETE FROM " + TABLE + "WHERE id = ?";
    }
    
    @Override
    public void coposeSaveOrUpdateStatement(PreparedStatement pststm, Book e){
        
    }
    
    @Override
    public Book extractObject(ResultSet rs){
        return new Book();
    }
    
    @Override
    public List<Book> extractObjects(ResultSet rs){
        return null;
    }
    
    public BookDao() {
    }

    public String getTABLE() {
        return TABLE;
    }
    
    
    
}
