package ekam.example.api.response;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ToDos {
    private String userId;
    private String id;
    private String title;
    private boolean completed;

    @Override
    public String toString() {
        return "ToDos{"
                + "userId='"
                + userId
                + '\''
                + ", id='"
                + id
                + '\''
                + ", title='"
                + title
                + '\''
                + ", completed="
                + completed
                + '}';
    }
}
