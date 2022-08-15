package sagengaliyev.project.booking.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.booking.dto.ItemDTO;
import sagengaliyev.project.booking.model.Item;
import sagengaliyev.project.booking.model.User;

@Component
public class ItemMapper {
    private final UserMapper userMapper;

    public ItemMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ItemDTO toDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setUserId(item.getUser().getId());
        itemDTO.setName(item.getName());
        itemDTO.setLocation(item.getLocation());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setPhone(item.getPhone());
        itemDTO.setPublishDate(item.getPublishDate());
        return itemDTO;
    }

    public Item toEntity(ItemDTO itemDTO){
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setUser(userMapper.toEntityFromId(itemDTO.getUserId()));
        item.setName(itemDTO.getName());
        item.setLocation(itemDTO.getLocation());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        item.setPhone(itemDTO.getPhone());
        item.setPublishDate(itemDTO.getPublishDate());
        return item;
    }

    public Item toEntityFromId(Long id) {
        Item item = new Item();
        item.setId(id);
        return item;
    }
}
