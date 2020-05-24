package com.projectreference.reference.Repository;

import com.projectreference.reference.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends CrudRepository<Topic, String> {


}
