package sagengaliyev.project.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import sagengaliyev.project.booking.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i.id, i.name, i.user.name, i.location, i.description, i.description, i.price, i.phone, i.publishDate from Items as i where i.id =: id")
    public String getItemById(@Param("id") long id);

    @Query("SELECT i.user.id from Items as i where i.id =: id")
    public Long getUserId(@Param("id") long id);

    @Query("select i from Items i where i.user.id=: userId")
    public List<Item> getItemByUserId(@Param ("userId") Long userId);
}
