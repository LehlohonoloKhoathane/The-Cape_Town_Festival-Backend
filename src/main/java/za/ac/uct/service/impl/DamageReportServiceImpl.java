package za.ac.uct.service.impl;
/**DamageReportServiceImpl.java
 * Service Class for the Damage Report
 * Author: Lehlohonolo Khoathane
 * Date: 224/11/2023
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.uct.domain.DamageReport;
import za.ac.uct.repository.IDamageReportRepository;
import za.ac.uct.service.IDamageReport;

import java.util.List;
import java.util.Optional;
@Service
public class DamageReportServiceImpl implements IDamageReport {
    @Autowired
    private IDamageReportRepository repository;

    @Autowired
    private DamageReportServiceImpl(IDamageReportRepository repository){
        this.repository = repository;
    }
    @Override
    public DamageReport create(DamageReport damageReport) {
        return this.repository.save(damageReport);
    }

    @Override
    public Optional<DamageReport> read(int id) {
        return this.repository.findById(id);
    }

    @Override
    public DamageReport read(Integer integer) {
        return null;
    }

    @Override
    public DamageReport update(DamageReport damageReport) {
        if (this.repository.existsById(damageReport.getId()))
            this.repository.save(damageReport);
        return null;
    }
    @Override
    public Boolean deleteById(int id) {
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<DamageReport> getAll() {
        return this.repository.findAll();
    }


}
