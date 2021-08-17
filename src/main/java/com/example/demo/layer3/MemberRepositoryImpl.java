package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Member;
 

@Repository
public class MemberRepositoryImpl extends BaseRepository implements MemberRepository{

	@Transactional
	public List<Member> insertMember(List<Member> mem) {
		EntityManager entityManager = getEntityManager();
		 for (Member member : mem) {
			 entityManager.persist(member);
		} 
		
		System.out.println("travel inserted..."+mem);
		return mem;
	}

	@Transactional
	public List<Member> selectMemberByTravelId(int travelId) {
		EntityManager entityManager = getEntityManager();
		System.out.println("debug selectTravelById");
		Query query = entityManager.createQuery("from Member where TRAVELID =: tid");
		query.setParameter("tid", travelId);
		List<Member> MemberList  = query.getResultList();
		return MemberList;
	}

}