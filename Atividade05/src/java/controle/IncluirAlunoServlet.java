package controle;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlunoBO;
import modelo.NegocioException;
import modelo.entidades.Aluno;

/**
 *
 * @author 18114290048
 */
@WebServlet(name = "IncluirAlunoServlet", urlPatterns = {"/aluno/incluir"})
public class IncluirAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Incluir<Aluno> incluir = new ArrayIncluir<Aluno>();
        AlunoBO bo = new AlunoBO();
        // tipo variavel e new; 

        try {
            incluir = bo.listar();
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
            out.println("<h1>Incluir de Alunos</h1>");
            out.println(" <form action=\"/aluno/incluir\" method=\"post\">");
            out.println("<div>");
            out.println("<label>Matrícula:</label>");
            out.println("<<input type=\"text\" name=\"matricula\" size=\"15\">");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Nome:</label>");
            out.println("<input type=\"text\" name=\"nome\" size=\"30\">");
            out.println("<div>");
            out.println("<input type=\"submit\" value=\"Salvar\"/>");
            out.println("<a href=\"/aluno/listar\">Desistir</a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            for (Aluno aluno : incluir) {
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
        Aluno aluno = new Aluno();
        aluno.setMatricula(Integer.parseInt(req.getParameter("matricula")));
        aluno.setNome(req.getParameter("nome"));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
