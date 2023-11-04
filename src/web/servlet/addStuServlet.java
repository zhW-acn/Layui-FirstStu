package web.servlet;

import bean.Student;
import com.alibaba.fastjson.JSONObject;
import dao.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/01/15:44
 */
public class addStuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // JSON字符串
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
//        String jsonString = URLDecoder.decode(sb.toString(),"utf8");
        String jsonString = sb.toString();
        // 转Student
        Student student = JSONObject.parseObject(jsonString, Student.class);
        // 调dao
        DB.addStu(student);
//        PrintWriter writer = resp.getWriter();
//
//        String stuName = req.getParameter("stuName");
//        String stuSex = req.getParameter("stuSex");
//        int stuAge = Integer.parseInt(req.getParameter("stuAge"));
//        String stuClazz = req.getParameter("stuClazz");
//        Student student = new Student(stuName, stuSex, stuAge, stuClazz);
//
//        //dao
//        if (DB.addStu(student)) {
//            writer.write("success");
//        }else {
//            writer.write("failure");
//        }

//        req.getRequestDispatcher("/student.html").forward(req, resp);
    }
}
