package br.senac.rn.model;

import br.senac.rn.dao.PersistDB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements PersistDB{

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @ManyToOne
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", categoria=" + categoria + '}';
    }
       
    
    
}
