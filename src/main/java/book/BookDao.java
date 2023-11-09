/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import repository.Dao;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public abstract class BookDao extends Dao<Book>{
    public final String TABLE = "book";

    public BookDao() {
    }

    public String getTABLE() {
        return TABLE;
    }
    
    
    
}
