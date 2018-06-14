package com.huhu.webserver.repository;

import com.huhu.webserver.domain.Base64;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: webserver
 * @description:
 * @author: Annntn
 * @create: 2018-06-10 17:54
 **/

public interface  Base64Repository extends JpaRepository<Base64, Long> {
    List<Base64> findAllByFromName(String fromName);
}
