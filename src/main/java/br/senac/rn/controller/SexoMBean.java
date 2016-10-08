package br.senac.rn.controller;

import br.senac.rn.dao.SexoDAO;
import br.senac.rn.model.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SexoMBean {
    
    private Sexo sexo = new Sexo();
    private List<Sexo> sexos;

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

    public List<Sexo> getSexos() {
        SexoDAO dao = new SexoDAO();
        sexos = dao.buscarTudo();
        return sexos;
    }

    public void setSexos(List<Sexo> sexos) {
        this.sexos = sexos;
    }
}
