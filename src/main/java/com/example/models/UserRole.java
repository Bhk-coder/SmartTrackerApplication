package com.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole
{
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO )
  @Column(name="role_id")
  private Long role;

  private String name;




}
