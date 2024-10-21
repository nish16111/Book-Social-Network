package com.sirwani.book.book;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    public Integer save(BookRequest request, Authentication connectedUser) {
        return null;
    }
}
