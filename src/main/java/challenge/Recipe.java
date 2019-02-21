package challenge;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;


@Document(collection = "recipe")
public class Recipe {

    @Id
    private String id;
    private String title;
    private String description;
    private List<String> likes;
    private List<String> ingredients;
    private List<RecipeComment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public void addLike(String like) {
        if(likes == null) {
            likes = new ArrayList<String>();
        }
        likes.add(like);
    }

    public boolean removeLike(String like) {
        if(likes != null) {
            return likes.remove(like);
        }
        return false;
    }

    public String addComment(RecipeComment comment) {
        String _id = (new ObjectId()).toString();
        comment.setId(_id);
        if(comments == null) {
            comments = new ArrayList<RecipeComment>();
        }
        comments.add(comment);
        return _id;
    }

    public boolean removeComment(RecipeComment comment) {
        if(comments != null) {
            return comments.remove(comment);
        }
        return false;
    }


    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeComment> getComments() {
        return comments;
    }

    public void setComments(List<RecipeComment> comments) {
        this.comments = comments;
    }

    public RecipeComment getComment(String id) {
        if(comments != null) {
            for (RecipeComment c : comments) {
                if (c.getId().equals(id)) return c;
            }
        }
        return null;
    }
}
