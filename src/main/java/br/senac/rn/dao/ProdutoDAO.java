package br.senac.rn.dao;
    
import br.senac.rn.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProdutoDAO {
    
    private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");

    public ProdutoDAO() {
        em = emf.createEntityManager();
    }
    
    
    public boolean inserir(Produto objeto){
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
    
    public boolean apagar(Produto objeto){
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
    public boolean editar(Produto objeto){
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
    public List<Produto> buscarTudo(){
        return em.createQuery("SELECT c FROM Produto c").getResultList();
    }
    public Produto buscarPorId(int id){
        return em.find(Produto.class, id);
    }
    public List<Produto> buscarPorFiltro(String filter){
        Query query = em.createQuery("SELECT c FROM Produto c WHERE c.nome LIKE :filtro");
        query.setParameter("filtro", "%"+ filter +"%");
        return query.getResultList();
    }
}
