package com.company.KYC.repositories;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.company.KYC.models.PRODUIT;

public class PRODUIT_specification implements Specification<PRODUIT> {
	
	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;

	public PRODUIT_specification(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<PRODUIT> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		if(criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.greaterThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
		}
		else if(criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.lessThanOrEqualTo(root.<String> get(criteria.getKey()), criteria.getValue().toString());
		}
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        else if (criteria.getOperation().equalsIgnoreCase("=")) {
        	return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
		return null;
	}
	
}
