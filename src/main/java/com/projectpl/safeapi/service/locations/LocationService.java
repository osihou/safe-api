package com.projectpl.safeapi.service.locations;



import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.errors.exceptions.LocationNotFoundException;
import com.projectpl.safeapi.persistance.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocationService implements  ILocationService{

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Location findById(int id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
    }

    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location save(Location newLocation) {
        return locationRepository.save(newLocation);
    }

    @Override
    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }



}
