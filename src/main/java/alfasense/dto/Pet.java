package alfasense.dto;

import alfasense.models.Category;
import alfasense.models.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    String id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tag> tags;

}
