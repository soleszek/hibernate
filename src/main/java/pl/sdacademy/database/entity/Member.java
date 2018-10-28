package pl.sdacademy.database.entity;


import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "run_member",
            joinColumns = {@JoinColumn(name = "run_id")},
            inverseJoinColumns = {@JoinColumn(name ="member_id")})
    private Set<Run> runs = new HashSet<Run>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;



    public Member(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Run> getRuns() {
        return runs;
    }

    public void setRuns(Set<Run> runs) {
        this.runs = runs;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /*public Run getRan() {
        return run;
    }

    public void setRan(Run ran) {
        this.run = ran;
    }*/
}
