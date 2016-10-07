
package br.senac.rn.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.senac.rn.model.Categoria;
import java.util.logging.Logger;

public class CategoriaDAO {
    

    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");

    public CategoriaDAO() {
        em = emf.createEntityManager();
    }
    
    public boolean inserir(Categoria objeto){
        try{
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        //Logger.info("INSERIDO OBJETO CATEGORIA COM SUCESSO!!!");
        return true;
        }catch(Exception erro){
            System.out.println("Erro: " + erro.toString());
        }
        return false;
    }
    
    public boolean apagar(Categoria objeto){
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
    public boolean editar(Categoria objeto){
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
    public List<Categoria> buscarTudo(){
        return em.createQuery("SELECT c FROM Categoria c").getResultList();
    }
    
    public Categoria buscarPorId(int id){
        return em.find(Categoria.class, id);
    }
    public List<Categoria> buscarPorFiltro(String filter){
        Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.nome LIKE :filtro");
        query.setParameter("filtro", "%"+ filter +"%");
        return query.getResultList();
    }
}
