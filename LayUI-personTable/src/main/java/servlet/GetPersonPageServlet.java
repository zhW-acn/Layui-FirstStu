package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import entity.DataDemo;
import entity.Person;
import service.PersonService;
import serviceImpl.PersonServiceImpl;

/**
 * Servlet implementation class GetPersonPageServlet
 */
@WebServlet("/GetPersonPageServlet")
public class GetPersonPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonService personService =new PersonServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPersonPageServlet() {
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
		int page=Integer.parseInt(request.getParameter("page"));
		int limit=Integer.parseInt(request.getParameter("limit"));
		List <Person> persons=null;
		try {
		persons=personService.getAllPesonByPage(page, limit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataDemo demo= new DataDemo();
		demo.setCode(0);
		demo.setMsg("");
		try {
			demo.setCount(personService.getPesonCount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo.setData(persons);
		
		
		
		response.getWriter().write(JSONObject.toJSONString(demo));
		
	}

}
