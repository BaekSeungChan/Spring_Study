package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team")  // foreign key(외래키)가 없는 곳에 mapped By 권장 / 연관관계 매핑
    private List<Member>  members = new ArrayList<>();


    public Team(String name){
        this.name = name;
    }
}
