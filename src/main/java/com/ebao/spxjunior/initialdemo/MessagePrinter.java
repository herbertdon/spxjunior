package com.ebao.spxjunior.initialdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messagePrinter")
public class MessagePrinter {
  final private MessageService service;

  @Autowired
  public MessagePrinter(MessageService service) {
      this.service = service;
  }

  public void printMessage() {
      System.out.println(this.service.getMessage());
  }
}
