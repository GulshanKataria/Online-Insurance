package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Member;
import com.example.demo.layer3.MemberRepositoryImpl;

 @Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepositoryImpl memRepo;
	
//	@Override
//	public List<Member> insertMemberService(List<Member> mem) {
//		 
//		return null;
//	}

	@Override
	public List<Member> selectMemberByTravelIdService(int travelId) {
		 
		return memRepo.selectMemberByTravelId(travelId);
	}

	@Override
	public List<Member> insertMemberService(List<Member> mem) {
		// TODO Auto-generated method stub
		return  memRepo.insertMember(mem);
	}

}