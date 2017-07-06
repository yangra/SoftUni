package softuniBlog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuniBlog.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByName(String name);
}
