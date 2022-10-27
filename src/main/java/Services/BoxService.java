package Services;

import Model.Box;
import Repository.Crud.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<Box> getAll(){
        return boxRepository.getAll();
    }

    public Optional<Box> getBox(int id){
        return boxRepository.getBox(id);
    }

    public Box save(Box box){
        if (validarCampos(box)) {
            if (box.getId() == null) {
                return boxRepository.save(box);
            } else {
                Optional<Box> boxEncontrado = getBox(box.getId());
                if (boxEncontrado.isEmpty()) {
                    return boxRepository.save(box);
                } else {
                    return box;
                }
            }
        }
        return box;
    }
    public Box update(Box box){
        if(validarCampos(box)) {
            if (box.getId() != null) {
                Optional<Box> boxEncontrado = getBox(box.getId());
                if (!boxEncontrado.isEmpty()) {
                    if (box.getName() != null) {
                        boxEncontrado.get().setName(box.getName());
                    }
                    if (box.getLocation() != null) {
                        boxEncontrado.get().setLocation(box.getLocation());
                    }
                    if (box.getCapacity() != null) {
                        boxEncontrado.get().setCapacity(box.getCapacity());
                    }


                    return boxRepository.save(boxEncontrado.get());
                }
            }
            return box;
        }
        return box;
    }

    public boolean delete(int id){
        Boolean respuesta = getBox(id).map(elemento ->{
            boxRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
    public boolean validarCampos(Box box){

        return (box.getName().length() <= 45 && box.getLocation().length() <=45 && box.getDescription().length() <= 250);

    }

}