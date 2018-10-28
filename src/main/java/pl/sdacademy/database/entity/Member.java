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
    private String name;
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "run_member",
            joinColumns = {@JoinColumn(name = "run_id")},
            inverseJoinColumns = {@JoinColumn(name ="member_id")})

    private Set<Run> runs = new HashSet<Run>();

    public Member(){};

    public Member(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Run> getRuns() {
        return runs;
    }

    public void setRuns(Set<Run> runs) {
        this.runs = runs;
    }

    /*public Run getRan() {
        return run;
    }

    public void setRan(Run ran) {
        this.run = ran;
    }*/
}
