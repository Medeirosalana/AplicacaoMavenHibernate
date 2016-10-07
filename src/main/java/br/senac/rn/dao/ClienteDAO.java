package br.senac.rn.dao;

import br.senac.rn.model.Cliente;
import br.senac.rn.model.Sexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO {

    private EntityManager em;
    
    public ClienteDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
        em = emf.createEntityManager();
    }
    
    public boolean insert(Cliente cliente){
        try{
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    
    public boolean delete(Cliente cliente){
        try{
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    
    public boolean update(Cliente cliente){
        try{
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    
    public List<Cliente> buscarTudo(){
        try{
            Query query = em.createQuery("SELECT c FROM Cliente c");
            return query.getResultList();
        } catch(Exception erro){
            System.out.println("Erro:" +  erro.toString());
        }
        return null;
    }
    
    
    
    public Cliente buscarPorId(int id){
        return em.find(Cliente.class, id);
    }
    
    public List<Cliente> buscarPorFiltro(String filter){
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :filtro");
        query.setParameter("filtro", "%"+ filter +"%");
        return query.getResultList();
    }
}
