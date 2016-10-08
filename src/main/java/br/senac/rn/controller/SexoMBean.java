package br.senac.rn.controller;

import br.senac.rn.dao.SexoDAO;
import br.senac.rn.model.Sexo;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SexoMBean {
    
    private Sexo sexo = new Sexo();

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public String salvar(){
        SexoDAO dao = new SexoDAO();
        dao.inserir(sexo);
        return "index.xhtml";
    }
}
