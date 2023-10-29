package petplaza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import petplaza.model.dto.ScheduleDto;
import petplaza.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    //일정등록
    @PostMapping
    public boolean registerSchedule(@RequestBody ScheduleDto dto){
        System.out.println("ScheduleController.registerSchedule");
        System.out.println("dto = " + dto);
        return scheduleService.registerSchedule(dto);
    }

    //일정전체출력
    @GetMapping
    public List<ScheduleDto> allSchedule(){
        System.out.println("ScheduleController.allSchedule");
        return scheduleService.allSchedule();
    }

    //일정수정
    @PutMapping
    public boolean updateSchedule(@RequestBody ScheduleDto dto){
        System.out.println("ScheduleController.updateSchedule");
        System.out.println("dto = " + dto);
        return scheduleService.updateSchedule(dto);
    }
    //일정삭제
    @DeleteMapping
    public boolean deleteSchedule(int sno){
        System.out.println("ScheduleController.deleteSchedule");
        System.out.println("sno = " + sno);
        return scheduleService.deleteSchedule(sno);
    }


}
