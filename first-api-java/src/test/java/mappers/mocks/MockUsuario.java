package mappers.mocks;

import org.demo.data.vo.v1.UsuarioVO;
import org.demo.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MockUsuario {
    public Usuario mockEntity() {
        return mockEntity(0);
    }

    public UsuarioVO mockVO() {
        return mockVO(0);
    }

    public List<Usuario> mockEntityList() {
        List<Usuario> Usuarios = new ArrayList<Usuario>();
        for (int i = 0; i < 14; i++) {
            Usuarios.add(mockEntity(i));
        }
        return Usuarios;
    }

    public List<UsuarioVO> mockVOList() {
        List<UsuarioVO> Usuarios = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Usuarios.add(mockVO(i));
        }
        return Usuarios;
    }

    public Usuario mockEntity(Integer number) {
        Usuario Usuario = new Usuario();
        Usuario.setEmail("email Test" + number);
        Usuario.setUserName("Name Test" + number);
        Usuario.setPassword("Password Test" + number);
        Usuario.setId(number.longValue());

        return Usuario;
    }

    public UsuarioVO mockVO(Integer number) {
        UsuarioVO Usuario = new UsuarioVO();
        Usuario.setEmail("email Test" + number);
        Usuario.setUserName("Name Test" + number);
        Usuario.setKey(number.longValue());
        return Usuario;
    }
}
