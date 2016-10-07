
package br.senac.rn.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.senac.rn.model.Categoria;
import java.util.logging.Logger;

public class CategoriaDAO extends AbstractGenericDAO<Categoria>{

    public Class<Categoria> getClassType(){
        return Categoria.class;
    }
}