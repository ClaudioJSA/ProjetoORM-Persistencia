/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            pststm.setString(1, e.getTitle());
            pststm.setString(2, e.getAuthors());
            pststm.setDate(3, Date.valueOf(e.getAcquisition()));
            pststm.setShort(4, e.getPages());
            pststm.setShort(5, e.getYear());
            pststm.setByte(6, e.getEdition());
            pststm.setBigDecimal(7, e.getPrice());
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Book extractObject(ResultSet rs){
        Book book = new Book();
        try{
            book.setTitle(rs.getString("title"));
            book.setAuthors(rs.getString("authors"));
            book.setAcquisition(rs.getDate("acquisition").toLocalDate());
            book.setPages(rs.getShort("pages"));
            book.setYear(rs.getShort("year"));
            book.setEdition(rs.getByte("edition"));
            book.setPrice(rs.getBigDecimal("price"));
        }catch(SQLException ex){
                System.out.println("Ex: " + ex);      
        }
        return book;
    }
    
    @Override
    public List<Book> extractObjects(ResultSet rs){
        List<Book> books = new ArrayList<>();
        try{
            while(rs.next()){
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthors(rs.getString("authors"));
                book.setAcquisition(rs.getDate("acquisition").toLocalDate());
                book.setPages(rs.getShort("pages"));
                book.setYear(rs.getShort("year"));
                book.setEdition(rs.getByte("edition"));
                book.setPrice(rs.getBigDecimal("price"));
                books.add(book);
            }
        }catch(SQLException ex){
                System.out.println("Ex: " + ex);      
        }
        return books;
    }
    
    public BookDao() {
    }

    public String getTABLE() {
        return TABLE;
    }
    
    
    
}
