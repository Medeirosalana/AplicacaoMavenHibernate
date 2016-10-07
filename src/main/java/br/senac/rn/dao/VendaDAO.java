/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.rn.dao;


import br.senac.rn.model.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VendaDAO extends AbstractGenericDAO<Venda>{

    public Class<Venda> getClassType(){
        return Venda.class;
    }
}