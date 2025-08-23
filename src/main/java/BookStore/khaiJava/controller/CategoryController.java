package BookStore.khaiJava.controller;

import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.dto.response.ApiResponse;
import BookStore.khaiJava.service.CategoryService;
import BookStore.khaiJava.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;
    private final UserService userService;

    @PostMapping("/")
    public ApiResponse<?> createCategory(@RequestBody CategoryRequest request) {
        return ApiResponse.builder()
                .message("add category successfully")
                .data(categoryService.addCategory(request))
                .build();

    }


}
