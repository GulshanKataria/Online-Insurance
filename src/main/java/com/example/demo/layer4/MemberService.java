package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Member;

@Service
public interface MemberService {
	List<Member> insertMemberService(List<Member> mem);
	List<Member> selectMemberByTravelIdService(int travelId);
	 
}