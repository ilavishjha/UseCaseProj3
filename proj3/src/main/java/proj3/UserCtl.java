package proj3;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj3.UserDTO;
import proj3.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO dto = null;
		UserModel model = new UserModel();
		String id = request.getParameter("id");
		if (id != null) {
			dto = model.findByPk(Integer.parseInt(id));
			request.setAttribute("dto", dto);
		}
		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String id = req.getParameter("id");
		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();
		dto.setName(req.getParameter("name"));
		dto.setAddress(req.getParameter("address"));
		String op = req.getParameter("operation");
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("msg", "User Updated Successfully...!!");
			req.setAttribute("dto", dto);
			System.out.println("............................");
			RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
			rd.forward(req, resp);
		} else if (op.equalsIgnoreCase("save")) {
			model.add(dto);
			req.setAttribute("msg","User Added" );
			RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
			rd.forward(req, resp);
		}else if (op.equalsIgnoreCase("AddUser")) {
			resp.sendRedirect("UserView.jsp");
			
		}else if (op.equalsIgnoreCase("cancel")) {
			resp.sendRedirect("UserListCtl");
          
		}

	}

}