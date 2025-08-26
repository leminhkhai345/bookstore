package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.AuthorRequest;
import BookStore.khaiJava.dto.response.AuthorResponse;
import BookStore.khaiJava.entity.Author;
import BookStore.khaiJava.exception.AppException;
import BookStore.khaiJava.exception.ErrorCode;
import BookStore.khaiJava.mapper.AuthorMapper;
import BookStore.khaiJava.repository.AuthorRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteAuthor(int authorId){
        authorRepository.deleteById(authorId);
    }

    public AuthorResponse getAuthor(int authorId){
        Author author = authorRepository.findById(authorId).orElseThrow(()-> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        return authorMapper.toAuthorResponse(author);
    }

    public AuthorResponse updateAuthor(int authorId, AuthorRequest request) {
        Author author = authorRepository.findById(authorId).orElseThrow(()-> new AppException(ErrorCode.AUTHOR_NOT_EXISTED));
        authorMapper.toMapper(author, request);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }

    public List<AuthorResponse> getAllAuthor(){
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(authorMapper::toAuthorResponse).toList();
    }

}
