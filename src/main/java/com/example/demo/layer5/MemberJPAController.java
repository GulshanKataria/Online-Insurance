package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.layer2.Member; 
import com.example.demo.layer4.MemberServiceImpl;
 

@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberJPAController {
	
	@Autowired
	MemberServiceImpl memService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getMember/{travelId}")
	public List<Member> getMemberByTravelId(@PathVariable int travelId){
		System.out.println("in get Member");
		return memService.selectMemberByTravelIdService(travelId);
	}
	
	
	 
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "/addMember")
	public List<Member> addTravel(@RequestBody List<Member> mem) {
		
		 return memService.insertMemberService(mem);

	}
	
}
