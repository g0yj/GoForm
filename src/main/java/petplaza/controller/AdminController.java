package petplaza.controller;

import petplaza.model.dto.AdminDto;
import petplaza.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService admineService;

    //1.직원등록
    @PostMapping
    public boolean register(@RequestBody AdminDto dto){
        System.out.println("AdminController.signup");
        System.out.println("dto = " + dto);
        return admineService.register(dto);
    }

    //2. 직원전체출력
    @GetMapping
    public List<AdminDto> allAdmin(){
        return admineService.allAdmin();
    }
    //3. 직원삭제
    @DeleteMapping
    public boolean deleteAdmin(int ano){
        return admineService.deleteAdmin(ano);

    }

    //4. 직원정보수정[request:apw,aname,aphone / request:t-f]
    @PutMapping
    public boolean updateMypage(@RequestBody AdminDto dto){
        return admineService.updateMypage(dto);
    }

//----------------------------------------------------------//
    //관리자정보호출
    @GetMapping("/mypage")
    public AdminDto mypage(){
        System.out.println("AdminController.mypage");
        return admineService.mypage();
    }







    //관리자로그인
    @PostMapping("/login")
    public boolean login(@RequestBody AdminDto dto){
        System.out.println("AdminController.login");
        System.out.println("dto = " + dto);
        return admineService.login(dto);
    }
    //로그아웃
    @GetMapping
    public boolean logout(){
        System.out.println("AdminController.logout");;
        return admineService.logout();
    }
    //아이디찾기 [request:aname,aphone /response:aid]
    @PostMapping("/findid")
    public String findid(@RequestBody AdminDto dto){
        System.out.println("AdminController.findid");
        System.out.println("dto = " + dto);
        return admineService.findid(dto);
    }
    //비밀번호찾기[request:aid,aphone / request:apw]
    @PostMapping("/findpw")
    public String findpw(@RequestBody AdminDto dto){
        System.out.println("AdminController.findpw");
        System.out.println("dto = " + dto);
        return admineService.findpw(dto);
    }




}
