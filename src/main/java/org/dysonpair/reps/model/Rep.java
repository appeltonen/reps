package org.dysonpair.reps.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="Rep")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = Rep.class)
public class Rep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int times;

    @ManyToOne
    @JoinColumn(name = "rep_set_id")
    private RepSet repSet;

    protected Rep() {}

    public Rep(Long id, int times) {
        this.times = times;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        id = i;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int t) {
        times = t;
    }

    public void setRepSet(RepSet rs) {
        repSet = rs;
    }

    public RepSet getRepSetId() {
        return repSet;
    }
}
