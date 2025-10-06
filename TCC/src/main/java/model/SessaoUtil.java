package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessaoUtil {

    public static boolean verificaSessaoValida(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sessao = request.getSession(false);
        if (sessao == null || sessao.getAttribute("idUsuario") == null) {
            response.sendRedirect("Login.jsp");
            return false;
        }
        return true;
    }
}