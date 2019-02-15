import org.junit.jupiter.api.Test;
import org.training.model.entities.datafields.AllowedFields;

import static org.junit.jupiter.api.Assertions.*;


public class UserRecordTest {
    @Test
    void Should_Contain_14_AllowedKeys() {
        int keysSize = AllowedFields.FIELD.size();
        assertEquals(14, keysSize);
    }
}
