package BookStore.khaiJava.mapper;


import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.dto.response.CategoryResponse;
import BookStore.khaiJava.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);
    default CategoryResponse toCategoryResponse(Category category){
        if(category == null) return null;
        return CategoryResponse.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .isActive(category.isActive())
                .createdAt(category.getCreatedAt())
                .build();
    }
}
