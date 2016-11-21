package ru.students.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.students.entity.Chair;

@RepositoryRestResource(collectionResourceRel = "chair", path = "chair")
public interface ChairRepository extends PagingAndSortingRepository<Chair, Long> {
}
