package ra.model.repository;

import org.springframework.transaction.annotation.Transactional;
import ra.model.enttity.Picture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class PictureRepositoryIpm implements IPictureRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Picture> findAll() {
        TypedQuery<Picture> query = em.createQuery("select p from Picture p", Picture.class);
        return query.getResultList();
    }

    @Override
    public Picture findById(Long id) {
        TypedQuery<Picture> query = em.createQuery("select p from Picture p where p.id=:id", Picture.class);
       query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Picture picture) {
            if (picture.getId()!=null){
                em.merge(picture);
            }else {
                em.persist(picture);
            }
    }

    @Override
    public void remove(Long id) {
        Picture p = findById(id);
        em.remove(p);
    }
}
