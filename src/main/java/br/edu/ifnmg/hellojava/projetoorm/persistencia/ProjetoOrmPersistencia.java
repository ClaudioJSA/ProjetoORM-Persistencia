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
import java.time.Month;
import java.util.List;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class ProjetoOrmPersistencia {
    public static void main(String[] args) {
        Book book = new Book();
        Long id;
        List<Book> books;
 
//<editor-fold defaultstate="collapsed" desc="2.1. Tentativa de criação de um livro com data de aquisição com 3 dias posteriores ao dia corrente;">
        System.out.println("2.1. Tentativa de criação de um livro com data de aquisição com 3 dias posteriores ao dia corrente;");
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
//</editor-fold>   
 
//<editor-fold defaultstate="collapsed" desc=".2. A inclusão de três livros com dados à escolha;">
        System.out.println("\n2.2. A inclusão de três livros com dados à escolha;");
        try{
            book.setTitle("O cortiço");
            book.setAuthors("Aluísio Tancredo Gonçalves de Azevedo");
            book.setAcquisition(LocalDate.of(2019, Month.OCTOBER, 17));
            book.setPages((short)224);
            book.setYear((short)1890);
            book.setEdition((byte)3);
            book.setPrice(BigDecimal.valueOf(23.34));
            book.setId(null);
            id = new BookDao().saveOrUpdate(book);
            book.setId(id);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        try{
            book.setTitle("Os sertões");
            book.setAuthors("Euclides da Cunha");
            book.setAcquisition(LocalDate.of(2020, Month.MARCH, 20));
            book.setPages((short)368);
            book.setYear((short)1902);
            book.setEdition((byte)1);
            book.setPrice(BigDecimal.valueOf(16.99));
            book.setId(null);
            id = new BookDao().saveOrUpdate(book);
            book.setId(id);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        try{
            book.setTitle("A escrava Isaura");
            book.setAuthors("Bernardo Guimarães");
            book.setAcquisition(LocalDate.of(2021, Month.APRIL, 26));
            book.setPages((short)176);
            book.setYear((short)1875);
            book.setEdition((byte)5);
            book.setPrice(BigDecimal.valueOf(22.46));
            book.setId(null);
            id = new BookDao().saveOrUpdate(book);
            book.setId(id);
        }catch(Exception ex){
            System.out.println(ex);
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="2.4. A localização por ID de dois livros à escolha;">
        System.out.println("\n2.4. A localização por ID de dois livros à escolha;");
        try{
            id = 1L;
            book = new BookDao().findById(id);
            book.setId(id);
            System.out.println(">> " + book);
        }catch(Exception ex){
            System.out.println("Id do livro não encontrado.\n" + ex);
        }
        
        try{
            id = 3L;
            book = new BookDao().findById(id);
            book.setId(id);
            System.out.println(">> " + book);
        }catch(Exception ex){
            System.out.println("Id do livro não encontrado.\n" + ex);
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="2.3. a atualização de um livro à escolha;">
        ///Considerando o livro encontrado anteriormente para fazer a atualização, 
        System.out.println("\n2.3. a atualização de um livro à escolha;");
        try{
            book.setAcquisition(LocalDate.of(2023, Month.NOVEMBER, 10));
            book.setEdition((byte)7);
            book.setPrice(BigDecimal.valueOf(75.36));
            System.out.println(">> " + book);
            new BookDao().saveOrUpdate(book);
        }catch(Exception ex){
            System.out.println(ex);
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="2.5. a carga de todos os livros;">
        System.out.println("\n2.5. a carga de todos os livros;");
        try{
            books=new BookDao().fidAll();
            books.forEach(aux -> {
                System.out.println(">> " + aux);
            });
        }catch(Exception ex){
            System.out.println(ex);
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="2.6. e a remoção de um livro à escolha.">
        System.out.println("\n2.6. e a remoção de um livro à escolha.");
        try{
            id = 2L;
            new BookDao().delete(id);
        }catch(Exception ex){
            System.out.println(ex);
        }
//</editor-fold>
    }
}
