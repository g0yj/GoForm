package GoForm.controller;

import GoForm.model.dto.MemberDto;
import GoForm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public boolean signup(@RequestBody MemberDto dto){
        System.out.println("MemberController.signup");
        return memberService.signup(dto);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto dto){
        System.out.println("MemberController.login");
        return memberService.login(dto);
    }

    @GetMapping
    public boolean logout(){
        System.out.println("MemberController.logout");
        return memberService.logout();
    }

    @PostMapping("/findid")
    public String findid(@RequestBody MemberDto dto){
        System.out.println("MemberController.findid");
        return memberService.findid(dto);
    }

    @PostMapping("/findpw")
    public String findpw(@RequestBody MemberDto dto){
        System.out.println("MemberController.findpw");
        return memberService.findpw(dto);
    }


}
