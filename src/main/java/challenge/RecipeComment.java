package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document(collection = "comments")
public class RecipeComment {

    @Id
    private String id;
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof RecipeComment) {
            RecipeComment toCompare = (RecipeComment) o;
            return this.id.equals(toCompare.getId());
        }
        return false;
    }
}
