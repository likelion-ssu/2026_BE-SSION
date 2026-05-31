package likelion.movie.domain.member.service;


import likelion.movie.domain.member.dto.MemberRegisterRequestDTO;
import likelion.movie.domain.member.dto.MemberRegisterResponseDTO;
import likelion.movie.domain.member.dto.MemberResponseDTO;
import likelion.movie.domain.member.entity.Member;
import likelion.movie.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberRegisterResponseDTO registerMember(MemberRegisterRequestDTO req) {

        Member member = Member.builder()
                .name(req.name())
                .email(req.email())
                .build();

        memberRepository.save(member);

        return new MemberRegisterResponseDTO(member.getId());

    }

    public MemberResponseDTO getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다."));

        return new MemberResponseDTO(member.getName(), member.getEmail());
    }

}
