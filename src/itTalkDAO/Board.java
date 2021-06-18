package itTalkDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import itTalkDO.B;
import itTalkDO.BoardSet;
import itTalkDO.C;

public class Board {

	Connection conn;
	PreparedStatement pstmt;
	
	// 게시글 불러오기
	public B Load(int b_no){//게시글 번호
		B b=new B();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_no=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_no);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시글 불러오기 실패");
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("게시글 불러오기 성공");
		return b;
	}
	
	// 이미지 삭제
		public boolean delF(HttpServletRequest req, HttpServletResponse res){//게시글 번호
			try {
				conn=DBManager.connect();
				String sql="select b_file from b where b_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,Integer.parseInt(req.getParameter("b_no")));
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				ServletContext context = req.getSession().getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. (서버의 절대경로를 구하는 데 필요)
				String saveDir = context.getRealPath("");
				String url = saveDir+rs.getString(1); 
				File uploadfile = new File (url);
				
				uploadfile.delete();       // 파일 삭제
				
				sql = "update b set b_file=' ' where b_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,Integer.parseInt(req.getParameter("b_no")));
				pstmt.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println("이미지 삭제 실패");
				e.printStackTrace();
				return false;
			}
			finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("이미지 삭제 완료");
			return true;
		}
		
		// 게시글 등록
		public void Upload (HttpServletRequest req, HttpServletResponse res) {
			ServletContext context = req.getSession().getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. (서버의 절대경로를 구하는 데 필요)
			String saveDir = context.getRealPath(""); // 절대경로를 가져옴

			int maxSize = 3 * 1024 * 1024; // 3MB
			String encoding = "euc-kr";
			
			// saveDir: 경로
					// maxSize: 크기제한 설정
					// encoding: 인코딩타입 설정
					// new DefaultFileRenamePolicy(): 동일한 이름일 경우 자동으로 (1),(2)..붙게 해줌
					boolean isMulti = ServletFileUpload.isMultipartContent(req);// boolean타입. ??????
					if (isMulti) {
						try {
							MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding,
									new DefaultFileRenamePolicy());
							conn=DBManager.connect();
							String sql = null;
							System.out.println(req.getParameter("b_no"));
							if(req.getParameter("b_no").equals("")) {
								sql="insert into b(mb_no,bc_no,b_title,b_write,b_file) values(?,?,?,?,?)";
								pstmt=conn.prepareStatement(sql);
								pstmt.setInt(1, Integer.parseInt(multi.getParameter("mb_no")));
								pstmt.setInt(2, Integer.parseInt(multi.getParameter("bc_no")));
								pstmt.setString(3, multi.getParameter("b_title"));
								pstmt.setString(4, multi.getParameter("b_write"));
								pstmt.setString(5, multi.getFilesystemName("b_file"));
								pstmt.executeUpdate();
							}
							else {
								if(multi.getFilesystemName("b_file")!=null) {
									new Board().delF(req, res); 
									sql="update b set bc_no=? , b_title=? , b_write=?,b_file=?,b_date=now() where b_no=?";
									pstmt=conn.prepareStatement(sql);
									pstmt.setInt(1, Integer.parseInt(multi.getParameter("bc_no")));
									pstmt.setString(2, multi.getParameter("b_title"));
									pstmt.setString(3, multi.getParameter("b_write"));
									pstmt.setString(4, multi.getFilesystemName("b_file"));
									pstmt.setString(5, req.getParameter("b_no"));
									pstmt.executeUpdate();
								}
								else {
									sql="update b set bc_no=? , b_title=? , b_write=?,b_date=now() where b_no=?";
									pstmt=conn.prepareStatement(sql);
									pstmt.setInt(1, Integer.parseInt(multi.getParameter("bc_no")));
									pstmt.setString(2, multi.getParameter("b_title"));
									pstmt.setString(3, multi.getParameter("b_write"));
									pstmt.setString(4, req.getParameter("b_no"));
									pstmt.executeUpdate();
								}
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} else {
						System.out.println("일반 전송 form 입니다.");
					}
			
		}
	
	// 게시글 출력
	public ArrayList<BoardSet> BoardPrint(int b_no){//게시글 번호

		ArrayList<BoardSet> datas=new ArrayList<>();
		BoardSet bs = new BoardSet();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_no=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, b_no);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				
				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				
				ArrayList<C> cs=new ArrayList<>();

				String sql2="select * from c where b_no=?";
				pstmt=conn.prepareStatement(sql2);
				pstmt.setInt(1, b_no);
				ResultSet rs2=pstmt.executeQuery();
				while(rs2.next()) {
					C c=new C();
					c.setC_no(rs2.getInt("c_no"));
					c.setB_no(rs2.getInt("b_no"));
					c.setMb_no(rs2.getInt("mb_no"));
				    c.setC_write(rs2.getString("c_weite"));
					c.setC_date(rs2.getString("c_date"));
					c.setC_secret(rs2.getBoolean("c_secret"));
					c.setC_deleted(rs2.getBoolean("c_deleted"));
					c.setC_report(rs2.getInt("c_report"));
					cs.add(c);
				}
				rs2.close();
				

				bs.setBoard(b);;
				bs.setRlist(cs);

				datas.add(bs);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("게시글 출력 실패");
			return null;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("게시글 출력 성공");
		return datas;
	}
	
	
	// 댓글 등록
	public boolean newReply(C c){//Comment
		try {
			conn=DBManager.connect();
			String sql="insert into reply (b_no,mb_no,c_write) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c.getB_no());
			pstmt.setInt(2, c.getMb_no());
			pstmt.setString(3, c.getC_write());
			pstmt.executeUpdate();
			
			sql="update b set b_cnt=b_cnt+1 where b_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c.getB_no());
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println("댓글 등록 실패");
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("댓글 등록 성공");
		return true;
	}
	
	
	// 게시글 삭제
		public boolean delB(HttpServletRequest req, HttpServletResponse res){//게시글 번호
			try {
				conn=DBManager.connect();
				String sql="select b_file from b where b_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,Integer.parseInt(req.getParameter("b_no")));
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				ServletContext context = req.getSession().getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. (서버의 절대경로를 구하는 데 필요)
				String saveDir = context.getRealPath("");
				String url = saveDir+rs.getString(1); 
				File uploadfile = new File (url);
				
				uploadfile.delete();       // 파일 삭제
				
				sql="delete from b where b_no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(req.getParameter("b_no")));
				pstmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("게시글 삭제 실패");
				return false;
			}
			finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("게시글 삭제 완료");
			return true;
		}
	
	// 댓글 삭제
	public boolean delC(int c_no){//댓글번호
		try {
			conn=DBManager.connect();
			String sql="delete from c where c_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("댓글 삭제 실패");
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("댓글 삭제 성공");
		return true;
	}
	
	// 게시글 좋아요
	public boolean like(int mb_no , int b_no) {//회원번호,게시글번호
		try {
			conn=DBManager.connect();
			String sql="insert into bs(mb_no , b_no) values (?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			pstmt.setInt(2, b_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("좋아요 실패");
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("좋아요 성공");
		return true;
	}
	
	// 게시글 조회수
	public void hits(int b_no) {//게시글 번호
		try {
			conn=DBManager.connect();
			String sql="update b set b_hits=b_hits+1 where b_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 게시글 신고
	public boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write) {//게시글번호,회원번호,신고카테고리번호,신고내용
		try {
			conn=DBManager.connect();
			String sql="insert into rc(b_no , mb_no , rctg_no , rc_write) values (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.setInt(2, mb_no);
			pstmt.setInt(3, rctg_no);
			pstmt.setString(4, rc_write);
			pstmt.executeUpdate();
			
			sql="update b set b_report=b_report+1 b_deleted=true, where b_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println("게시글 신고 실패");
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("게시글 신고 성공");
		return true;
	}

	// 댓글 신고
	public boolean ReportC(int c_no , int mb_no , int rctg_no , String rc_write) {//신고댓글,알림이 갈 회원,신고카테고리번호,신고내용
		try {
			conn=DBManager.connect();
			String sql="insert into rc(c_no , mb_no , rctg_no , rc_write) values (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			pstmt.setInt(2, mb_no);
			pstmt.setInt(3, rctg_no);
			pstmt.setString(4, rc_write);
			pstmt.executeUpdate();
			
			sql="update c set c_report=c_report+1,c_deleted=true where c_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("댓글 신고 실패");
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("댓글 신고 성공");
		return true;
	}
	
	
	
	
	// 검색 게시글 목록 출력(제목+내용)
	public ArrayList<B> titleSearch(String search){

		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_title=? or b_write=? ";
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, search);
			pstmt.setString(2, search);


			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();

				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				datas.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("검색 게시글 목록 출력 실패(제목+내용)");
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("검색 게시글 목록 출력 성공(제목+내용)");
		return datas;
	}
	
	// 검색 게시글 목록 출력(작성자)
	public ArrayList<B> nickSearch(String nick){
		
		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_nick=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, nick);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				
				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				datas.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("검색 게시글 목록 출력 실패(작성자)");
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("검색 게시글 목록 출력 성공(작성자)");
		return datas;
	}
	
	// 게시글 목록 출력
	public ArrayList<B> search(){
		
		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b";
			pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				
				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				datas.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("게시글 목록 출력 실패");
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("게시글 목록 출력 성공");
		return datas;
	}
	
	// 카테고리 게시글 목록 출력
	
	public ArrayList<B> bcSearch(String bc_no){
		
		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b where bc_no=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, bc_no);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				
				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				datas.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("카테고리 게시글 목록 출력 실패");
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("카테고리 게시글 목록 출력 성공");
		return datas;
	}
	
}
