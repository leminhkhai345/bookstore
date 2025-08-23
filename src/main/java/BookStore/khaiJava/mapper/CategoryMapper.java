package BookStore.khaiJava.mapper;


import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.dto.response.CategoryResponse;
import BookStore.khaiJava.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);
    CategoryResponse toCategoryResponse(Category category);
}
