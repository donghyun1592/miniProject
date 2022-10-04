package donghyun.miniproject.Controller;

import donghyun.miniproject.Bean.MemberDTO;
import donghyun.miniproject.Config.JWT.TokenProvider;
import donghyun.miniproject.Entity.Member;
import donghyun.miniproject.Service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public MemberController(MemberService memberService,
                            TokenProvider tokenProvider,
                            AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }


    /**
     * 회원가입
     *
     * @param memberDto
     * @return
     */
    @PostMapping("/member")
    public ResponseEntity<Member> signup(@RequestBody MemberDTO memberDto) {
        return ResponseEntity.ok(memberService.signup(memberDto));
    }

    // 회원 정보 조회
    @GetMapping("/member")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Member> getMyUserInfo() {
        return ResponseEntity.ok(memberService.getMyUserWithAuthorities().get());
    }

    // 회원 수정
    @PutMapping("/member")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<String> EditMemberInfo(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(
                memberService.editMember(memberService.getMyUserWithAuthorities().get().getId(), memberDTO)
        );
    }
    @PutMapping("/member/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String adiminMemberInfo(@PathVariable("id") Long id, @RequestBody MemberDTO memberDTO) {
        return memberService.adiminMeInfo(id,memberDTO);
    }

    // 회원 삭제
    @DeleteMapping("/member")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<String> DeleteMember() {
        return ResponseEntity.ok(memberService.deleteMember(memberService.getMyUserWithAuthorities().get().getId()));
    }

    // 이메일 중복 체크
    @GetMapping(value = "/member/{email}")
    public ResponseEntity<Boolean> isEmailDup(@PathVariable("email") String email) {
        return ResponseEntity.ok(memberService.isEmailDuplicate(email));
    }

    @GetMapping(value = "/member/address")
    public ResponseEntity<String> getMemberAddress() {
        return ResponseEntity.ok(memberService.getMyUserWithAuthorities().get().getAddress());
    }
}
