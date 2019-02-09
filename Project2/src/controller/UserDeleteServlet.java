package controller;

import java.io.IOException;

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
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")	//アノテーション
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログインをしているかしていないかのチェックをする。
		HttpSession session = request.getSession();

		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		// TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDao userDao = new UserDao();	//インポートを追加
		User user = userDao.findById(Integer.parseInt(id));	//インポートを追加

		// TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
		request.setAttribute("user", user);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDelete.jsp");
		dispatcher.forward(request,  response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// リクエストパラメータの文字コードを指定
	request.setCharacterEncoding("UTF-8");

	//リクエストパラメータを取得
	String loginId = request.getParameter("loginId");
//	String password = request.getParameter("password");
//	String password2 = request.getParameter("password2");
//	String name = request.getParameter("UserName");
//	String birth_date = request.getParameter("Birth");

	//userUpdateメソッドを呼び出す。
	UserDao userDao = new UserDao();
	userDao.userDelete(loginId);

	// ユーザ一覧のサーブレットにリダイレクト
	response.sendRedirect("UserListServlet");

}

}

//		// URLからGETパラメータとしてIDを受け取る
//		String id = request.getParameter("id");
//		request.setAttribute("id", id); //idに変更した。
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDelete.jsp");
//		dispatcher.forward(request, response);


