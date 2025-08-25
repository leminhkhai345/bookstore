package BookStore.khaiJava.mapper;

import BookStore.khaiJava.dto.request.AuthorRequest;
import BookStore.khaiJava.dto.response.AuthorResponse;
import BookStore.khaiJava.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorRequest request);
    AuthorResponse toAuthorResponse(Author author);
}
