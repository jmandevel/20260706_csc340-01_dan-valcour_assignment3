package edu.uncg.assignment3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameContainingIgnoreCase(String nameKeyword);

    List<Character> findByOriginContainingIgnoreCase(String originKeyword);
}
