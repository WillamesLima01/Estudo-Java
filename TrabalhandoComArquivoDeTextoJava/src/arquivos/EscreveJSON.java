package arquivos;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {

    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setNome("willames lima");
        usuario1.setCpf("03432115677");
        usuario1.setLogin("wplima");
        usuario1.setSenha("1a2b");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("jose da silva");
        usuario2.setCpf("111222333444");
        usuario2.setLogin("josesilva");
        usuario2.setSenha("aabb");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();/*organiza os dados*/
        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\Willames\\IdeaProjects\\TrabalhandoComArquivoDeTextoJava\\src\\arquivos\\filjson.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

        /*----------------------------------- Lendo o arquivo Json --------------------------------------------------*/

        FileReader fileReader = new FileReader("C:\\Users\\Willames\\IdeaProjects\\TrabalhandoComArquivoDeTextoJava\\src\\arquivos\\filjson.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> listUsuarios = new ArrayList<>();

        for (JsonElement jsonElement:jsonArray){
            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            listUsuarios.add(usuario);
        }

        System.out.println("Leitura do arquivo JSON: "+ listUsuarios);


    }
}
