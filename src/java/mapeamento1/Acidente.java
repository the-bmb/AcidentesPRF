package mapeamento1;
// Generated 25/06/2018 17:10:40 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Acidente generated by hbm2java
 */
public class Acidente  implements java.io.Serializable {


     private int id;
     private Integer pessoas;
     private Integer mortos;
     private Integer feridosLeves;
     private Integer feridosGraves;
     private Integer ilesos;
     private Integer ignorados;
     private Integer feridos;
     private Integer veiculos;
     private Set condicaos = new HashSet(0);
     private Set locals = new HashSet(0);
     private Set datas = new HashSet(0);

    public Acidente() {
    }

	
    public Acidente(int id) {
        this.id = id;
    }
    public Acidente(int id, Integer pessoas, Integer mortos, Integer feridosLeves, Integer feridosGraves, Integer ilesos, Integer ignorados, Integer feridos, Integer veiculos, Set condicaos, Set locals, Set datas) {
       this.id = id;
       this.pessoas = pessoas;
       this.mortos = mortos;
       this.feridosLeves = feridosLeves;
       this.feridosGraves = feridosGraves;
       this.ilesos = ilesos;
       this.ignorados = ignorados;
       this.feridos = feridos;
       this.veiculos = veiculos;
       this.condicaos = condicaos;
       this.locals = locals;
       this.datas = datas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Integer pessoas) {
        this.pessoas = pessoas;
    }
    public Integer getMortos() {
        return this.mortos;
    }
    
    public void setMortos(Integer mortos) {
        this.mortos = mortos;
    }
    public Integer getFeridosLeves() {
        return this.feridosLeves;
    }
    
    public void setFeridosLeves(Integer feridosLeves) {
        this.feridosLeves = feridosLeves;
    }
    public Integer getFeridosGraves() {
        return this.feridosGraves;
    }
    
    public void setFeridosGraves(Integer feridosGraves) {
        this.feridosGraves = feridosGraves;
    }
    public Integer getIlesos() {
        return this.ilesos;
    }
    
    public void setIlesos(Integer ilesos) {
        this.ilesos = ilesos;
    }
    public Integer getIgnorados() {
        return this.ignorados;
    }
    
    public void setIgnorados(Integer ignorados) {
        this.ignorados = ignorados;
    }
    public Integer getFeridos() {
        return this.feridos;
    }
    
    public void setFeridos(Integer feridos) {
        this.feridos = feridos;
    }
    public Integer getVeiculos() {
        return this.veiculos;
    }
    
    public void setVeiculos(Integer veiculos) {
        this.veiculos = veiculos;
    }
    public Set getCondicaos() {
        return this.condicaos;
    }
    
    public void setCondicaos(Set condicaos) {
        this.condicaos = condicaos;
    }
    public Set getLocals() {
        return this.locals;
    }
    
    public void setLocals(Set locals) {
        this.locals = locals;
    }
    public Set getDatas() {
        return this.datas;
    }
    
    public void setDatas(Set datas) {
        this.datas = datas;
    }




}

