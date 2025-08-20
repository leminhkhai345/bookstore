package BookStore.khaiJava.mapper;


import BookStore.khaiJava.dto.request.CategoryRequest;
import BookStore.khaiJava.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);
}
