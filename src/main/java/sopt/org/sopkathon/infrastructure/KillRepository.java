package sopt.org.sopkathon.infrastructure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import sopt.org.sopkathon.domain.Kill;

import java.util.List;
import java.util.Optional;

public interface KillRepository extends Repository<Kill, Long> {

    @Query(value = "SELECT * FROM sopkathon_32.kill order by RAND() limit 1", nativeQuery = true)
    List<Kill> findAllByRandom();

    @Query(value = "SELECT * FROM sopkathon_32.kill ORDER BY rank_score DESC", nativeQuery = true)
    List<Kill> findAll();

    Optional<Kill> findById(Long id);

    void save(Kill kill);
}
