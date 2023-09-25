package com.example.homestaymanagementgroup_four.service;

import com.example.homestaymanagementgroup_four.controller.request.HomestaySearchRequest;
import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.repository.IHomestayRepository;
import com.example.homestaymanagementgroup_four.repository.IHomestaySpec;
import com.example.homestaymanagementgroup_four.service.dto.HomestayDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeStayService {

    private final IHomestayRepository homestayRepository;

    private final HomestayMapper homestayMapper;

    public HomeStayService(IHomestayRepository homestayRepository, HomestayMapper homestayMapper) {
        this.homestayRepository = homestayRepository;
        this.homestayMapper = homestayMapper;
    }

    public List<HomestayDTO> search(HomestaySearchRequest request){
        Specification<Homestay> query = Specification.where(
                IHomestaySpec
                        .searchByAddress(request.getAddress())
        );
        List<Homestay> homestays = homestayRepository.findAll(query);
        return homestayMapper.convertToDto(homestays);
    }
}
