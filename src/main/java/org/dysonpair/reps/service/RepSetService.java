package org.dysonpair.reps.service;

import org.dysonpair.reps.dao.RepSetRepository;
import org.dysonpair.reps.model.Rep;
import org.dysonpair.reps.model.RepSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RepSetService {

    @Autowired
    private RepSetRepository repSetRepository;

    public RepSet create(RepSet repSet) {
        for(Rep r : repSet.getReps())
            r.setRepSet(repSet);
        return repSetRepository.save(repSet);
    }

    public void delete(RepSet repSet) {
        repSetRepository.delete(repSet);
    }

    public List<RepSet> getAll() {
        return repSetRepository.findAll();
    }
}
