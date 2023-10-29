package petplaza.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petplaza.model.entity.AdminEntity;
import petplaza.model.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {
}
