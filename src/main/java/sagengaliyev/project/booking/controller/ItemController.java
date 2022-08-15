package sagengaliyev.project.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sagengaliyev.project.booking.dto.BookingDTO;
import sagengaliyev.project.booking.dto.ItemDTO;
import sagengaliyev.project.booking.model.Item;
import sagengaliyev.project.booking.service.BookingService;
import sagengaliyev.project.booking.service.ItemService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;
    private final BookingService bookingService;

    public ItemController(ItemService itemService, BookingService bookingService) {
        this.itemService = itemService;
        this.bookingService = bookingService;
    }

    @GetMapping("/show")
    public ResponseEntity<List<ItemDTO>> show() {
        List<ItemDTO> items = itemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody ItemDTO itemDTO, Principal principal) {
        itemService.add(itemDTO, principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Optional<Item>> itemDetails(@PathVariable(value = "id") long id) {
        Optional<Item> items = itemService.showById(id);
        if (items==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(items,HttpStatus.OK);
        }
    }


    @PostMapping(value = "/show/{id}/book", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> bookItem(@PathVariable(value = "id") long id, @RequestBody BookingDTO bookingDTO, Principal principal){
        itemService.bookItem(id, bookingDTO, principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
