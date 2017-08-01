package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.License;
import softuni.repositories.LicenceRepository;
import softuni.services.LicenseService;

import java.util.List;

@Service
public class LicenseServiceImpl implements LicenseService<License,Long> {
    private final LicenceRepository licenceRepository;

    @Autowired
    public LicenseServiceImpl(LicenceRepository licenceRepository) {
        this.licenceRepository = licenceRepository;
    }

    @Override
    public List<License> findAll() {
        return this.licenceRepository.findAll();
    }

    @Override
    public License findById(Long id) {
        return this.licenceRepository.findOne(id);
    }

    @Override
    public void save(License license) {
        this.licenceRepository.save(license);
    }
}
