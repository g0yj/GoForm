package petplaza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import petplaza.model.dto.ScheduleDto;
import petplaza.model.entity.ScheduleEntity;
import petplaza.model.repository.ScheduleRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;


    //일정등록
    public boolean registerSchedule(ScheduleDto dto){
        System.out.println("ScheduleService.registerSchedule");
        System.out.println("dto = " + dto);
        ScheduleEntity scheduleEntity =scheduleRepository.save(dto.toEntity());
        if(scheduleEntity.getSno()>=1){
            return true;
        }
        return false;
    }

    //일정전체출력

    public List<ScheduleDto> allSchedule(){
        System.out.println("ScheduleService.allSchedule");
        List<ScheduleEntity> scheduleEntities= scheduleRepository.findAll();
        List<ScheduleDto> scheduleDtos= new ArrayList<>();
        scheduleEntities.forEach(e->{
            scheduleDtos.add(e.allScheduleToDto());
            });
        return scheduleDtos;

    }

    //일정수정
    @Transactional
    public boolean updateSchedule(ScheduleDto dto){
        System.out.println("ScheduleService.updateSchedule");
        System.out.println("dto = " + dto);
        Optional<ScheduleEntity> optionalScheduleEntity= scheduleRepository.findById(dto.getSno());
        if(optionalScheduleEntity.isPresent()){
            ScheduleEntity scheduleEntity=optionalScheduleEntity.get();
            scheduleEntity.setSclass(dto.getSclass());
            scheduleEntity.setStitle(dto.getStitle());
            scheduleEntity.setScontent(dto.getScontent());
            scheduleEntity.setSstate(dto.isSstate());
            scheduleEntity.setSstart(dto.getSstart());
            scheduleEntity.setSend(dto.getSend());
            return true;
        }
        return false;
    }
    //일정삭제

    public boolean deleteSchedule(int sno) {
        System.out.println("ScheduleService.deleteSchedule");
        System.out.println("sno = " + sno);
        Optional<ScheduleEntity> optionalScheduleEntity=scheduleRepository.findById(sno);
        if(optionalScheduleEntity.isPresent()){
            scheduleRepository.deleteById(sno);
            return true;
        }

        return false;
    }


}
