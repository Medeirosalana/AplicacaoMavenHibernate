package br.senac.rn.dao;

import br.senac.rn.model.Cliente;
import br.senac.rn.model.Sexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO extends AbstractGenericDAO<Cliente>{

    public Class<Cliente> getClassType(){
        return Cliente.class;
    }
}