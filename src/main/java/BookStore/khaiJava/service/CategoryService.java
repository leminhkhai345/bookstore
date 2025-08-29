package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.dto.response.CategoryResponse;
import BookStore.khaiJava.entity.Category;
import BookStore.khaiJava.exception.AppException;
import BookStore.khaiJava.exception.ErrorCode;
import BookStore.khaiJava.mapper.CategoryMapper;
import BookStore.khaiJava.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;


    public CategoryResponse addCategory(CategoryRequest request){
        if(categoryRepository.existsByCategoryName(request.getCategoryName())){
            throw new AppException(ErrorCode.CATEGORY_EXISTED);
        }
        Category category = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public CategoryResponse updateCategory(int categoryId, CategoryRequest request){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public void deleteCategory(int categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public CategoryResponse activeCategory(int categoryId, boolean active){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        category.setActive(active);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public CategoryResponse getCategory(int categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        return categoryMapper.toCategoryResponse(category);
    }

    public List<CategoryResponse> getAllCategories(){
        List<Category>  categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryResponse).toList();
    }
}
