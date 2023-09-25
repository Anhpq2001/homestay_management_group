package com.example.homestaymanagementgroup_four.repository;

import com.example.homestaymanagementgroup_four.model.Homestay;
import com.example.homestaymanagementgroup_four.model.enums.SearchOperation;
import com.example.homestaymanagementgroup_four.model.spec.QueryCriteria;
import com.example.homestaymanagementgroup_four.repository.spec.QuerySpecification;
import com.example.homestaymanagementgroup_four.utils.Strings;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class IHomestaySpec {

    public IHomestaySpec() {
    }

    public static Specification<Homestay> searchByAddress(String address){
        if (Strings.isEmpty(address)){
            return null;
        }
        QuerySpecification<Homestay> spec1 = new QuerySpecification<>(new QueryCriteria("firstAddress",SearchOperation.MATCH,address));
        QuerySpecification<Homestay> spec2 = new QuerySpecification<>(new QueryCriteria("secondAddress",SearchOperation.MATCH,address));
        return spec1.or(spec2);
    }
}
