package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.binding.Import.PartImportDto;
import softuni.dto.binding.Import.PartDto;
import softuni.entities.Part;
import softuni.io.ModelParser;
import softuni.repositories.PartRepo;
import softuni.services.api.PartService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepo partRepo;

    @Autowired
    public PartServiceImpl(PartRepo partRepo) {
        this.partRepo = partRepo;
    }

    @Override
    public void savePartDto(PartImportDto partImportDto) {
        Part part = ModelParser.getInstance().map(partImportDto, Part.class);
        this.partRepo.saveAndFlush(part);
    }

    @Override
    public List<PartDto> findAllPartDto() {
        List<Part> parts = this.partRepo.findAll();
        List<PartDto> partDtos = new ArrayList<>();
        for (Part part : parts) {
            PartDto partDto = ModelParser.getInstance().map(part,PartDto.class);
            partDtos.add(partDto);
        }
        return partDtos;
    }
}
