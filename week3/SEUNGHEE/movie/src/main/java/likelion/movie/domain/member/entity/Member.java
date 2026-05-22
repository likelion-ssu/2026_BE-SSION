package likelion.movie.domain.member.entity;

import jakarta.persistence.*;
import likelion.global.common.entity.BaseEntity;
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

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 15)
    private String phone;

    @Column(length = 100)
    private String profileImageUrl;


    @Builder
    public Member(String name, String email, String password, String phone, String profileImageUrl) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.profileImageUrl = profileImageUrl;
    }

    public void updateMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.phone = member.getPhone();
        this.profileImageUrl = member.getProfileImageUrl();
    }
}