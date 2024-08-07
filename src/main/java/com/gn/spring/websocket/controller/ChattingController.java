package com.gn.spring.websocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gn.spring.member.model.service.MemberService;
import com.gn.spring.member.model.vo.Member;

@Controller
public class ChattingController {
	
	@Autowired
	MemberService memberService;
	
	
	//채팅하고자 하는 사용자 선택하는 목록과 연결
	@GetMapping("/chattingPage/{sender_no}")
	public String chattingPage(@PathVariable("sender_no") int sender_no,Model model) {
//		return "chat/list";
		// 데이터베이스 연결해서 정보 가져옴
		List<Member> resultList = memberService.selectMemberNotSender(sender_no);
		model.addAttribute("resultList",resultList);
		return "chat/selectUser";
	}
	
	@GetMapping("/chattingStart/{receiver_no}")
	public String chattingStartPage(@PathVariable("receiver_no") int receiver_no,Model model) {
		model.addAttribute("receiver_no",receiver_no);
		return "chat/list";
	}
	
}
