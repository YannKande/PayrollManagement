package mapper;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import model.Employed;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MapperEmployed {

    public static List<Employed> getCustomers() throws IOException {
        InputStream inputStream = Resources.getResource("dummy/data.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type type = new TypeToken<ArrayList<Employed>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }
}
