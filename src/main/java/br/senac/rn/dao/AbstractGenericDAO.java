/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.rn.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractGenericDAO<Objeto> {

    private EntityManager gerenciadorEntidade;
    
    public EntityManager getEerenciadorEntidade() {
        if (gerenciadorEntidade == null){
            gerenciadorEntidade = Persistence.createEntityManagerFactory("ConexaoDB").createEntityManager();
        }
        return gerenciadorEntidade;
    }

    public boolean inserir(Objeto objeto){
        try{
            gerenciadorEntidade = getEerenciadorEntidade();
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
            gerenciadorEntidade = getEerenciadorEntidade();
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
            gerenciadorEntidade = getEerenciadorEntidade();
            this.gerenciadorEntidade.getTransaction().begin();
            this.gerenciadorEntidade.merge(objeto);
            this.gerenciadorEntidade.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("ERRO AO EDITAR: " + erro.toString());
            System.out.println("OBJETO: " + objeto.toString());
        }
        return false;
    }
    
    
    
}
