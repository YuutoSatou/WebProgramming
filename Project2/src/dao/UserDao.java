//2019/2/7 更新(userDeleteメソッドを追記した。)
package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import javax.xml.bind.DatatypeConverter;

import model.User;

/**
 * ユーザテーブル用のDao
 * @author takano
 *
 */
public class UserDao {

	/**
	 * ログインIDとパスワードに紐づくユーザ情報を返す
	 * @param loginId
	 * @param password
	 * @return
	 */
	public User findByLoginInfo(String loginId, String password) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId); //Stringをセット
			pStmt.setString(2, password); //Stringをセット
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id"); //カラム名
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	/**
	 * 全てのユーザ情報を取得する
	 * @return
	 */
	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement(); //stmtを定義
			ResultSet rs = stmt.executeQuery(sql); //rsを定義

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close(); //切断処理
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList; //userListを返す。
	}

	/**
	 * IDに紐づくユーザ情報を返す
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			int returnId = rs.getInt("id");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = ""; // 画面に表示しませんし、セキュリティ上の観点からもResultSetのパスワードはセットしないほうが良いのではないかと思います。
			String updateDate = rs.getString("update_date");
			String createDate = rs.getString("create_date");
			return new User(returnId, loginId, name, birthDate, password, updateDate, createDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}
	//登録ボタンのメソッド
	public void userInsert(String id, String password, String password2, String name, String birth_date) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			//insert文を準備(修正2019/2/2)
			String sql = "INSERT INTO user(login_id,password,name,birth_date,create_date,update_date)VALUES(?,?,?,?,now(),now());";
			//INSERTを実行
			PreparedStatement stmt = conn.prepareStatement(sql);

			//ハッシュを生成したい元の文字列
			String source = password; //パスワードを隠す処理。
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";
			//ハッシュ生成処理
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			//コメントアウト
			//String result = DatatypeConverter.printHexBinary(bytes);

			stmt.setString(1, id);
			stmt.setString(2, password);
			stmt.setString(3, name);
			stmt.setString(4, birth_date);

			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//return null;

			}
		}
	}
	//更新ボタンのメソッド
	public void userUpdate(String id, String password, String name, String birth_date) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			//insert文を準備(修正2019/2/2)
			String sql = "UPDATE user set password=?,name=?,birth_date=?,update_date=now() where login_id=?;";
			//INSERTを実行
			PreparedStatement stmt = conn.prepareStatement(sql);

			//ハッシュを生成したい元の文字列
			String source = password; //パスワードを隠す処理。
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";
			//ハッシュ生成処理
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			//コメントアウト
			//String result = DatatypeConverter.printHexBinary(bytes);

			//修正済み2019/2/2
			stmt.setString(1, password);
			stmt.setString(2, name);
			stmt.setString(3, birth_date);
			stmt.setString(4, id);

			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//return null;

			}
		}
	}
	//削除ボタンのメソッド
		public void userDelete(String id) {
			Connection conn = null;
			try {
				// データベースへ接続
				conn = DBManager.getConnection();

				//DELETE文を準備(修正2019/2/7)DELETE文の基礎文法はわかったが、この部分がわからない。
				String sql = "DELETE FROM user WHERE login_id=?;";

				//宣言の準備
				PreparedStatement stmt = conn.prepareStatement(sql);

//				//ハッシュを生成したい元の文字列
//				String source = password; //パスワードを隠す処理。
//				//ハッシュ生成前にバイト配列に置き換える際のCharset
//				Charset charset = StandardCharsets.UTF_8;
//				//ハッシュアルゴリズム
//				String algorithm = "MD5";
//				//ハッシュ生成処理
//				byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));

				//セットストリング　
				stmt.setString(1, id);
//				stmt.setString(2, password);
//				stmt.setString(3, name);
//				stmt.setString(4, birth_date);

				stmt.executeUpdate();
				stmt.close();

				//「もしくは」を削除する。
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// データベース切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					//return null;

				}
			}
		}



//「更新」ボタンで使用するため、コメントアウト。
//	public User searchByLoginId(String loginId) {
//		Connection conn = null;
//		try {
//			//データベースへ接続
//			conn = DBManager.getConnection();
//			// SELECT文を準備
//			String sql = "SELECT * FROM user WHERE loginId = ?";
//			// SELECT文を実行し、結果表を取得
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, loginId);
//			ResultSet rs = pStmt.executeQuery();
//			//主キーに紐づくレコードは１件のみなので、rs.next()は１回だけ行う
//			if (!rs.next()) {
//				return null;
//			}
//			String loginIdData = rs.getString("login_id");
//			if (loginIdData == null) {
//				return null;
//			} else {
//				return new User(loginIdData);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			//データベース切断
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//					return null;
//				}
//			}
//		}
//	}

}
