package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.Import.LensImportJsonDto;
import softuni.entities.Lens;
import softuni.io.ModelParser;
import softuni.repositories.LensRepository;
import softuni.services.api.LensService;

import java.io.BufferedReader;
import java.util.List;

@Service
@Transactional
public class LensServiceImpl implements LensService {
    private final LensRepository lensRepository;

    @Autowired
    public LensServiceImpl(LensRepository lensRepository) {
        this.lensRepository = lensRepository;
    }

    @Override
    public void saveLensDto(LensImportJsonDto lensImportJsonDto) {
        Lens lens = ModelParser.getInstance().map(lensImportJsonDto,Lens.class);
        if(lens!=null){
            System.out.printf("Successfully imported %s %dmm f%.1f", lens.getMake(),lens.getFocalLength(),lens.getMaxAperture());
        }
        this.lensRepository.saveAndFlush(lens);
    }

    @Override
    public List<Lens> findAll() {
        return this.lensRepository.findAll();
    }
}
