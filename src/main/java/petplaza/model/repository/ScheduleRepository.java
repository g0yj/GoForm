package petplaza.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petplaza.model.entity.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Integer> {

}
