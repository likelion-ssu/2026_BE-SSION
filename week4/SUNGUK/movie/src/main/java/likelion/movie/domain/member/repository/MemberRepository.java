package likelion.movie.domain.member.repository;

import likelion.movie.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameAndEmail(String name, String email);
}
