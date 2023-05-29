package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.enttity.Picture;
import ra.model.repository.IPictureRepository;

import javax.xml.ws.Action;
import java.util.List;
@Service
public class PictureServiceIpm implements IPictureService{
    @Autowired
    private IPictureRepository pictureRepository;
    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public void remove(Long id) {
        pictureRepository.remove(id);
    }
}
