package sagengaliyev.project.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sagengaliyev.project.booking.model.Flat;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {

    @Query(value = "SELECT f from Flat f")
    public List<Flat> getAllFlats();

    @Modifying
    @Transactional
    @Query(value = "DELETE from Flat f where f.id = :fid")
    public int deleteById(@Param("fid") long id);

    @Modifying
    @Transactional
    @Query(value = "update Flat f set f.name=:name, f.location=:location, f.description=:description, f.price=:price where f.id=:fid")
    public void updateById(@Param("fid") long id, @Param("location") String location, @Param("description") String description, @Param("price")long price, @Param("name") String name);

    @Query(value = "SELECT f from Flat f where f.id = :fid")
    public List<Flat> getFlatById(@Param("fid") long id);
}
