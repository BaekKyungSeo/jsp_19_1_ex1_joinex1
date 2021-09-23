package com.javasiyeon.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */

@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private Connection connection;
	private Statement stmt;

	private String name,id,pw,pw2,phone1,phone2,phone3,gender;

	HttpSession httpsession;

	public ModifyOk() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//�ѱ�ó��
		request.setCharacterEncoding("EUC-KR");
		httpsession = request.getSession(); // �ټ������� ���簪�� �ҷ����� ������ �ʿ��ϴ�!
		
		//�Ķ���;�
		name = request.getParameter("name");
		//id = request.getParameter("id");
		id = (String)httpsession.getAttribute("id");
		pw = request.getParameter("pw");
		pw2 = (String)httpsession.getAttribute("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");

		if(pwCheck()) {

			String query =    "update members set name='"+name+"',phone1='"+phone1+"',phone2='"+phone2+"',phone3='"+phone3+"',gender='"+gender+"' where id='"+id+"' ";

			//try catch ��
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
				stmt = connection.createStatement();

				int i  = stmt.executeUpdate(query); // ������ �����ϸ� int �� ���� 1�� ��ȯ

				if(i==1) {
					System.out.println("���� ���� ����"); // �ܼ�â�� ����ֱ�
					httpsession.setAttribute("name", name); //������ �̸��� ���ǿ� overwrite
					response.sendRedirect("modifyResult.jsp"); // �������� ���� �� modifyResult.jsp�� �̵�
				} else {
					System.out.println("���� ���� ����"); // �ܼ�â�� ����ֱ�
					response.sendRedirect("modify.jsp"); // ���������� �����ϸ� modify.jsp�� �̵��Ͽ� �ٽ� ���� �Է�
				}

				//����ó������������
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {

					if(stmt != null) stmt.close();
					if(connection != null) connection.close();

				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("��й�ȣ�� Ʋ���ϴ�."); // ��й�ȣ Ʋ�� �޼��� ���
			response.sendRedirect("modify.jsp");
		}


	}
	private boolean pwCheck() {
		
		boolean rs = false;
		
		String sessionPw = (String)httpsession.getAttribute("pw");
		
		if(sessionPw.equals(pw)) {
			rs = true;
		} else {
			rs = false;
		}
		
		return rs;
	}

}