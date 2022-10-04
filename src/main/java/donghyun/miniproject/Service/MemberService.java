package donghyun.miniproject.Service;

import donghyun.miniproject.Bean.MemberDTO;
import donghyun.miniproject.Config.JWT.SecurityUtil;
import donghyun.miniproject.Entity.Authority;
import donghyun.miniproject.Entity.Member;
import donghyun.miniproject.Exception.DuplicateMemberException;
import donghyun.miniproject.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        return memberRepository.findOneWithAuthoritiesByEmail(email)
                .map(user -> createUser(email, user))
                .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    private org.springframework.security.core.userdetails.User createUser(String username, Member member) {
        if (!member.isActivated()) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = member.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(member.getEmail(),
                member.getPassword(),
                grantedAuthorities);
    }

    @Transactional
    public Member signup(MemberDTO memberDto) {
        if (memberRepository.findOneWithAuthoritiesByEmail(memberDto.getEmail()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Member m = Member.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .address(memberDto.getAddress())
                .address_detail(memberDto.getAddress_detail())
                .phone(memberDto.getPhone())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return memberRepository.save(m);

    }

    @Transactional
    public String adiminMeInfo(Long id, MemberDTO memberDTO) {

        Optional<Member> updateUser = memberRepository.findById(id);

        updateUser.ifPresent(selectUser -> {
            selectUser.setName(memberDTO.getName());
            selectUser.setEmail(memberDTO.getEmail());
            selectUser.setPhone(memberDTO.getPhone());
            selectUser.setAddress(memberDTO.getAddress());
            selectUser.setAddress_detail(memberDTO.getAddress_detail());
            selectUser.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
            memberRepository.save(selectUser);
        });

        return "changed";

    }
    
    @Transactional
    public String editMember(Long id, MemberDTO memberDTO) {

        Optional<Member> updateUser = memberRepository.findById(id);

        updateUser.ifPresent(selectUser -> {
            selectUser.setName(memberDTO.getName());
            selectUser.setEmail(memberDTO.getEmail());
            selectUser.setPhone(memberDTO.getPhone());
            selectUser.setAddress(memberDTO.getAddress());
            selectUser.setAddress_detail(memberDTO.getAddress_detail());
            memberRepository.save(selectUser);
        });

        return "changed";

    }

    @Transactional
    public String deleteMember(Long id) {
        Member deleteMember = memberRepository.findById(id).get();

        deleteMember.setActivated(false);

        return deleteMember.getEmail() + " 비활성화";
    }

    // 이메일을 받아서 정보를 가져옴
    @Transactional(readOnly = true)
    public Optional<Member> getUserWithAuthorities(String email) {
        return memberRepository.findOneWithAuthoritiesByEmail(email);
    }

    // 현재 SecurityContext에 저장된 email의 정보를 가져옴
    @Transactional(readOnly = true)
    public Optional<Member> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(memberRepository::findOneWithAuthoritiesByEmail);
    }

    // 전체 정보를 가져옴
    @Transactional(readOnly = true)
    public List<Member> getAllMemberInfo() {
        return (List<Member>) memberRepository.findAll();
    }

    //이메일 중복 체크
    public boolean isEmailDuplicate(String email) {
        return memberRepository.findOneWithAuthoritiesByEmail(email).orElse(null) != null;
    }
}
