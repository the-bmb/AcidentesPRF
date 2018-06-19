package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Usuario;

public class EditarUsuario extends HttpServlet {

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
        usuario.setCpf(codigo);
        usuario.setNome(nome);
        usuario.setFuncao(funcao);
        usuario.setSenha(senha);

        HttpSession session = request.getSession();
        try {
            dao.alterar(usuario);
            session.setAttribute("flag", true);
            session.setAttribute("user", usuario);
            RequestDispatcher r = request.getRequestDispatcher("/editarUsuario.jsp");
            r.forward(request, response);
        } catch (Exception ex) {
            session.setAttribute("flag", false);
            RequestDispatcher r = request.getRequestDispatcher("/editarUsuario.jsp");
            r.forward(request, response);
        }
    }

}
