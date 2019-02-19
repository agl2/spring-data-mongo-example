package challenge;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/recipe")
public class RecipeController {

	@Autowired
	private RecipeService service;

	@PostMapping
	public @ResponseBody
	Recipe save(@RequestBody Recipe recipe) {
		return service.save(recipe);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable String id, @RequestBody Recipe recipe) {
		service.update(id, recipe);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}

	@GetMapping("/{id}")
	public Optional<Recipe> get(@PathVariable String id) {
		return service.get(id);
	}

	@GetMapping("/ingredient")
	public List<Recipe> listByIngredient(@RequestParam String ingredient) {
		return service.listByIngredient(ingredient);
	}

	public List<Recipe> search() {
		return service.search(null);
	}

	public void like() {
		service.like(null, null);
	}

	public void unlike() {
		service.unlike(null, null);
	}

	public RecipeComment addComment() {
		return service.addComment(null, null);
	}

	public void updateComment() {
		service.updateComment(null, null, null);
	}

	public void deleteComment() {
		service.deleteComment(null, null);
	}

}
