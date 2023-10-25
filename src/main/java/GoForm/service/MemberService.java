package GoForm.service;

import GoForm.model.dto.MemberDto;
import GoForm.model.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MemberService {
    @Autowired
    private MemberEntity memberEntity;


    public boolean signup(MemberDto dto){
        System.out.println("MemberService.signup");
        MemberEntity member = MemberEntity.builder()
                                .
                                .build();
        return false;
    }


    public boolean login(MemberDto dto){
        System.out.println("MemberService.login");
        return false;
    }


    public boolean logout(){
        System.out.println("MemberService.logout");
        return false;
    }


    public String findid(MemberDto dto){
        System.out.println("MemberService.findid");
        return null;
    }


    public String findpw(MemberDto dto){
        return null;
    }

}
