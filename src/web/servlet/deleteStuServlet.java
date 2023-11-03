package web.servlet;

import dao.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
 * @author: acn
 * @date: 2023/11/01/14:55
 */
public class deleteStuServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null){ // 不是删除一个，或者前端可以传一个假数据，判断一下
            String idsStr = req.getParameter("ids");
            System.out.println("将要删除id为："+idsStr);
            String[] ids = idsStr.split(",");
            for (String id : ids) {
                DB.deleteStuById(Integer.parseInt(id));
                System.out.println("已删除id为"+id);
            }
        }else{
            int id = Integer.parseInt(req.getParameter("id"));
            DB.deleteStuById(id);
            System.out.println("id为" + id + "删除成功");
        }
    }
}
