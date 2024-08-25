package com.example.emazon.application.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateCategoryCommand {
    private final String name;
    private final String description;
}
