package cn.mldn.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMemberDAO;
import cn.mldn.factory.Factory;
import cn.mldn.service.IMemberService;
import cn.mldn.vo.Member;

public class MemberServiceImpl implements IMemberService{
	IMemberDAO memberDAO=Factory.getDAOInstance("member.dao");

	@Override
	public boolean add(Member vo) throws Exception {
		
		IMemberDAO memberDAO=Factory.getDAOInstance("member.dao");
		if(vo==null){
			return false;
		}
		if(memberDAO.findById(vo.getMid())==null){
			vo.setDel(0);
			return memberDAO.doCreate(vo);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Member> listByDelete(int del) throws Exception {
		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao") ; 
		return memberDAO.findAllByDelete(del); 
		}

	@Override
	public Member editPre(String id) throws Exception {
		IMemberDAO memberDAO=Factory.getDAOInstance("member.dao");
		return memberDAO.findByIdAndDelete( id, 0);
		// TODO Auto-generated method stub
	
	}

	@Override
	public boolean edit(Member vo) throws Exception {
		IMemberDAO memberDAO=Factory.getDAOInstance("member.dao");
		return memberDAO.doUpdateByDelete(vo, 0);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(Set<String> ids) throws Exception {
		if(ids==null||ids.size()==0){
			return false;
		}
		IMemberDAO memberDAO=Factory.getDAOInstance("member.dao");
		return memberDAO.doUpdateDelete(ids);
		
		
	}

	@Override
	public boolean addBatch(Set<Member> allMembers) throws Exception {
		if(allMembers==null||allMembers.size()==0){
			return false;
		}
		Iterator<Member> iter=allMembers.iterator();
		while(iter.hasNext()){
			Member vo=iter.next();
			if(memberDAO.findById(vo.getMid())!=null){
				iter.remove();
			}
		}
		// TODO Auto-generated method stub
		return memberDAO.doCreateBatch(allMembers);
	}
}
		


	

	
		
		
