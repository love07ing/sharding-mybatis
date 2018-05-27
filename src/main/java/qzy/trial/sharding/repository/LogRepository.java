package qzy.trial.sharding.repository;

import org.springframework.data.repository.CrudRepository;
import qzy.trial.sharding.entity.Log;

public interface LogRepository extends CrudRepository<Log, Long> {
}
