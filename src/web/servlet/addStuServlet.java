package web.servlet;

import bean.Student;
import com.alibaba.fastjson.JSONObject;
import dao.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/01/15:44
 */
public class addStuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // JSON字符串
//        String jsonString = req.getReader().readLine();
//        System.out.println(jsonString);
//        // 转Student
//        Student student = JSONObject.parseObject(jsonString, Student.class);
//        // 调dao
//        System.out.println(student);
        String stuName = req.getParameter("stuName");
        String stuSex = req.getParameter("stuSex");
        int stuAge = Integer.parseInt(req.getParameter("stuAge"));
        String stuClazz = req.getParameter("stuClazz");
        Student student = new Student(stuName, stuSex, stuAge, stuClazz);

        //dao
        DB.addStu(student);

//        req.getRequestDispatcher("/student.html").forward(req, resp);
    }
}
