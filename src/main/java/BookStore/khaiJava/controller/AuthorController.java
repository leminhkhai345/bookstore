package BookStore.khaiJava.controller;

import BookStore.khaiJava.dto.request.AuthorRequest;
import BookStore.khaiJava.dto.response.ApiResponse;
import BookStore.khaiJava.service.AuthorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{authorId}")
    public ApiResponse<?> updateAuthor(@PathVariable int authorId, @RequestBody AuthorRequest authorRequest) {
        return ApiResponse.builder()
                .message("Author created successfully")
                .data(authorService.updateAuthor(authorId, authorRequest))
                .build();
    }

    @DeleteMapping("/{authorId}")
    public ApiResponse<?> deleteAuthor(@PathVariable int authorId){
        authorService.deleteAuthor(authorId);
        return ApiResponse.builder()
                .message("Author deleted successfully")
                .build();
    }




}
