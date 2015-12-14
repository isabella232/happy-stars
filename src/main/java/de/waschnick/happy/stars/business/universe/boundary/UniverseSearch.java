package de.waschnick.happy.stars.business.universe.boundary;

import de.waschnick.happy.stars.business.universe.control.UniverseNotFoundException;
import de.waschnick.happy.stars.business.universe.entity.UniverseEntity;
import de.waschnick.happy.stars.business.universe.entity.UniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniverseSearch {

    @Autowired
    private UniverseRepository universeRepository;

    public List<UniverseEntity> findAll() {
        return universeRepository.findAll();
    }

    public UniverseEntity findUniverse(Long id) {
        UniverseEntity one = universeRepository.findOne(id);
        if (one == null) {
            throw new UniverseNotFoundException(id);
        }
        return one;
    }
}