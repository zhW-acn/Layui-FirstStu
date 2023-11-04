package web.servlet;

import bean.JSONConstruct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/01/10:23
 */
public class JSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 当前页
        int pageIndex = Integer.parseInt(req.getParameter("page"));
        // 分页大小
        int pageSize = Integer.parseInt(req.getParameter("limit"));
        // 拿到json
        String string = new JSONConstruct(0, "你好", pageIndex, pageSize).toString();
        PrintWriter writer = resp.getWriter();

        resp.setContentType("application/json");

        writer.write(string);
        writer.flush();
    }
}
