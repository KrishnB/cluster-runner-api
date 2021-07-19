package ekam.example.api.response;

import lombok.*;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
    private String userId;
    private String id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Posts{"
                + "userId='"
                + userId
                + '\''
                + ", id='"
                + id
                + '\''
                + ", title='"
                + title
                + '\''
                + ", body='"
                + body
                + '\''
                + '}';
    }

    public Posts createDefaultPost() {
        return builder()
                .id("101")
                .title("Random Post")
                .body("Random post body")
                .userId("1")
                .build();
    }

    public void assertThatPostIsCreated(Posts postCreated) {
        assertThat(this).usingRecursiveComparison().isEqualTo(postCreated);
    }
}
