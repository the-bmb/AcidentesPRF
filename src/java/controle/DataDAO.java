package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mapeamento.Data;
import mapeamento.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataDAO {

    private Session sessao;

    public DataDAO() {
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

    public void salvar(Data data) {
        sessao.save(data);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Data data) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(data);
        tr.commit();
    }

    public ArrayList<Data> listarTodos() {
        ArrayList<Data> datas = (ArrayList<Data>) sessao.createQuery("from Data").list();
        return datas;
    }

    public ArrayList<Data> buscar(Date dInicial, Date dFinal) {
        return (ArrayList<Data>) sessao.createQuery("from Data where dataAcidente between '"
                + dInicial + "' and '" + dFinal + "' order by dataAcidente").list();
    }

    public ArrayList<Data> buscarPorData(Date data) {
        return (ArrayList<Data>) sessao.createQuery("from Data where dataAcidente = '"
                + data + "' order by dataAcidente").list();
    }

    public Data buscarPorId(int id) {
        ArrayList<Data> datas = (ArrayList<Data>) sessao.createQuery("from Data where id = " + id).list();
        Data data = new Data();
        for (Data d : datas) {
            data = d;
        }
        return data;
    }

    public void excluir(int id) {
        Data data = new Data();
        sessao.load(data, id);
        sessao.delete(data);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
