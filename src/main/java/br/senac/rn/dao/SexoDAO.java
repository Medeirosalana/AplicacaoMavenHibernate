package br.senac.rn.dao;

import br.senac.rn.model.Sexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SexoDAO extends AbstractGenericDAO<Sexo>{
    
    
    
    public List<Sexo> buscarTudo(){
        return this.getEerenciadorEntidade().createQuery("SELECT s FROM Sexo s").getResultList();
    }
    public Sexo buscarPorId(int id){
        return this.getEerenciadorEntidade().find(Sexo.class, id);
    }
    public List<Sexo> buscarPorFiltro(String filter){
        Query query = this.getEerenciadorEntidade().createQuery("SELECT s FROM Sexo s WHERE s.nome LIKE :filtro");
        query.setParameter("filtro", "%"+ filter +"%");
        return query.getResultList();
    }
}
