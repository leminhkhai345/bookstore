package BookStore.khaiJava.controller;

import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.dto.response.ApiResponse;
import BookStore.khaiJava.dto.response.CategoryResponse;
import BookStore.khaiJava.service.CategoryService;
import BookStore.khaiJava.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/categoryId")
    public ApiResponse<?> updateCategory(@PathVariable int categoryId, @RequestBody CategoryRequest request) {
        CategoryResponse categoryResponse = categoryService.updateCategory(categoryId, request);
        return ApiResponse.builder()
                .message("update category successfully")
                .data(categoryResponse)
                .build();
    }

    @DeleteMapping("/{categoryId}")
    public ApiResponse<?> deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
        return ApiResponse.builder()
                .message("delete category successfully")
                .build();
    }

}
