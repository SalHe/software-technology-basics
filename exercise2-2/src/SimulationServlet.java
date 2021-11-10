import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SimulationServlet", urlPatterns = "/SimulationServlet")
public class SimulationServlet extends HttpServlet {
    private static final int DEBUG = 10;

    public void doGet(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
        doPost(paramHttpServletRequest, paramHttpServletResponse);
    }

    public void doPost(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws ServletException, IOException {
        paramHttpServletResponse.setCharacterEncoding("utf-8");

        int numTimeBlocks = 0;
        HttpSession httpSession = paramHttpServletRequest.getSession();
        paramHttpServletResponse.setContentType("text/html");
        PrintWriter printWriter = paramHttpServletResponse.getWriter();
        String numTimeBlocksString = paramHttpServletRequest.getParameter("numTimeBlocks");

        // 判断是否来自于 initialWorldFish.html 提交的
        // 如果是，那么下面的参数不为null。
        if (numTimeBlocksString != null) {
            numTimeBlocks = Integer.parseInt(numTimeBlocksString);
            Simulation simulation1 = new Simulation(0, 0, 9, 9);
            Map<String, String[]> parameters = paramHttpServletRequest.getParameterMap();
            Set<String> set = parameters.keySet();
            for (String str : set) {
                if (str.equals("Submit") || str.equals("numTimeBlocks"))
                    continue;

                // 找到catfish参数，是个数组
                String[] arrayOfString = parameters.get(str);
                for (String s : arrayOfString) LivingBeing.createLivingBeing(simulation1, str, s);
            }
            if (numTimeBlocks > 0)
                paramHttpServletResponse.setHeader("Refresh", "1");
            printWriter.print(SimulationView.getHtml(simulation1, "即将开始"));
            httpSession.setAttribute("simulation", simulation1);
            httpSession.setAttribute("totalTimeBlocksToSimulate", numTimeBlocksString);
            return;
        }

        // 是来自自动刷新
        Simulation simulation = (Simulation) httpSession.getAttribute("simulation");
        String totalTimeBlocksToSimulateString = (String) httpSession.getAttribute("totalTimeBlocksToSimulate");
        if (totalTimeBlocksToSimulateString != null)
            numTimeBlocks = Integer.parseInt(totalTimeBlocksToSimulateString);
        boolean inProgress = simulation.getTime() < numTimeBlocks - 1;
        if (inProgress) // 是否将时间迭代到需要的时间了，如果没有，让网页自动刷新
            paramHttpServletResponse.setHeader("Refresh", "1");
        simulation.simulateATimeBlock();
        printWriter.print(SimulationView.getHtml(simulation, inProgress ? ("当前时间：" + simulation.getTime()) : "已结束"));
    }
}
