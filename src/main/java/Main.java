import java.io.*;
import java.net.*;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        URL url = new URL("http://10.165.177.238:5000/api/chat/login");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setDoOutput(true);

        UserDto dto = new UserDto("Blob", "1502");
        String json = gson.toJson(dto);
        try (OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes("utf-8"));
        }

        int code = con.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = br.readLine();
            System.out.println("ID пользователя: " + line);
        } else {
            System.out.println("Ошибка: " + code);
        }
    }

    static class UserDto {
        public String Name;
        public String Password;

        public UserDto(String username, String password) {
            this.Name = username;
            this.Password = password;
        }
    }

}