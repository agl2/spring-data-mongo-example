package challenge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;


public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findByIngredientsLikeOrderByTitle(String ingredient);

    List<Recipe> findByTitleContainingOrDescriptionContainingAllIgnoreCaseOrderByTitle(String title, String description);

    Optional<Recipe> findById(String id);
}
