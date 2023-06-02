package ra.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.enttity.Blog;
@Repository
public interface IBlogDao extends PagingAndSortingRepository<Blog,Long> {
    @Query("select c from Blog as c where c.picture.id = :id")
    Iterable<Blog> searchByCatalogId(@Param("id") Long id);
}
