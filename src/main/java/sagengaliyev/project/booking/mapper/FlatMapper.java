package sagengaliyev.project.booking.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.booking.dto.FlatDTO;
import sagengaliyev.project.booking.model.Flat;

@Component
public class FlatMapper {
    public FlatDTO toDTO(Flat flat){
        FlatDTO flatDTO=new FlatDTO();
        flatDTO.setId(flat.getId());
        flatDTO.setName(flat.getName());
        flatDTO.setLocation(flat.getLocation());
        flatDTO.setDescription(flat.getDescription());
        flatDTO.setPrice(flat.getPrice());
        return flatDTO;
    }

    public Flat toEntity(FlatDTO flatDTO){
        Flat flat = new Flat();
        flat.setId(flatDTO.getId());
        flat.setName(flatDTO.getName());
        flat.setLocation(flatDTO.getLocation());
        flat.setDescription(flatDTO.getDescription());
        flat.setPrice(flatDTO.getPrice());
        return flat;
    }

    public Flat toEntityFromId(Long id){
        Flat flat = new Flat();
        flat.setId(id);
        return flat;
    }
}
