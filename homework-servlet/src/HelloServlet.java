import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        String html = "<h1>我成功啦！</h1>";
        writer.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String idNumber = req.getParameter("id-number");
        String gender = req.getParameter("gender");
        if (name == null || idNumber == null || (!"male".equals(gender) && !"female".equals(gender))) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "传递的参数有误！");
            return;
        }

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        String html = "<h1>欢迎来到第一个Servlet！</h1>" +
                "<span>您的名字是：</span>" + name +
                "<br>" +
                "<span>您的学号是：</span>" + idNumber +
                "<br>" +
                "<span>您是一个：</span>" + ("male".equals(gender) ? "男孩" : "女孩");
        writer.println(html);
    }
}
