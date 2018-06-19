package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Usuario;

public class InserirUsuario extends HttpServlet {

    private Usuario usuario;
    private UsuarioDAO dao;
    private String codigo;
    private String nome;
    private String funcao;
    private String senha;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        // pega parâmetros do request
        codigo = request.getParameter("codigo");
        nome = request.getParameter("nome");
        funcao = request.getParameter("funcao");
        senha = request.getParameter("senha");

        //Cria objeto acidente
        usuario = new Usuario();
        dao = new UsuarioDAO();
        usuario.setCodigo(codigo);
        usuario.setNome(nome);
        usuario.setFuncao(funcao);
        usuario.setSenha(senha);

        HttpSession session = request.getSession();
        try {
            if(dao.buscarPorCpf(codigo).isEmpty()){
                dao.salvar(usuario);
                session.setAttribute("flag", true);
                RequestDispatcher r = request.getRequestDispatcher("/inserirUsuario.jsp");
                r.forward(request, response);
            } else {
                session.setAttribute("flag", false);
                RequestDispatcher r = request.getRequestDispatcher("/inserirUsuario.jsp");
                r.forward(request, response);
            }
        } catch (Exception ex) {
            session.setAttribute("erro", ex);
            RequestDispatcher r = request.getRequestDispatcher("/erro.jsp");
            r.forward(request, response);
        }
    }

}
