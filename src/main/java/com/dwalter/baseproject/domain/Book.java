package com.dwalter.baseproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class Book {
    private final Long id;
    private final String title;
    private final String author;
    private final Integer year;
}
