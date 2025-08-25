package BookStore.khaiJava.controller;

import BookStore.khaiJava.dto.request.AuthorRequest;
import BookStore.khaiJava.dto.response.ApiResponse;
import BookStore.khaiJava.service.AuthorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthorController {

    AuthorService authorService;

    @PostMapping("/")
    public ApiResponse<?> createAuthor(@RequestBody AuthorRequest authorRequest) {
        return ApiResponse.builder()
                .message("Author created successfully")
                .data(authorService.createAuthor(authorRequest))
                .build();
    }

}
