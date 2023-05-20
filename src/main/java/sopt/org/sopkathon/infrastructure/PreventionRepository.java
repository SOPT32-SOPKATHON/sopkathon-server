package sopt.org.sopkathon.infrastructure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import sopt.org.sopkathon.domain.Prevention;

import java.util.List;

public interface PreventionRepository extends Repository<Prevention, Long> {
    @Query(value = "SELECT * FROM sopkathon_32.prevention order by RAND() limit 5", nativeQuery = true)
    List<Prevention> findAll();
}
