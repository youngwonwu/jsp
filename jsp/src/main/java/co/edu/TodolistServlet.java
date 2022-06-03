package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/todolistServlet")
public class TodolistServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		TodolistDAO dao = new TodolistDAO();
		List<Todolist> list = dao.TodolistList();
		System.out.println(list);
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(list));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodolistDAO dao = new TodolistDAO();
		
		String cont = req.getParameter("content");
		Todolist todo = new Todolist();
		todo.setContent(cont);
		
		dao.insertTodolist(todo);
	}

}
