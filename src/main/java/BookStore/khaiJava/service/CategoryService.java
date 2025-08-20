package BookStore.khaiJava.service;

import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.entity.Category;
import BookStore.khaiJava.mapper.CategoryMapper;
import BookStore.khaiJava.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public Category addCategory(CategoryRequest request){
        return categoryMapper.toCategory(request);
    }

}
