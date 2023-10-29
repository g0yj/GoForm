package petplaza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petplaza.model.dto.AdminDto;
import petplaza.model.entity.AdminEntity;
import petplaza.model.repository.AdminRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private AdminRepository adminRepository;

    //1. 회원가입
    public boolean register(AdminDto dto){
        System.out.println("AdminService.signup");
        System.out.println("dto = " + dto);
        AdminEntity adminEntity = adminRepository.save(dto.toEntity());
        if(adminEntity.getAno()>=1){
            return true;
        }
        return false;
    }
    @Autowired
    private HttpServletRequest request;
    //2. 로그인
    public boolean login(AdminDto dto){
        System.out.println("AdminService.login");
        System.out.println("dto = " + dto);
        List<AdminEntity> adminEntities=adminRepository.findAll();
        for(AdminEntity e:adminEntities){
            if(e.getAid().equals(dto.getAid())&&e.getApw().equals(dto.getApw())){
                request.getSession().setAttribute("loginDto",e.toDto());
                System.out.println("로그인성공");
                return true;
            }
        }
        return false;
    }

    //3.로그아웃
    public boolean logout(){
        System.out.println("AdminService.logout");
        request.getSession().setAttribute("loginDto",null);
        return true;
    }

    //4.아이디찾기 [request:aname,aphone /response:aid]
    public String findid(AdminDto dto){
        System.out.println("AdminService.findid");
        System.out.println("dto = " + dto);
        List<AdminEntity> adminEntities=adminRepository.findAll();
        for(AdminEntity e:adminEntities){
            if(e.getAname().equals(dto.getAname())&&e.getAphone().equals(dto.getAphone())){
                return e.getAid();
            }
        }
        return null;
    }

    //5.비밀번호찾기
    public String findpw(AdminDto dto){
        System.out.println("AdminService.findpw");
        System.out.println("dto = " + dto);
        List<AdminEntity> adminEntities=adminRepository.findAll();
        for(AdminEntity e:adminEntities){
            if(e.getAid().equals(dto.getAid())&&e.getAphone().equals(dto.getAphone())){
                return e.getApw();
            }
        }
        return null;
    }

    //6.내정보 호출
    public AdminDto mypage(){
        System.out.println("AdminService.mypage");
        Object session=request.getSession().getAttribute("loginDto");
        if(session!=null){
            return (AdminDto) session;
        }
        return null;
    }

    //7. 내정보수정
    public boolean updateMypage(AdminDto dto){
        Optional<AdminEntity> optionalAdminEntity=adminRepository.findById(dto.getAno());
        if(optionalAdminEntity.isPresent()){
            AdminEntity adminEntity=optionalAdminEntity.get();
            adminEntity.setApw(dto.getApw());
            adminEntity.setAname(dto.getAname());
            adminEntity.setAphone(dto.getAphone());
            return true;
        }
        return false;
    }


    //8.회원탈퇴
    public boolean deleteAdmin(int ano){
        Optional<AdminEntity> optionalAdminEntity=adminRepository.findById(ano);
        if(optionalAdminEntity.isPresent()){
            adminRepository.deleteById(ano);
        }
        return false;
    }
}
