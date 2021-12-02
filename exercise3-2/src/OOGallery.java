import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OOGallery extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        /**
         *  Indicate the content type (for example, text/html),
         *  being returned by the response
         */
        response.setContentType("text/html");

        /**
         * 	Retrieve an output stream to use to send data to the client
         */
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        /**
         *	 Get the user input from the form
         */
        String bgrnd = request.getParameter("bgrnd");
        String theme = request.getParameter("theme");

        if (!"Rain".equals(bgrnd) && !"Spring".equals(bgrnd) && !"Sunshine".equals(bgrnd)) {
            out.println("请选择正确的背景！");
            return;
        }
        if (!"Animal".equals(theme) && !"Flower".equals(theme)) {
            out.println("请选择正确的主题！");
            return;
        }

        /**
         * 	Create an instance of the HtmlPage class
         */
        HtmlPage htmlPage = new HtmlPage();

        /**
         *  Set the title for the response Web page
         */
        htmlPage.setTitle("OOGallery using HtmlPage");

        /**
         * 	Create an instance of the HtmlImage class for the first image
         */
        HtmlImage htmlImage1 = new HtmlImage(theme + "One.jpg", theme + 1);

        /**
         * 	Create an instance of the HtmlImage class for the second image
         */
        HtmlImage htmlImage2 = new HtmlImage(theme + "Two.jpg", theme + 2);

        /**
         * 	Set the attributes of the HtmlPage object
         */
        htmlPage.setBackgroundImage(bgrnd + ".gif");

        /**
         * 	Add the images
         */
        htmlPage.addText(htmlImage1.buildHtml());
        htmlPage.addText(htmlImage2.buildHtml());

        /**
         *	 Construct the HTML response
         */
        out.println(htmlPage.buildHtml());

    }
}
