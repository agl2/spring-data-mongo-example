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
		Recipe toUpdate = repository.findById(id).orElse(null);
		if(recipe != null) {
			toUpdate.setTitle(recipe.getTitle());
			toUpdate.setDescription(recipe.getDescription());
			toUpdate.setIngredients(recipe.getIngredients());
			repository.save(toUpdate);
		} else{
			// exception
		}

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
		return repository.findByIngredientsLikeOrderByTitle(ingredient);
	}

	@Override
	public List<Recipe> search(String search) {
		return repository.findByTitleContainingOrDescriptionContainingAllIgnoreCaseOrderByTitle(search, search);
	}

	@Override
	public void like(String id, String userId) {
		Recipe recipe = repository.findById(id).orElse(null);
		if(recipe != null) {
			recipe.addLike(userId);
			repository.save(recipe);
		} else {
			//exception
		}
	}

	@Override
	public void unlike(String id, String userId) {
		Recipe recipe = repository.findById(id).orElse(null);
		if(recipe != null) {
			if(recipe.removeLike(userId)){
				repository.save(recipe);
			} else{
				//exception
			}
		} else {
			//exception
		}
	}

	@Override
	public RecipeComment addComment(String id, RecipeComment comment) {
		Recipe recipe = repository.findById(id).orElse(null);
		if(recipe != null) {
			recipe.addComment(comment);
			repository.save(recipe);
			return comment;
		}
		return null;
	}

	@Override
	public void updateComment(String id, String commentId, RecipeComment comment) {
		Recipe recipe = repository.findById(id).orElse(null);
		if(recipe != null) {
			RecipeComment toUpdate = recipe.getComment(commentId);
			if(toUpdate != null) {
				toUpdate.setComment(comment.getComment());
				repository.save(recipe);
			} else{
				//exception
			}
		} else{
			//exception
		}
	}

	@Override
	public void deleteComment(String id, String commentId) {
		Recipe recipe = repository.findById(id).orElse(null);
		if(recipe != null) {
			RecipeComment toRemove = new RecipeComment();
			toRemove.setId(commentId);
			if(recipe.removeComment(toRemove)){
				repository.save(recipe);
			} else{
				//exception
			}
		} else {
			//exception
		}
	}

}
