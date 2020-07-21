package com.projectpl.safeapi.service;



import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.exception.LocationNotFoundException;
import com.projectpl.safeapi.repository.LocationRepository;
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

    @Override
    public Location findByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public Iterable<Location> findByCity(String city) {
        return locationRepository.findByCity(city);
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
