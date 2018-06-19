package mapeamento;
// Generated 11/05/2017 13:08:58 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Local generated by hbm2java
 */
@Entity
@Table(name="local"
    ,schema="public"
)
public class Local  implements java.io.Serializable {


     private int id;
     private Acidente acidente;
     private String uf;
     private Integer br;
     private Float km;
     private String municipio;

    public Local() {
    }

	
    public Local(Acidente acidente) {
        this.acidente = acidente;
    }
    public Local(Acidente acidente, String uf, Integer br, Float km, String municipio) {
       this.acidente = acidente;
       this.uf = uf;
       this.br = br;
       this.km = km;
       this.municipio = municipio;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="acidente"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Acidente getAcidente() {
        return this.acidente;
    }
    
    public void setAcidente(Acidente acidente) {
        this.acidente = acidente;
    }

    
    @Column(name="uf", length=2)
    public String getUf() {
        return this.uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }

    
    @Column(name="br")
    public Integer getBr() {
        return this.br;
    }
    
    public void setBr(Integer br) {
        this.br = br;
    }

    
    @Column(name="km", precision=8, scale=8)
    public Float getKm() {
        return this.km;
    }
    
    public void setKm(Float km) {
        this.km = km;
    }

    
    @Column(name="municipio", length=200)
    public String getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }




}

