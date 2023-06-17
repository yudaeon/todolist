package likelion.todolist.service;

import likelion.todolist.entity.ToDo;
import likelion.todolist.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    @Transactional
    public void savaToDo(String content){
        ToDo toDo = new ToDo();
        toDo.setContent(content);
        toDo.setCompleted(false);
        toDoRepository.save(toDo);
    }
    @Transactional
    public ToDo findOne(Long id){
        return toDoRepository.findOne(id);
    }
    @Transactional
    public List<ToDo> findToDos(){
        return toDoRepository.findAll();
    }
}
