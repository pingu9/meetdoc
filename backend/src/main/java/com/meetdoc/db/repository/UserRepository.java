package com.meetdoc.db.repository;

<<<<<<< HEAD
import com.meetdoc.db.entity.User;
=======
import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;
>>>>>>> 93514c0ee8d222a87b6d46a12c8a527e6d9d1117
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
    // 아래와 같이, Query Method 인터페이스(반환값, 메소드명, 인자) 정의를 하면 자동으로 Query Method 구현됨.
    Optional<User> findByUserId(String userId);
}
=======
    Optional<User> findByUserId(String userId);
    Optional<UserInfo> findUserInfoByUserId(String userId);
}
>>>>>>> 93514c0ee8d222a87b6d46a12c8a527e6d9d1117
