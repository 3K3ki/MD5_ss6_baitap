package ra.model.service;

import ra.model.enttity.Blog;

public interface IBlogService extends IGenericService<Blog,Long>{
    Iterable<Blog> searchByCatalogId(Long id);
}
