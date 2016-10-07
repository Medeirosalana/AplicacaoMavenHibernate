package br.senac.rn.dao;

import br.senac.rn.model.Sexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class SexoDAO extends AbstractGenericDAO<Sexo>{
    
    
    public Class<Sexo> getClassType(){
        return Sexo.class;
    }
    
    public List<Sexo> buscarPorFiltro(String filtro){
        try{
            gerenciadorEntidade = getGerenciadorEntidade();
            Query query = gerenciadorEntidade.createQuery("SELECT s FROM Sexo s WHERE s.nome LIKE :filtro");
            query.setParameter("filtro", "%"+ filtro +"%");
            return query.getResultList();
        }catch(Exception erro){
            System.out.println("ERRO AO BUSCAR LISTA: " + erro.toString());
        }
        return null;
    }
    
}
