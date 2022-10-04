package donghyun.miniproject.Controller.Common;

import donghyun.miniproject.Entity.Member;
import donghyun.miniproject.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public abstract class BaseController {

    @Autowired
    protected MemberService memberService;

    public Member getUserInfo(){
        return memberService.getMyUserWithAuthorities().get();
    }
}
