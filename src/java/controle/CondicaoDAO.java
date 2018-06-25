package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mapeamento1.Condicao;
import mapeamento1.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CondicaoDAO {

    private Session sessao;

    public CondicaoDAO() {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public void fecharSessao() {
        sessao.close();
    }

    public void salvar(Condicao condicao) {
        sessao.save(condicao);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Condicao condicao) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(condicao);
        tr.commit();
    }

    public ArrayList<Condicao> listarTodos() {
        return (ArrayList<Condicao>) sessao.createQuery("from Condicao").list();
    }

    public long causaPorData(Date dInicial, Date dFinal, String causa) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.causaAcidente = '" + causa + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long tipoAcidPorData(Date dInicial, Date dFinal, String tipoAcid) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.tipoAcidente = '" + tipoAcid + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }

    public long classificacaoPorData(Date dInicial, Date dFinal, String classificacao) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.classificacaoAcidente = '" + classificacao + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long fasePorData(Date dInicial, Date dFinal, String fase) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.faseDia = '" + fase + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long condPorData(Date dInicial, Date dFinal, String cond) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.condMetereologica = '" + cond + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long tipoPistaPorData(Date dInicial, Date dFinal, String tipoPista) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.tipoPista = '" + tipoPista + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long tracadoPorData(Date dInicial, Date dFinal, String tracado) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.tracadoVia = '" + tracado + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long usoSoloPorData(Date dInicial, Date dFinal, String usoSolo) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.usoSolo = '" + usoSolo + "' and d.dataAcidente between '" + dInicial + "' and '" + dFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public Condicao buscarPorId(int id) {
        ArrayList<Condicao> condicoes = (ArrayList<Condicao>) sessao.createQuery("from Condicao where id = " + id).list();
        Condicao condicao = new Condicao();
        for (Condicao c : condicoes) {
            condicao = c;
        }
        return condicao;
    }

    public void excluir(int id) {
        Condicao condicao = new Condicao();
        sessao.load(condicao, id);
        sessao.delete(condicao);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
