package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodolistDAO extends DAO {
	
	public List<Todolist> TodolistList() {
		connect();
		List<Todolist> list = new ArrayList<>();
		String sql = "SELECT * FROM TODOLIST ORDER BY 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Todolist todo = new Todolist();
				todo.setTodoId(rs.getInt("todo_id"));
				todo.setContent(rs.getString("content"));
				todo.setYn(rs.getString("y_n"));
				list.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public void insertTodolist(Todolist todo) {
		connect();
		String sql = "INSERT INTO TODOLIST VALUES(TODO_SEQ.NEXTVAL,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, todo.getContent());
			psmt.setString(2, todo.getYn());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public void deleteTodolist(Todolist todo) {
		connect();
		String sql = "DELETE FROM TODOLIST WHERE TODO_ID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, todo.getTodoId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//체크 update

}
