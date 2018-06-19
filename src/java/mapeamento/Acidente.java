package mapeamento;
// Generated 11/05/2017 13:08:58 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Acidente generated by hbm2java
 */
@Entity
@Table(name="acidente"
    ,schema="public"
)
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
     private Data data;
     private Local local;
     private Condicao condicao;

    public Acidente() {
    }

	
    public Acidente(int id) {
        this.id = id;
    }
    public Acidente(int id, Integer pessoas, Integer mortos, Integer feridosLeves, Integer feridosGraves, Integer ilesos, Integer ignorados, Integer feridos, Integer veiculos, Data data, Local local, Condicao condicao) {
       this.id = id;
       this.pessoas = pessoas;
       this.mortos = mortos;
       this.feridosLeves = feridosLeves;
       this.feridosGraves = feridosGraves;
       this.ilesos = ilesos;
       this.ignorados = ignorados;
       this.feridos = feridos;
       this.veiculos = veiculos;
       this.data = data;
       this.local = local;
       this.condicao = condicao;
    }
   
     @Id 

    
    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="pessoas")
    public Integer getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Integer pessoas) {
        this.pessoas = pessoas;
    }

    
    @Column(name="mortos")
    public Integer getMortos() {
        return this.mortos;
    }
    
    public void setMortos(Integer mortos) {
        this.mortos = mortos;
    }

    
    @Column(name="feridos_leves")
    public Integer getFeridosLeves() {
        return this.feridosLeves;
    }
    
    public void setFeridosLeves(Integer feridosLeves) {
        this.feridosLeves = feridosLeves;
    }

    
    @Column(name="feridos_graves")
    public Integer getFeridosGraves() {
        return this.feridosGraves;
    }
    
    public void setFeridosGraves(Integer feridosGraves) {
        this.feridosGraves = feridosGraves;
    }

    
    @Column(name="ilesos")
    public Integer getIlesos() {
        return this.ilesos;
    }
    
    public void setIlesos(Integer ilesos) {
        this.ilesos = ilesos;
    }

    
    @Column(name="ignorados")
    public Integer getIgnorados() {
        return this.ignorados;
    }
    
    public void setIgnorados(Integer ignorados) {
        this.ignorados = ignorados;
    }

    
    @Column(name="feridos")
    public Integer getFeridos() {
        return this.feridos;
    }
    
    public void setFeridos(Integer feridos) {
        this.feridos = feridos;
    }

    
    @Column(name="veiculos")
    public Integer getVeiculos() {
        return this.veiculos;
    }
    
    public void setVeiculos(Integer veiculos) {
        this.veiculos = veiculos;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="acidente")
    public Data getData() {
        return this.data;
    }
    
    public void setData(Data data) {
        this.data = data;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="acidente")
    public Local getLocal() {
        return this.local;
    }
    
    public void setLocal(Local local) {
        this.local = local;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="acidente")
    public Condicao getCondicao() {
        return this.condicao;
    }
    
    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }




}


