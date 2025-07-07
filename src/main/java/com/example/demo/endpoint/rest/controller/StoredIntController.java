package com.example.demo.endpoint.rest.controller;

import com.example.demo.model.StoredInt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoredIntController {

  private final StoredInt storedInt = new StoredInt();

  @GetMapping("/stored-int")
  public Integer getStoredInt() {
    return storedInt.get();
  }
}
