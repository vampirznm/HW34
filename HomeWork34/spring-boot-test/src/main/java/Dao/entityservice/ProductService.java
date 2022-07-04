package Dao.entityservice;

import Dao.ShopApplication;
import Dao.entity.Product;
import Dao.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.LockModeType;
import java.util.List;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ShopApplication.class);

    private static ProductRepository repository;

    public ProductService(ProductRepository repository) {
        ProductService.repository = repository;
    }

    @Transactional
    public void createProduct(Product product){
        repository.save(product);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    @Cacheable(value = "product")
    public Product getProductById(Long id){
        return repository.findProductById(id);
    }

    @Transactional
    @CacheEvict(value = "product", key = "#product.id")
    @Lock(value = LockModeType.READ)
    public void update(Product product){
        try{
            repository.save(product);
        }catch(ObjectOptimisticLockingFailureException e){
            log.warn("Optimistic {}",product.getId());
        }
    }
}