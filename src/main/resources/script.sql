/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 * Created: 10 de nov. de 2023
 */

CREATE TABLE book(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    authors VARCHAR(250) NOT NULL,
    acquisition DATE,
    pages SMALLINT,
    year SMALLINT NOT NULL,
    edition TINYINT,
    price DECIMAL(10,8)
);