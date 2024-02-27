package mappers;

import mappers.mocks.MockUsuario;
import org.demo.data.vo.v1.UsuarioVO;
import org.demo.models.Usuario;
import org.demo.repositories.UsuarioRepository;
import org.demo.services.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest  {

    MockUsuario input;
    @InjectMocks
    private UsuarioService service;
    @Mock
    private UsuarioRepository repository;

    @BeforeEach
    void setUpMocks() {
        input = new MockUsuario();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        Usuario usuario = input.mockEntity(1);
        usuario.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</Usuario/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getUserName());
        assertEquals("email Test1", result.getEmail());
    }

    @Test
    void create() {
        Usuario usuario = input.mockEntity(1);
        Usuario persisted = usuario;
        persisted.setId(1L);

        UsuarioVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(any())).thenReturn(persisted);
        //doReturn(persisted).when(any()).save(usuario);

        var result = service.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</Usuario/1>;rel=\"self\"]"));
        assertEquals("Name Test1", result.getUserName());
        assertEquals("email Test1", result.getEmail());

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}