package za.ac.uct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.uct.domain.Driver;
import za.ac.uct.repository.IDriverRepository;
import za.ac.uct.service.IDriverService;

import java.util.List;

@Service
public class DriverServiceImpl implements IDriverService {
    private IDriverRepository repository;
    @Autowired
    private DriverServiceImpl(IDriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public Driver create(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Driver read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if (this.repository.existsById(driver.getId())) {
            return this.repository.save(driver);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Driver> getAll() {
        return this.repository.findAll();
    }
}
