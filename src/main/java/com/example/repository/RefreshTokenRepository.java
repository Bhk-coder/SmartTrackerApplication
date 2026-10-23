package com.example.repository;

import com.example.models.RefreshToken;
import com.example.models.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String>
{
  Optional<RefreshToken> findByToken(String token);

  UserInfo findByUserName(String username , String password);
}
