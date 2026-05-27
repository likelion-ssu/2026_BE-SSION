package likelion.movie.domain.member.entity;

import jakarta.persistence.*;
import likelion.movie.global.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private Integer age;

    @Column(length = 20)
    private String gender;

    @Builder
    public Member(String name, String email, Integer age, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public void updateMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.age = member.getAge();
        this.gender = member.getGender();
    }
}
