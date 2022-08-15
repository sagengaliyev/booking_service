package sagengaliyev.project.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sagengaliyev.project.booking.dto.BookingDTO;
import sagengaliyev.project.booking.service.BookingService;

import java.security.Principal;

@Controller
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

//    @PostMapping(value = "/send",consumes = "application/json")
//    @ResponseBody
//    public ResponseEntity<String> send(@RequestBody BookingDTO bookingDTO, Principal principal){
//        bookingService.add(bookingDTO, principal);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
