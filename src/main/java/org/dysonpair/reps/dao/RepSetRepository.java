package org.dysonpair.reps.dao;

import org.dysonpair.reps.model.RepSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepSetRepository extends JpaRepository<RepSet, Long> {

}
