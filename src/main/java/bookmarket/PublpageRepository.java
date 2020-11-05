package bookmarket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublpageRepository extends CrudRepository<Publpage, Long> {

    List<Publpage> findByReqId(Long reqId);


}