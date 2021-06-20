package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDO.B;
import itTalkDO.Ts;


public class MainDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	// 실시간 인기 게시글 10개(조회수+댓글수:1시간마다 업뎃(이용자층 고려)) view에서 자바스크립트 이용
	public ArrayList<String> getHits() {
		conn= DBManager.connect();
		ArrayList<String> Hits=new ArrayList();
		String sql="SELECT b_no,mb_no,bc_no,b_title,b_write,b_file,b_date,b_hits,b_deleted,b_report,b_cnt,b_hits+b_cnt as b_total from B Order by b_total desc limit 0,10";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Hits.add(rs.getString("b_no"));
				Hits.add(rs.getString("mb_no"));
				Hits.add(rs.getString("bc_no"));
				Hits.add(rs.getString("b_title"));
				Hits.add(rs.getString("b_write"));
				Hits.add(rs.getString("b_file"));
				Hits.add(rs.getString("b_date"));
				Hits.add(rs.getString("b_hits"));		
				Hits.add(rs.getString("b_deleted"));
				Hits.add(rs.getString("b_report"));
				Hits.add(rs.getString("b_cnt"));
				Hits.add(rs.getString("b_total"));
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return Hits;
	}
	
	
	// 메인에 출력 메소드
	public ArrayList<Ts> top(){
		
		ArrayList<Ts> topMain = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from Ts";
			pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Ts ts=new Ts();
				
				ts.setTs_no(rs.getInt("ts_no"));
				ts.setB_no(rs.getInt("b_no"));
				ts.setB_title(rs.getString("b_title"));
				topMain.add(ts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return topMain;
	}
	
	
	// 제목&내용 검색 기능 -> 검색한 게시물 목록 전체 출력 // getKeyword = 사용자가 검색 창에 입력한 값
	
	public ArrayList<B> find(String getKeyword){
		
		ArrayList<B> findB = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select b_title,b_write from B where b_title like '%?%' and b_write like '%?%'";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, getKeyword);
			pstmt.setString(2, getKeyword);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				
				b.setB_title(rs.getString("b_title")); // 안될 시 1
				b.setB_write(rs.getString("b_write")); // 안될 시 2
				findB.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return findB;
	}
}
