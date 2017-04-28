package cn.mldn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMemberDAO;
import cn.mldn.util.dbc.DatabaseConnection;
import cn.mldn.vo.Member;

public class MemberDAOImpl implements IMemberDAO{
	private Connection conn;
	private PreparedStatement pstmt;
	public MemberDAOImpl() {
		this.conn=DatabaseConnection.getConnection();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql="INSERT INTO member(mid,name,birthday,sal,note,del) VALUES(?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
		this.pstmt.setDouble(4, vo.getSal());
		this.pstmt.setString(5, vo.getNote());
		this.pstmt.setInt(6, vo.getDel());
		return this.pstmt.executeUpdate()>0;
		
		// TODO Auto-generated method stub
	}
	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Member> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Member findById(String id) throws SQLException {
		String sql="SELECT mid,name,birthday,sal,note,del FROM member WHERE mid=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();
		Member vo=null;
		if(rs.next()){
			vo=new Member();
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSal(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
		}
		return vo;	
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Member> findAllByDelete(Integer del) throws SQLException {
		List<Member> all = new ArrayList<Member>() ; 
		String sql = "SELECT mid,name,birthday,sal,note,del FROM member WHERE del=?" ; 
		this.pstmt = DatabaseConnection.getConnection().prepareStatement(sql) ; 
		this.pstmt.setInt(1, del); 
		ResultSet rs = this.pstmt.executeQuery() ; 
		while (rs.next()) { 
			Member vo = new Member() ; 
			vo.setMid(rs.getString(1)); 
			vo.setName(rs.getString(2)); 
			vo.setBirthday(rs.getDate(3)); 
			vo.setSal(rs.getDouble(4)); 
			vo.setNote(rs.getString(5)); 
			vo.setDel(rs.getInt(6)); 
			all.add(vo) ; 
			} 
		return all ;
		// TODO Auto-generated method stub
		
	}
	@Override
	public Member findByIdAndDelete(String id, Integer del) throws SQLException {
		String sql="SELECT mid,name,birthday,sal,note,del FROM member WHERE mid=? AND del=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		this.pstmt.setInt(2, del);
		ResultSet rs=this.pstmt.executeQuery();
		Member vo=null;
		if(rs.next()){
			vo=new Member();
			vo.setMid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setBirthday(rs.getDate(3));
			vo.setSal(rs.getDouble(4));
			vo.setNote(rs.getString(5));
			vo.setDel(rs.getInt(6));
		}
		return vo;	
		// TODO Auto-generated method stub
	
	}
	@Override
	public boolean doUpdateByDelete(Member vo, Integer del) throws SQLException {
		String sql="UPDATE member SET name=?,birthday=?,sal=?,note=? WHERE mid=? AND del=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setDate(2, new java.sql.Date(vo.getBirthday().getTime()));
		this.pstmt.setDouble(3, vo.getSal());
		this.pstmt.setString(4, vo.getNote());
		this.pstmt.setString(5, vo.getMid());
		this.pstmt.setInt(6, del);
		return this.pstmt.executeUpdate()>0;
		// TODO Auto-generated method stub
	}
	@Override
	public boolean doUpdateDelete(Set<String> ids) throws SQLException {
		StringBuffer buf=new StringBuffer();
		buf.append("UPDATE member SET del=1 WHERE mid IN(");
		Iterator<String> iter=ids.iterator();
		while(iter.hasNext()){
			buf.append("'").append(iter.next()).append("'").append(" ,");
		}
		buf.delete(buf.length()-1, buf.length()).append(")");
		System.out.println(buf);
		this.pstmt=this.conn.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate()>0;
		// TODO Auto-generated method stub
	}
	@Override
	public boolean doCreateBatch(Set<Member> allMembers) throws SQLException {
		String sql="INSERT INTO member(mid,name,birthday,sal,note,del) VALUES(?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		Iterator<Member> iter=allMembers.iterator();
		while(iter.hasNext()){
			Member vo=iter.next();
			this.pstmt.setString(1, vo.getMid());
			this.pstmt.setString(2, vo.getName());
			this.pstmt.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
			this.pstmt.setDouble(4, vo.getSal());
			this.pstmt.setString(5, vo.getNote());
			this.pstmt.setInt(6, vo.getDel());
			this.pstmt.addBatch();
		}
		int result[]= this.pstmt.executeBatch();
		for(int x = 0;x < result.length;x++){
			if(result[x] ==0 ){
				return false;
			}
			return true;
		}
		return false;
		
		
	}

}
