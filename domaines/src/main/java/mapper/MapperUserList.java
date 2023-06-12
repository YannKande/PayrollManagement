package mapper;

import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import model.Employed;
import model.user.User;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MapperUserList {

    public static List<User> getUsers() throws IOException {
        InputStream inputStream = Resources.getResource("dummy/user.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }
}
