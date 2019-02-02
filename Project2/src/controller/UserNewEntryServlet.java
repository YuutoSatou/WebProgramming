package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserNewEntryServlet
 */
@WebServlet("/UserNewEntryServlet")
public class UserNewEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserNewEntryServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	//doGetとdoPostの両方が必要である。

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNewEntry.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータを取得 (修正済み2019/2/1)
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("UserName");
		String birth_date = request.getParameter("Birth");

		//ＪＳＰのnameと、この部分のgetParameterの文字列を一致させること。

		//リクエストパラメータをチェック
		String errorMsg = "";
		if (name == null || loginId.length() == 0) {
			System.out.println("ログインＩＤが入力されていません");
		}

		if (name == null || password.length() == 0) {
			System.out.println("パスワードが入力されていません");
		}

		if (name == null || password2.length() == 0) {
			System.out.println("確認用パスワードが入力されていません");
		}

		if (name == null || name.length() == 0) {
			System.out.println("名前が入力されていません");
		}

		if (name == null || birth_date.length() == 0) {
			System.out.println("誕生日が入力されていません");
		}
		UserDao userDao = new UserDao();
		userDao.userInsert(loginId, password, password2, name, birth_date);//Ctrl＋スペース


		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");

	}
}

//★DAOのログインメソッドと動作が同じである。



//		if (!password.equals(password2)) {
//			//リクエストスコープにエラーメッセージをセット
//			request.setAttribute("errMsg", "パスワードが一致しておりません");
//			//新規登録jspにフォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNewEntry.jsp");
//			dispatcher.forward(request, response);
//			return;
//		}
//		//入力項目に一つでも未入力のものがある場合の登録失敗仕様
//		if (loginId.isEmpty() || password.isEmpty() || name.isEmpty() || birth_date.isEmpty() || password2.isEmpty()) {
//			//リクエストスコープにエラーメッセージをセット
//			request.setAttribute("errMsg", "入力項目に未入力のものがあります");
//			//新規登録jspにフォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNewEntry.jsp");
//			dispatcher.forward(request, response);
//			return;
//		}


//	searchByLoginIdメソッドは、UserDao.javaで未作成。
//
//	//既に登録されているログインIDが入力された場合の登録失敗仕様
//	UserDao userDao = new UserDao();
//	model.User user = userDao.searchByLoginId(loginId); //DAOの処理
//	if(user != null) {
//		//リクエストスコープにエラーメッセージをセット
//		request.setAttribute("errMsg","入力された内容は正しくありません");
//		//新規登録jspにフォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserNewEntry.jsp");
//			dispatcher.forward(request, response);
//			return;
//		}
//	//リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
//		userDao.userInsert(loginId, password2, name, birth_date);
//		//ユーザ一覧のサーブレットにリダイレクト
//		//リダイレクトは指定した名前のサーブレットにGETアクセス
//		response.sendRedirect("users");
//	}
//}
