package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.dto.response.CategoryResponse;
import BookStore.khaiJava.entity.Category;
import BookStore.khaiJava.exception.AppException;
import BookStore.khaiJava.exception.ErrorCode;
import BookStore.khaiJava.mapper.CategoryMapper;
import BookStore.khaiJava.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public CategoryResponse addCategory(CategoryRequest request){
        Category category = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public CategoryResponse updateCategory(int categoryId, CategoryRequest request){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }


}
