/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import entity.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 */
public class Book extends Entity{
    private String title;
    private String authors;
    private LocalDate acquisition;
    private Short pages;
    private Short year;
    private Byte edition;
    private BigDecimal price;
    
///<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception{
        if(title.length() > 150 || title == null){
            throw new Exception("O titulo não pode ter mais de 150 digitos ou ser nulo");
        }
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) throws Exception {
        if(authors.length() > 250 || authors == null){
            throw new Exception("Os autores não podem ter mais de 250 caracteres ou ser nulo.");
        }
        this.authors = authors;
    }

    public LocalDate getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(LocalDate acquisition) throws Exception {
        if(acquisition.isAfter(LocalDate.now())){
            throw new Exception("A data de aquisição não pode ser depois da data atual.");
        }
        this.acquisition = acquisition;
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) throws Exception {
        if(pages < 1){
            throw new Exception("O numero de paginas dever ser pelo menos 1.");
        }
        this.pages = pages;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) throws Exception {
        if(year == null){
            throw new Exception("O ano não pode ser nulo.");
        }
        this.year = year;
    }

    public Byte getEdition() {
        return edition;
    }

    public void setEdition(Byte edition) throws Exception {
        if(edition < 1 || edition == null){
            throw new Exception("A edição não pode ser menor que 1 ou nula.");
        }
        this.edition = edition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws Exception {
        if(price.compareTo(new BigDecimal(0.0))<0){
            throw new Exception("O preço não pode ser menor que 0.");
        }
        this.price = price;
    }
//</editor-fold>
    
}
