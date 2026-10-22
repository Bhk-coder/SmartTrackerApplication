package com.example.Events;

import lombok.Data;

@Data
public class ThresholdBreachEvent
{
  private String userId;
  public ThresholdBreachEvent(String userid)
  {
      this.userId = userid;
  }
}
