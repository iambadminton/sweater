package com.example.sweater.repository;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import java.util.List;

/**
 * Created by Sanya on 21.01.2019.
 */

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}

