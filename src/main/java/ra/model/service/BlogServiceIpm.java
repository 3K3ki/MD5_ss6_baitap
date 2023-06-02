package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dao.IBlogDao;
import ra.model.enttity.Blog;
import ra.model.repository.IBlogRepository;

import java.util.List;
import java.util.Optional;

@Service

public class BlogServiceIpm implements IBlogService {
    @Autowired
    private IBlogDao iBlogDao;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogDao.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return iBlogDao.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogDao.save(blog);
    }

    @Override
    public void remove(Long id) {
        iBlogDao.deleteById(id);
    }

    @Override
    public Iterable<Blog> searchByCatalogId(Long id) {
        return iBlogDao.searchByCatalogId(id);
    }
}