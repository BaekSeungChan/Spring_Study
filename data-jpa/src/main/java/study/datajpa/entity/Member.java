package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})  // 가급적이면 안하는게 좋다. 연관관계까지 출력된다.
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY) // 연관관계는 모두 지연로딩으로 해줘야 한다.
    @JoinColumn(name = "team_id")
    private Team team;


     public Member(String username){
         this.username = username;
     }

     public Member(String username, int age, Team team){
         this.username = username;
         this.age = age;
         if(team != null){
             changeTeam(team);
         }
     }

     public void changeTeam(Team team){
         this.team = team;
         team.getMembers().add(this);
     }

}
