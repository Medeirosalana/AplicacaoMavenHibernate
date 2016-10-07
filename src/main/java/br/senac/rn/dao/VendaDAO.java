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

public class VendaDAO {
    
    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");

    public VendaDAO() {
        em = emf.createEntityManager();
    }
    
    
    public boolean inserir(Venda objeto){
        try{
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    
    public boolean apagar(Venda objeto){
        try{
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    public boolean editar(Venda objeto){
        try{
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    public List<Venda> buscarTudo(){
        return em.createQuery("SELECT c FROM Venda c").getResultList();
    }
    public Venda buscarPorId(int id){
        return em.find(Venda.class, id);
    }
    public List<Venda> buscarPorFiltro(String filter){
        Query query = em.createQuery("SELECT c FROM Venda c WHERE c.nome LIKE :filtro");
        query.setParameter("filtro", "%"+ filter +"%");
        return query.getResultList();
    }
}

