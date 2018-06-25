package controle;

import java.util.ArrayList;
import mapeamento1.Usuario;
import mapeamento1.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    private Session sessao;

    public UsuarioDAO() {
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

    public Usuario login(Integer codigo, String senha) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sessao.createQuery("from "
                + "Usuario where codigo = '" + codigo + "' and senha = '" + senha + "'").list();
        Usuario usuario = new Usuario();
        for (Usuario u : usuarios) {
            usuario = u;
        }
        return usuario;
    }

    public void salvar(Usuario usuario) {
        sessao.save(usuario);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Usuario usuario) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(usuario);
        tr.commit();
    }

    public ArrayList<Usuario> listarTodos() {
        return (ArrayList<Usuario>) sessao.createQuery("from Usuario order by nome").list();
    }

    public ArrayList<Usuario> buscarPorCodigo(Integer codigo) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sessao.createQuery("from Usuario where codigo like '%" + codigo + "%' order by codigo").list();
        return usuarios;
    }
    
    public ArrayList<Usuario> buscarPorNome(String nome) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sessao.createQuery("from Usuario where nome like '%" + nome + "%' order by nome").list();
        return usuarios;
    }

    public void excluir(Integer codigo) {
        Usuario usuario = new Usuario();
        sessao.load(usuario, codigo);
        sessao.delete(usuario);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
