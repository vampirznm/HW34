package controller;


import controller.filter.BookFilter;
import Dao.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class BookSpecification {

    public static Specification<Book> byFilter(BookFilter filter) {
        return (root, q, cb) -> {
            Predicate predicate = cb.isNotNull(root.get("id"));

            if (filter.getMinCostBound() > 0 &&
                    filter.getMinCostBound() != null &&
                    filter.getMaxCostBound() != null &&
                    filter.getMinCostBound() < filter.getMaxCostBound()) {
                //predicate = cb.and(cb.like(root.get("title"), "%" + filter.getTitle() + "%"));
                predicate = cb.and(cb.between(root.get("cost"), filter.getMinCostBound(), filter.getMaxCostBound()));
            }
            return predicate;
        };
    }
}