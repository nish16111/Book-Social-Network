package com.sirwani.book.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookRequest(
        Integer id,

        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String title,

        String authorName,

        String isbn,

        String synopsis,

        boolean shareable

) {

}
