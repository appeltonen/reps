package org.dysonpair.reps.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RepSet")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = RepSet.class)
public class RepSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
        mappedBy = "repSet",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )

    private Set<Rep> reps;

    protected RepSet() {}

    public RepSet(Long id, Set<Rep> reps) {
        this.id = id;
        this.reps = reps;
    }

    public void addRep(Rep rep) {
        reps.add(rep);
        rep.setRepSet(this);
    }

    public void removeRep(Rep rep) {
        reps.remove(rep);
        rep.setRepSet(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long i) {
        id = i;
    }

    public Set<Rep> getReps() {
        return reps;
    }

    public void setReps(Set<Rep> r) {
        reps = r;
    }
}
