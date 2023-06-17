package likelion.todolist.repository;


import jakarta.persistence.EntityManager;
import likelion.todolist.entity.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {

    //엔티티를 관리해주는 엔티티매니저 생성
    private final EntityManager em;

    // 데이터를 저장한다.
    public void save(ToDo toDo) {
        if (toDo.getId() == null) {
            em.persist(toDo);
        } else {
            em.merge(toDo);
        }
    }

    //Create 구현
    // 데이터를 id로 하나만 조회한다.
    public ToDo findOne(Long id) {
        return em.find(ToDo.class, id);
    }

    //저장된 모든 데이터를 조회한다.
    public List<ToDo> findAll() {
        return em.createQuery("select i from ToDo i", ToDo.class).getResultList();
    }

    //Delete 삭제 코드 추가
    public void delete(ToDo toDo) {
        em.remove(toDo);
    }
}
    //Update 코드 추가

