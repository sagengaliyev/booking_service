package sagengaliyev.project.booking.service;

import org.springframework.stereotype.Service;
import sagengaliyev.project.booking.dto.FlatDTO;
import sagengaliyev.project.booking.mapper.FlatMapper;
import sagengaliyev.project.booking.model.Flat;
import sagengaliyev.project.booking.repository.FlatRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatService {
    private final FlatRepository flatRepository;
    private final FlatMapper flatMapper;
    public FlatService(FlatRepository flatRepository, FlatMapper flatMapper) {
        this.flatRepository = flatRepository;
        this.flatMapper = flatMapper;
    }

    public List<FlatDTO> getInfo() {
        return flatRepository.findAll()
                .stream()
                .map(flatMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String addFlat(FlatDTO flatDTO) {
        Flat flat = flatMapper.toEntity(flatDTO);
        flatRepository.save(flat);
        return "You successfully added you flat!";

    }

    public void update(FlatDTO flatDTO){
        Flat flat = flatMapper.toEntity(flatDTO);

    }

//    public void delete(FlatDTO flatDTO){
//        long id = flatDTO.getId();
//        flatRepository.deleteById(id);
//    }

    public void deleteById(FlatDTO flatDTO){
        Long id = flatDTO.getId();
        flatRepository.deleteById(id);
    }

    public void updateById(FlatDTO flatDTO){
        Long id = flatDTO.getId();
        String name = flatDTO.getName();
        String description = flatDTO.getDescription();
        String location = flatDTO.getLocation();
        Long price = flatDTO.getPrice();
        flatRepository.updateById(id,location,description,price,name);
    }

    public List<Flat> getFlatById(FlatDTO flatDTO){
        Long id = flatDTO.getId();
        List<Flat> flat = flatRepository.getFlatById(id);
        return flat;

    }

}
