package com.nor3stbackend.www.member.query.application.controller;

import com.nor3stbackend.www.common.ResponseMessage;
import com.nor3stbackend.www.config.SecurityUtil;
import com.nor3stbackend.www.member.query.application.service.MemberQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberQueryController {

    private final MemberQueryService memberQueryService;

    public MemberQueryController(MemberQueryService memberQueryService) {
        this.memberQueryService = memberQueryService;
    }

    @GetMapping("/members")
    public ResponseEntity<?> getMembers() {
        ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK,
                "회원 정보 조회에 성공하였습니다.",
                memberQueryService.findByMemberId(SecurityUtil.getCurrentMemberId()));

        return new ResponseEntity<>(responseMessage, responseMessage.getStatus());
    }
}
