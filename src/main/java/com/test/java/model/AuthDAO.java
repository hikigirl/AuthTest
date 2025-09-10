package com.test.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthDAO {
	// 메서드에서 공통으로 사용하므로 여기로 옮기고 private
	// 멤버 변수
	private DBUtil util;
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	// 생성자
	public AuthDAO() {
		try {
			util = new DBUtil();
			conn = util.open();
			stat = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// LoginOk.java -> 인증 위한 select
	public UserDTO login(UserDTO dto) {
		try {
			String sql = "SELECT * FROM tblUser WHERE id=? AND pw=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			if (rs.next()) {
				//인증성공 -> 인증 티켓 발급(세션 방식)
				UserDTO result = new UserDTO();
				
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setGrade(rs.getString("grade"));
			
				return result;	
				
			} else {
				//인증실패
				return null;
			}
			
		} catch (Exception e) {
			// handle exception
			System.out.println("AuthDAO.login()");
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
