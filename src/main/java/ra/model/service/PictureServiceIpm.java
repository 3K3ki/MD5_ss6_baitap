package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.enttity.Picture;
import ra.model.repository.IPictureRepository;

import javax.xml.ws.Action;
import java.util.List;
import java.util.Optional;

@Service
public class PictureServiceIpm implements IPictureService{
    @Autowired
    private IPictureRepository pictureRepository;
    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Picture save(Picture picture) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }


}
