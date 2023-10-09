package br.ifsp.dsw3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "terceiroServlet", value = "/autentica")
public class TerceiroServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // super.doPost(req, resp);
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        HttpSession session = req.getSession();
        String mensagem = "";

        if( (usuario.equals("ifsp")) && (senha.equals("dsw3")) ){
            mensagem = "Bem-vindo, ifsp!";
            session.setAttribute("mensagem", mensagem);
            resp.sendRedirect("autenticado.jsp");
        }else{
            mensagem = "Usuário ou senha inválidos!";
            session.setAttribute("mensagem", mensagem);
            resp.sendRedirect("./");
        }
    }
    
}
