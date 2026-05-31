package likelion.movie.domain.member.controller;

import likelion.movie.domain.member.dto.MemberRegisterRequestDTO;
import likelion.movie.domain.member.dto.MemberRegisterResponseDTO;
import likelion.movie.domain.member.dto.MemberResponseDTO;
import likelion.movie.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterResponseDTO> register(@RequestBody MemberRegisterRequestDTO req) {
        return ResponseEntity.ok(memberService.registerMember(req));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDTO> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
    }

}

