package controle;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Usuario;

public class AlterarUsuario extends HttpServlet {

    private String opcao;
    private String codigo;
    private List<Usuario> usuarios;
    private Usuario usuario;
    private UsuarioDAO dao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            opcao = request.getParameter("opcao");
            codigo = request.getParameter("codigo");
            dao = new UsuarioDAO();
            usuarios = dao.buscarPorCpf(codigo);
            for(Usuario u : usuarios){
                usuario = u;
            }
            if (opcao.equals("editar")) {
                session.setAttribute("user", usuario);
                RequestDispatcher r = request.getRequestDispatcher("/editarUsuario.jsp");
                r.forward(request, response);
            } else if (opcao.equals("excluir")) {
                session.setAttribute("user", usuario);
                RequestDispatcher r = request.getRequestDispatcher("/excluirUsuario.jsp");
                r.forward(request, response);
            }

        } catch (Exception ex) {
            session.setAttribute("erro", ex);
            RequestDispatcher r = request.getRequestDispatcher("/erro.jsp");
            r.forward(request, response);
        }
    }

}
