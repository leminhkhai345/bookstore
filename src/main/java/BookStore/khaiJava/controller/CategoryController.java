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

    @PostMapping("/{categoryId}")
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

    @PostMapping("/active/{categoryId}")
    public ApiResponse<?> activateCategory(@PathVariable int categoryId, @RequestParam boolean active) {
        String message;
        if (active) {
            message = "activate category successfully";
        }
        else message = "deactivate category successfully";
        return ApiResponse.builder()
                .message(message)
                .data(categoryService.activeCategory(categoryId, active))
                .build();
    }

    @GetMapping("/{categoryId}")
    public ApiResponse<?> getCategory(@PathVariable int categoryId) {
        return ApiResponse.builder()
                .message("get category with id = " + categoryId + " successfully")
                .data(categoryService.getCategory(categoryId))
                .build();
    }

    @GetMapping("/")
    public ApiResponse<?> getAllCategories() {
        return ApiResponse.builder()
                .message("get all categories successfully")
                .data(categoryService.getAllCategories())
                .build();
    }

}
