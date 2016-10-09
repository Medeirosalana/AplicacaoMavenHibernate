/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.rn.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractGenericDAO<Objeto extends PersistDB> {

    protected EntityManager gerenciadorEntidade;
    
    protected EntityManager getGerenciadorEntidade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
        return emf.createEntityManager();
    }

    public boolean inserir(Objeto objeto){
        try{
            gerenciadorEntidade = getGerenciadorEntidade();
            gerenciadorEntidade.getTransaction().begin();
            gerenciadorEntidade.persist(objeto);
            gerenciadorEntidade.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("ERRO AO INSERIR: " + erro.toString());
            System.out.println("OBJETO: " + objeto.toString());
        }
        return false;
    } 
    
    
        public boolean apagar(Objeto objeto){
        try{
            gerenciadorEntidade = getGerenciadorEntidade();
            gerenciadorEntidade.getTransaction().begin();
            gerenciadorEntidade.remove(objeto);
            gerenciadorEntidade.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("ERRO AO APAGAR: " + erro.toString());
            System.out.println("OBJETO: " + objeto.toString());
        }
        return false;
    }
    
    public boolean editar(Objeto objeto){
        try{
            gerenciadorEntidade = getGerenciadorEntidade();
            gerenciadorEntidade.getTransaction().begin();
            gerenciadorEntidade.merge(objeto);
            gerenciadorEntidade.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("ERRO AO EDITAR: " + erro.toString());
            System.out.println("OBJETO: " + objeto.toString());
        }
        return false;
    }
    
    public List<Objeto> buscarTudo(){
        try{
            gerenciadorEntidade = getGerenciadorEntidade();
            CriteriaBuilder builder = gerenciadorEntidade.getCriteriaBuilder();
            CriteriaQuery<Objeto> query = builder.createQuery(getClassType());
            TypedQuery<Objeto> typeQuery = gerenciadorEntidade.createQuery(query.select(query.from(getClassType())));
            return typeQuery.getResultList();
        }catch(Exception erro){
            System.out.println("ERRO AO BUSCAR LISTA: " + erro.toString());
        }
        return null;
    }
    
    public Objeto buscarPorId (int id){
        try{
           gerenciadorEntidade = getGerenciadorEntidade();
           return gerenciadorEntidade.find(getClassType(), id);           
        }catch(Exception erro){
            System.out.println("ERRO AO BUSCAR POR ID: " + erro.toString());
        }
        return null;
    }
    
    public abstract Class<Objeto> getClassType();
    
    
}
