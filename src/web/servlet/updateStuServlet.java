package web.servlet;

import bean.Student;
import dao.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/01/19:33
 */
public class updateStuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id").trim());
        System.out.println(id);
        String stuName = req.getParameter("stuName");
        String stuSex = req.getParameter("stuSex");
        int stuAge = Integer.parseInt(req.getParameter("stuAge"));
        String stuClazz = req.getParameter("stuClazz");
        Student student = new Student(id,stuName,stuSex,stuAge,stuClazz);

        //dao
        DB.updateStu(student);
    }
}
