import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String metry = request.getParameter("metry");
        String centymetry = request.getParameter("centymetry");
        String milimetry = request.getParameter("milimetry");
        String Przelicz = request.getParameter("Przelicz");
        double meters;
        double centimeters;
        double milimeters;
        meters = Double.parseDouble(metry);
        centimeters = Double.parseDouble(centymetry);
        milimeters = Double.parseDouble(milimetry);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if (metry != null && centymetry.isEmpty() && milimetry.isEmpty() ) {
            response.getWriter().print("Podana wartość w przeliczeniu na: ");
            response.getWriter().print("metry: " + meters);
            response.getWriter().print("centymetry: " + meters / 100);
            response.getWriter().print("milimetry: " + meters / 1000);
        } else if (metry.isEmpty() && milimetry.isEmpty()) {
            response.getWriter().print("Podana wartość w przeliczeniu na: ");
            response.getWriter().print("metry: " + centimeters / 100);
            response.getWriter().print("centymetry: " + centimeters);
            response.getWriter().print("milimetry: " + centimeters * 10);
        } else if (metry.isEmpty() && centymetry.isEmpty()) {
            response.getWriter().print("Podana wartość w przeliczeniu na: ");
            response.getWriter().print("metry: " + milimeters / 100);
            response.getWriter().print("centymetry: " + milimeters);
            response.getWriter().print("milimetry: " + milimeters * 10);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
