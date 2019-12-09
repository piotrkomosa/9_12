import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        countLengthUnit(request, response);
        String metry = request.getParameter("metry");
        String centymetry = request.getParameter("centymetry");
        String milimetry = request.getParameter("milimetry");
//        double meters;
//        double centimeters;
//        double milimeters;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    private void countLengthUnit(HttpServletRequest request, HttpServletResponse response) {

        Double meters = (Double) request.getAttribute("metry");
        Double centimeters = (Double) request.getAttribute("centymetry");
        Double milimeters = (Double) request.getAttribute("milimetry");
        if (checkIfValuesCorrect(meters, centimeters, milimeters)) {
            if (meters != null) {
                centimeters = meters * 100;
                milimeters = meters * 1000;
            } else if (centimeters != null) {
                meters = centimeters / 100;
                milimeters = centimeters * 10;
            } else if (milimeters != null) {
                centimeters = milimeters / 10;
                meters = milimeters / 1000;
            }
            request.setAttribute("metry", meters);
            request.setAttribute("centymetry", centimeters);
            request.setAttribute("milimetry", milimeters);
        } else {
            System.out.println("error");

        }

    }
    private boolean checkIfValuesCorrect(Double meters, Double centimeters, Double milimeters) {
        if (meters != null) {
            if (centimeters != null) {
                return false;
            } else {
                if (milimeters != null) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            if (centimeters != null) {
                if (milimeters != null) {
                    return false;
                } else {
                    return true; }
                else {
                    if (milimeters != null) {
                        return true;
                    }
                }
            }
        }
    }
    //
//
//        if (centymetry.isEmpty() && milimetry.isEmpty() ) {
//            response.getWriter().print("Podana wartość w przeliczeniu na: ");
//            response.getWriter().print("metry: " + meters);
//            response.getWriter().print("centymetry: " + meters / 100);
//            response.getWriter().print("milimetry: " + meters / 1000);
//        } else if (metry.isEmpty() && milimetry.isEmpty()) {
//            response.getWriter().print("Podana wartość w przeliczeniu na: ");
//            response.getWriter().print("metry: " + centimeters / 100);
//            response.getWriter().print("centymetry: " + centimeters);
//            response.getWriter().print("milimetry: " + centimeters * 10);
//        } else if (metry.isEmpty() && centymetry.isEmpty()) {
//            response.getWriter().print("Podana wartość w przeliczeniu na: ");
//            response.getWriter().print("metry: " + milimeters / 100);
//            response.getWriter().print("centymetry: " + milimeters);
//            response.getWriter().print("milimetry: " + milimeters * 10);
//        }
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }
}
