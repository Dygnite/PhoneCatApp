package modules;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Phone;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import play.api.Environment;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PhonesLoader {

    private static final String PATH = "phones";
    private static final String FILENAME = "phones.json";

    public List<Phone> loadPhones(Environment env) throws IOException, URISyntaxException {
        List<Phone> phones = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(env.classLoader().getResourceAsStream(PATH + "/" + FILENAME));
        for (JsonNode p : rootNode) {
            Phone phone = new Phone();

            phone.age = p.get("age").asLong();
            phone.id = p.get("id").asText();
            phone.imageurl = p.get("imageUrl").asText();
            if (p.has("carrier")) {
                phone.carrier = p.get("carrier").asText();
            }
            phone.name = p.get("name").asText();
            phone.snippet = p.get("snippet").asText();

            String detailsFilename = PATH + "/" + phone.id + ".json";
            phone.details = StringUtils.normalizeSpace(FileUtils.readFileToString(new File(env.classLoader().getResource(detailsFilename).toURI())));

            phones.add(phone);
        }
        return phones;
    }
}
