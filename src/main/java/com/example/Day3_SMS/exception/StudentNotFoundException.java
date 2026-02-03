package com.example.Day3_SMS.exception;


public class StudentNotFoundException extends RuntimeException {
  public StudentNotFoundException(String message) {
    super(message);
  }
}

//run-time exception --> student not found
//lagana isko service m
//for 404