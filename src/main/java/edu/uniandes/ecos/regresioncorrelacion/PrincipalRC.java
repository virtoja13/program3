/*
*Clase principal del programa que calcula Regresion y Correlacion
*@author: José Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.regresioncorrelacion;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
 
public class PrincipalRC extends HttpServlet {
         
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        mostrarLineas(req, resp);
    }
     
    private void mostrarLineas(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        DecimalFormat df = new DecimalFormat("#.####");
        PrintWriter out = resp.getWriter();
        ArrayList<HallarValores> listaValores = new ArrayList<HallarValores>();
        listaValores.add(new HallarValores(HallarValores.datos1()));
        listaValores.add(new HallarValores(HallarValores.datos2()));
        listaValores.add(new HallarValores(HallarValores.datos3()));
        listaValores.add(new HallarValores(HallarValores.datos4()));
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Test</th>");
        out.println("<th colspan='5'>Values</th>");
        out.println("</tr>");
        out.println("<td></td>");
        out.println("<td>B0</td>");
        out.println("<td>B1</td>");
        out.println("<td>rxy</td>");
        out.println("<td>r2</td>");
        out.println("<td>Yk</td>");
        out.println("</tr>");
        out.println("<tr align='center'>");
        int i = 1;
        for(HallarValores valor : listaValores){
            out.println("<td>TEST"+i+"</td>");
            out.println("<td>"+df.format(valor.getB0())+"</td>");
            out.println("<td>"+df.format(valor.getB1())+"</td>");
            out.println("<td>"+df.format(valor.getRxy())+"</td>");
            out.println("<td>"+df.format(valor.getR2())+"</td>");
            out.println("<td>"+df.format(valor.getYk())+"</td>");
            out.println("</tr>");
            i++;
        }
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        resp.getWriter().print(out);
    }
     
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalRC()),"/*");
        server.start();
        server.join();
    }
    
}