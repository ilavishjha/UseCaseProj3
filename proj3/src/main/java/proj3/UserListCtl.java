package proj3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserDTO	dto=null;
	UserModel model=new UserModel();
	List list=model.search(dto);
	req.setAttribute("List", list);
	RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
	rd.forward(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String op=req.getParameter("operation");
	UserDTO dto=null;
	UserModel model= new UserModel();
	System.out.println("lavishhhhh.....");
	
	if (op!=null && op.equalsIgnoreCase("search")) {
		System.out.println("agya malik");
	     dto=new UserDTO();
		dto.setName(req.getParameter("name"));
		dto.setAddress(req.getParameter("address"));
	}
	if (op.equalsIgnoreCase("delete")) {
		System.out.println("pahuch gya hu");
		String[] ids=req.getParameterValues("ids");
		for (String id : ids) {
			UserDTO amit=new UserDTO();
			amit.setId(Integer.parseInt(id));
			model.delete(amit);
		}
		
	}
		List list=model.search(dto);
		System.out.println("hmmm......");
		req.setAttribute("List", list);
		RequestDispatcher rd=req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
		


	}
	}




