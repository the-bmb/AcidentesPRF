package mapeamento1;
// Generated 25/06/2018 17:10:40 by Hibernate Tools 4.3.1



/**
 * Tipoacidente generated by hbm2java
 */
public class Tipoacidente  implements java.io.Serializable {


     private int ttacodigo;
     private Character ttaatualiza;
     private Character ttarelacidente;
     private Character ttaativo;
     private String ttadescricao;

    public Tipoacidente() {
    }

	
    public Tipoacidente(int ttacodigo) {
        this.ttacodigo = ttacodigo;
    }
    public Tipoacidente(int ttacodigo, Character ttaatualiza, Character ttarelacidente, Character ttaativo, String ttadescricao) {
       this.ttacodigo = ttacodigo;
       this.ttaatualiza = ttaatualiza;
       this.ttarelacidente = ttarelacidente;
       this.ttaativo = ttaativo;
       this.ttadescricao = ttadescricao;
    }
   
    public int getTtacodigo() {
        return this.ttacodigo;
    }
    
    public void setTtacodigo(int ttacodigo) {
        this.ttacodigo = ttacodigo;
    }
    public Character getTtaatualiza() {
        return this.ttaatualiza;
    }
    
    public void setTtaatualiza(Character ttaatualiza) {
        this.ttaatualiza = ttaatualiza;
    }
    public Character getTtarelacidente() {
        return this.ttarelacidente;
    }
    
    public void setTtarelacidente(Character ttarelacidente) {
        this.ttarelacidente = ttarelacidente;
    }
    public Character getTtaativo() {
        return this.ttaativo;
    }
    
    public void setTtaativo(Character ttaativo) {
        this.ttaativo = ttaativo;
    }
    public String getTtadescricao() {
        return this.ttadescricao;
    }
    
    public void setTtadescricao(String ttadescricao) {
        this.ttadescricao = ttadescricao;
    }




}

