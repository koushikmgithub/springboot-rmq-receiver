
package org.km.samples.springbootrmqreceiver.repository;

import org.km.samples.springbootrmqreceiver.domain.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageRepository extends CrudRepository<Message, Long> {
}
