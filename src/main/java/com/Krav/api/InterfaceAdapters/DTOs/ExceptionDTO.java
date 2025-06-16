package com.Krav.api.InterfaceAdapters.DTOs;

public record ExceptionDTO(String MessageDeveloper, String Message, int Status_Code, String Stack_Trace, String ExceptionType) {
}
