package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;

@WebServlet(name = "ListarAlunoServlet", urlPatterns = {"/aluno"})
public class ListarAlunoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarAlunoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarAlunoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Aluno> lista = new ArrayList<Aluno>();
        AlunoBO bo = new AlunoBO();
        // tipo variavel e new; 

        try {
            lista = bo.listar();
        } catch (NegocioException e) {
            throw new ServletException("", e);

        }
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Alunos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listagem de Alunos</h1>");
            out.println("</table>");
            out.println("</tr>");
            out.println("<th>Matrícula</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Ações</th>");
            out.println("</tr>");
            for(Aluno aluno: lista) {
  out.println("<tr>");
  out.println("<td>" + aluno.getMatricula() + "</td>");
  out.println("<td>" + aluno.getMatricula() + "</td>");
  out.println("<td><a href=''>Alterar</a>");
  out.println("<a href=''>Excluir</a></td>");
  out.println("</tr>");
}
            out.println("</table>");
            out.println("<body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); 
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
