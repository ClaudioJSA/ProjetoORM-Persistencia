/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.hellojava.projetoorm.persistencia;

import book.Book;
import book.BookDao;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class ProjetoOrmPersistencia {
    public static void main(String[] args) {
        Book book = new Book();
        Long id;
 
///2.1. tentativa de criação de um livro com data de aquisição com 3 dias posteriores ao dia corrente;
        try{
            book.setTitle("Dom Casmurro");
            book.setAuthors("Machado de Assis");
            book.setAcquisition(LocalDate.now().plusDays(3));
            book.setPages((short)208);
            book.setYear((short)2019);
            book.setEdition((byte)2);
            book.setPrice(BigDecimal.valueOf(22.00));
            
            id = new BookDao().saveOrUpdate(book);
            book.setId(id);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}
