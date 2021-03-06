package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる

		// ユーザ一覧情報を取得
		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);
		//左が合言葉 右が使いたいデータがはいってるもの

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					// TODO  未実装：検索処理全般

					// リクエストパラメータの文字コードを指定
					request.setCharacterEncoding("UTF-8");

					//リクエストパラメータを取得
					String loginId = request.getParameter("login-id");
					String name = request.getParameter("user-name");
					String birth_date_start = request.getParameter("date-start");
					String birth_date_end = request.getParameter("date-end");
//					String password = request.getParameter("password");
//					String password2 = request.getParameter("password2");

					//userSearchメソッドを呼び出す。
					UserDao userDao = new UserDao();
					List<User> userList = userDao.userSearch(loginId, name, birth_date_start,birth_date_end);


					// リクエストスコープにユーザ一覧情報をセット
					request.setAttribute("userList", userList);


					// ユーザ一覧のjspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
					dispatcher.forward(request, response);
	}
}
