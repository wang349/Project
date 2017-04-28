package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Member;

public interface IMemberDAO extends IBaseDAO<String, Member>{
	public List<Member> findAllByDelete(Integer del) throws SQLException ;
	public Member findByIdAndDelete(String id,Integer del) throws SQLException ;
	public boolean doUpdateByDelete(Member vo,Integer del) throws SQLException ;
	public boolean doUpdateDelete(Set<String> ids) throws SQLException ;
	public boolean doCreateBatch(Set<Member> allMembers) throws SQLException ;

}
