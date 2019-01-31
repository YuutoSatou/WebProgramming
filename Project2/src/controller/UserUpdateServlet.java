//2019/1/28時点(変更前)
//
//
//package controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.UserDao;
//import model.User;
//
///**
// * Servlet implementation class UserUpdateServlet
// */
//@WebServlet("/UserUpdateServlet")
//public class UserUpdateServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public UserUpdateServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//    /**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// URLからGETパラメータとしてIDを受け取る
//		String id = request.getParameter("id");
//
//		// 確認用：idをコンソールに出力
//		System.out.println(id);
//
//
//		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
//		UserDao userDao = new UserDao();	//インポートを追加
//		User user = userDao.findById(Integer.parseInt(id));	//インポートを追加
//
//		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
//		request.setAttribute("user", user);
//		//インポートを追加
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
//		dispatcher.forward(request, response);
//
//	}
//
package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

	/**
	 * Servlet implementation class infoUpdate
	 */
	@WebServlet("/UserUpdate")
	public class UserUpdateServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UserUpdateServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub

			//?????????????????????????????
			HttpSession session = request.getSession();

			if(session.getAttribute("users") == null) {
				response.sendRedirect("login");
				return;
			}

			 // リクエストパラメータの文字コードを指定
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("id");

			UserDao userDao = new UserDao();
			User userInfo = userDao.findUserById(id);

			request.setAttribute("user", userInfo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request,  response);

		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// リクエストパラメータの文字コードを指定
			request.setCharacterEncoding("UTF-8");

			//パラメータ
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			String name = request.getParameter("name");
			String birth_date = request.getParameter("birth_date");
			String loginId = request.getParameter("loginId");

			UserDao userDao = new UserDao();

			/** ???????????(??)??????????? **/
			if(!password.equals(password2)) {
				//エラーメッセージ
				request.setAttribute("errMsg","???????????????");

				User user = new User();
				user.setLoginId(loginId);
				user.setName(name);
				try {
					user.setBirthDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birth_date).getTime()));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				request.setAttribute("user", user);

				//新規登録jspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/infoUpdate.jsp");
				dispatcher.forward(request, response);
				return;
			}

			/** ??????????????????? **/

			if(name.isEmpty() || birth_date.isEmpty()) {
				//エラーメッセージ
				request.setAttribute("errMsg","????????????????");

				User user = new User();
				user.setLoginId(loginId);
				user.setName(name);
				try {
					user.setBirthDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birth_date).getTime()));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				request.setAttribute("user", user);


				//新規登録jspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/infoUpdate.jsp");
				dispatcher.forward(request, response);
				return;
			}

			if(password.isEmpty() && password2.isEmpty()) {
				//Dao
				userDao.updateInsert(name, birth_date, loginId);

			}else {

			//Dao
			userDao.userUpdate(password, name, birth_date, loginId);
			}

			// GET
			response.sendRedirect("users");

		}

	}









//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//}
