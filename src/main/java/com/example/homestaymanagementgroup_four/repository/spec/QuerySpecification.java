package com.example.homestaymanagementgroup_four.repository.spec;

import com.example.homestaymanagementgroup_four.model.spec.QueryCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class QuerySpecification<T> implements Specification<T> {

    private QueryCriteria criteria;

    public QuerySpecification(QueryCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        return QuerySpecificationHelper.toPredicate(criteria, root, criteriaQuery, builder);
    }
}
