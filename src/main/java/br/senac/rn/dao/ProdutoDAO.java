package br.senac.rn.dao;
    
import br.senac.rn.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProdutoDAO extends AbstractGenericDAO<Produto>{

    public Class<Produto> getClassType(){
        return Produto.class;
    }
}