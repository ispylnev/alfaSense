package alfasense.dto;

import alfasense.models.CategoryModel;
import alfasense.models.PetStatus;
import alfasense.models.TagModel;
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
    CategoryModel category;
    String name;
    List<String> photoUrls;
    List<TagModel> tags;
    PetStatus status;

}
