package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Member;
@Repository
public interface MemberRepository {
	List<Member> insertMember(List<Member> mem);
	List<Member> selectMemberByTravelId(int travelId);
	 

}