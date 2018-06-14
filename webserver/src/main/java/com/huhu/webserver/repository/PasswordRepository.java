package com.huhu.webserver.repository;

import com.huhu.webserver.domain.Base64;
import com.huhu.webserver.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: webserver
 * @description:
 * @author: Annntn
 * @create: 2018-06-10 17:54
 **/

public interface PasswordRepository extends JpaRepository<Password, Long> {
    Password findByFromName(String FromName);
}
