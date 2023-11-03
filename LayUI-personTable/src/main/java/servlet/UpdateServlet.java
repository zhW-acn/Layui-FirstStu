package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import entity.Person;
import service.PersonService;
import serviceImpl.PersonServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonService personService=new PersonServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person person=new Person();
		person.setId(Integer.parseInt(request.getParameter("id")));
		person.setUsername(request.getParameter("username"));
		person.setPassword(request.getParameter("password"));		
		int i=0;
		boolean flag = false;
		try {
			i=personService.updatePerson(person);
			if(i==0) {
				flag = false;
			}else {
				flag =true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		JSONObject jsonObject =new JSONObject();	
		// 判断
		if (flag == true) {
			jsonObject.put("code", 200);
		} else {
			jsonObject.put("code", "");
		}
		out.print(jsonObject);
		out.flush();
		out.close();

		request.getRequestDispatcher("data.jsp").forward(request, response);
		
	}
		


}
