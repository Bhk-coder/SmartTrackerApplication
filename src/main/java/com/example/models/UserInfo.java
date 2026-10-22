package com.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class UserInfo
{
  @Id
  @Column(name = "user_id")
  private Long user_id;

  private String username;

  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "user_roles" ,
                    joinColumns = @JoinColumn(name = "user_id") ,
                    inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<UserRole> roles = new HashSet<>();
    
}
