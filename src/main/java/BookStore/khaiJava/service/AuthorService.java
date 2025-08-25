package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.AuthorRequest;
import BookStore.khaiJava.dto.response.AuthorResponse;
import BookStore.khaiJava.entity.Author;
import BookStore.khaiJava.mapper.AuthorMapper;
import BookStore.khaiJava.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

public class AuthorService {
    AuthorRepository authorRepository;
    AuthorMapper authorMapper;

    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = authorMapper.toAuthor(request);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }


}
