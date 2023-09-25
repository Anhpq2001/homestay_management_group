package com.example.homestaymanagementgroup_four.repository.spec;

import com.example.homestaymanagementgroup_four.model.enums.SearchOperation;
import com.example.homestaymanagementgroup_four.model.spec.QueryCriteria;
import com.example.homestaymanagementgroup_four.utils.Strings;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class QuerySpecificationHelper {
    public QuerySpecificationHelper() {
    }

    public static Predicate toPredicate(QueryCriteria criteria, Root<?> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        if (criteria.getValue() == null) {
            return null;
        } else if (criteria.getOperation() == SearchOperation.GREATER_THAN) {
            return criteria.isDate() ? builder.greaterThan(root.get(criteria.getKey()), (Date)criteria.getValue()) : builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation() == SearchOperation.GREATER_THAN_EQUAL) {
            return criteria.isDate() ? builder.greaterThanOrEqualTo(root.get(criteria.getKey()), (Date)criteria.getValue()) : builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation() == SearchOperation.LESS_THAN) {
            return criteria.isDate() ? builder.lessThan(root.get(criteria.getKey()), (Date)criteria.getValue()) : builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation() == SearchOperation.LESS_THAN_EQUAL) {
            return criteria.isDate() ? builder.lessThanOrEqualTo(root.get(criteria.getKey()), (Date)criteria.getValue()) : builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation() == SearchOperation.EQUAL) {
            return criteria.isDate() ? builder.equal(root.get(criteria.getKey()), (Date)criteria.getValue()) : builder.equal(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.NOT_EQUAL) {
            return criteria.isDate() ? builder.notEqual(root.get(criteria.getKey()), (Date)criteria.getValue()) : builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.MATCH) {
            return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (criteria.getOperation() == SearchOperation.MATCH_START) {
            return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
        } else if (criteria.getOperation() == SearchOperation.MATCH_END) {
            return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
        } else if (criteria.getOperation() == SearchOperation.IN) {
            return root.get(criteria.getKey()).in(new Object[]{criteria.getValue()});
        } else {
            return criteria.getOperation() == SearchOperation.NOT_IN ? root.get(criteria.getKey()).in(new Object[]{criteria.getValue()}).not() : null;
        }
    }

    public static QueryCriteria toQuery(String key, String params, boolean isDate) {
        if (!Strings.isEmpty(params) && !Strings.isEmpty(key)) {
            if (params.contains(":")) {
                String[] s = params.split(":");
                SearchOperation operation = SearchOperation.parse(s[0]);
                return new QueryCriteria(key, operation, s[1], isDate);
            } else {
                return new QueryCriteria(key, SearchOperation.EQUAL, params, isDate);
            }
        } else {
            return null;
        }
    }
}
