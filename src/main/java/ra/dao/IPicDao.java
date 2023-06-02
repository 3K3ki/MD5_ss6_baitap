package ra.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ra.model.enttity.Picture;

public interface IPicDao extends PagingAndSortingRepository<Picture,Long> {
}
