package Dao.repository;


import Dao.entity.BookWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {
}