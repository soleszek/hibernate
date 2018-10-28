package pl.sdacademy.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String place;
    private Date startDate;
    private Date startTime;

    /*@OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "run",
            cascade = CascadeType.REMOVE)*/
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "runs")

    private Set<Member> members = new HashSet<Member>();

    public Run(){};

    public Run(Long id, String name, String place, Date startDate, Date startTime) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.startDate = startDate;
        this.startTime = startTime;
        //this.memberLimit = memberLimit;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

   /*public int getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(int memberLimit) {
        this.memberLimit = memberLimit;
    }*/
}
