package com.example.services;

import com.example.Events.ThresholdBreachEvent;
import jdk.jfr.Threshold;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WebSocketService
{
  private final SimpMessagingTemplate simpMessagingTemplate;


  @EventListener
  public void eventHandler(ThresholdBreachEvent event)
  {
      String destination = "/topic/alerts/" + event.getUserId();

      Map<String,String> payload = new HashMap<>();
      payload.put("title", "Budget Warning 🚨");
      payload.put("message", "You are spending too fast! Please review your recent transactions.");
      payload.put("timestamp", LocalDateTime.now().toString());

      simpMessagingTemplate.convertAndSend(destination,payload);
  }
}
