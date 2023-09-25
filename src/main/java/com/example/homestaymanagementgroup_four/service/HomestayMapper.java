package com.example.homestaymanagementgroup_four.service;

import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.service.dto.HomestayDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//TODO nâng cấp lên mapstruct
@Component
public class HomestayMapper {
    public List<HomestayDTO> convertToDto(List<Homestay> homestays){
        return homestays.stream().map(e -> {
            HomestayDTO homestayDTO = new HomestayDTO();
            //TODO map data bằng getter setter
            return homestayDTO;
        }).collect(Collectors.toList());
    }
}
