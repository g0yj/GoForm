package petplaza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import petplaza.model.dto.AdminDto;
import petplaza.service.AdminService;

@RestController
@ResponseBody
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private AdminService admineService;

    //1. 회원가입
    @PostMapping("/signup")
    public boolean register(@RequestBody AdminDto dto){
        System.out.println("AdminController.signup");
        System.out.println("dto = " + dto);
        return admineService.register(dto);
    }
    //2.로그인
    @PostMapping("/login")
    public boolean login(@RequestBody AdminDto dto){
        System.out.println("AdminController.login");
        System.out.println("dto = " + dto);
        return admineService.login(dto);
    }
    //3.로그아웃
    @GetMapping
    public boolean logout(){
        System.out.println("AdminController.logout");;
        return admineService.logout();
    }
    //4.아이디찾기 [request:aname,aphone /response:aid]
    @PostMapping("/findid")
    public String findid(@RequestBody AdminDto dto){
        System.out.println("AdminController.findid");
        System.out.println("dto = " + dto);
        return admineService.findid(dto);
    }
    //5.비밀번호찾기[request:aid,aphone / request:apw]
    @PostMapping("/findpw")
    public String findpw(@RequestBody AdminDto dto){
        System.out.println("AdminController.findpw");
        System.out.println("dto = " + dto);
        return admineService.findpw(dto);
    }

    //6.내정보 호출
    @GetMapping("/info")
    public AdminDto mypage(){
        System.out.println("AdminController.mypage");
        return admineService.mypage();
    }

    //7. 내정보수정[request:apw,aname,aphone / request:t-f]
    @PutMapping("/info")
    public boolean updateMypage(@RequestBody AdminDto dto){
        return admineService.updateMypage(dto);
    }


    //8.회원탈퇴
    @DeleteMapping
    public boolean deleteAdmin(int ano){
        return admineService.deleteAdmin(ano);

    }

}
