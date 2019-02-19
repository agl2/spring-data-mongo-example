package challenge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository repository;

	@Override
	public Recipe save(Recipe recipe) {
		return repository.save(recipe);
	}

	@Override
	public void update(String id, Recipe recipe) {
		recipe.setId(id);
		repository.save(recipe);
	}

	@Override
	public void delete(String id) {
		Recipe toDelete = new Recipe();
		toDelete.setId(id);
		repository.delete(toDelete);
	}

	@Override
	public Optional<Recipe> get(String id) {
		return repository.findById(id);
	}

	@Override
	public List<Recipe> listByIngredient(String ingredient) {
		return repository.findByIngredientsLike(ingredient);
	}

	@Override
	public List<Recipe> search(String search) {
		return null;
	}

	@Override
	public void like(String id, String userId) {

	}

	@Override
	public void unlike(String id, String userId) {

	}

	@Override
	public RecipeComment addComment(String id, RecipeComment comment) {
		return null;
	}

	@Override
	public void updateComment(String id, String commentId, RecipeComment comment) {

	}

	@Override
	public void deleteComment(String id, String commentId) {

	}

}
