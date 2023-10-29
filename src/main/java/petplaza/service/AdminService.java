package petplaza.service;

import org.springframework.web.bind.annotation.RequestBody;
import petplaza.model.dto.AdminDto;
import petplaza.model.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petplaza.model.repository.AdminRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    //1.직원등록
    public boolean register(AdminDto dto){
        System.out.println("AdminService.signup");
        System.out.println("dto = " + dto);
        AdminEntity adminEntity = adminRepository.save(dto.toEntity());
        if(adminEntity.getAno()>=1){
            return true;
        }
        return false;
    }


    //2.관리자전체출력
    public List<AdminDto> allAdmin(){
        List<AdminEntity> adminEntities=adminRepository.findAll();
        List<AdminDto> adminDtos= new ArrayList<>();
        adminEntities.forEach(e->{
            adminDtos.add(e.toDto());
         });
        return adminDtos;
    }

    //3.관리자삭제
    public boolean deleteAdmin(int ano){
        Optional<AdminEntity> optionalAdminEntity=adminRepository.findById(ano);
        if(optionalAdminEntity.isPresent()){
            adminRepository.deleteById(ano);
        }
        return false;
    }

    //4.직원정보수정
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




    //관리자정보호출
    public AdminDto mypage(){
        System.out.println("AdminService.mypage");
        Object session=request.getSession().getAttribute("loginDto");
        if(session!=null){
            return (AdminDto) session;
        }
        return null;
    }




    @Autowired
    private HttpServletRequest request;
    //관리자로그인
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


    public boolean logout(){
        System.out.println("AdminService.logout");
        request.getSession().setAttribute("loginDto",null);
        return true;
    }


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



}
