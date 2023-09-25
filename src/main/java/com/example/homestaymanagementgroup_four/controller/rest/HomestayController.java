package com.example.homestaymanagementgroup_four.controller.rest;

import com.example.homestaymanagementgroup_four.controller.request.HomestaySearchRequest;
import com.example.homestaymanagementgroup_four.service.HomeStayService;
import com.example.homestaymanagementgroup_four.service.dto.HomestayDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/homestay")
public class HomestayController {

    private final HomeStayService homeStayService;

    public HomestayController(HomeStayService homeStayService) {
        this.homeStayService = homeStayService;
    }

    public ResponseEntity<List<HomestayDTO>> search(@RequestParam(name = "address") String address){
        HomestaySearchRequest request = new HomestaySearchRequest();
        request.setAddress(address);
        return ResponseEntity.ok(homeStayService.search(request));
    }
}
