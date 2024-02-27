
package mappers;

import mappers.mocks.MockUsuario;
import org.demo.data.vo.v1.UsuarioVO;
import org.demo.mapper.DozerMapper;
import org.demo.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DozerConverterTest {

    MockUsuario inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockUsuario();
    }

    @Test
    public void parseEntityToVOTest() {
        UsuarioVO output = DozerMapper.parseObject(inputObject.mockEntity(), UsuarioVO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("Name Test0", output.getUserName());
        assertEquals("email Test0", output.getEmail());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<UsuarioVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), UsuarioVO.class);
        UsuarioVO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("Name Test0", outputZero.getUserName());
        assertEquals("email Test0", outputZero.getEmail());

        UsuarioVO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("Name Test7", outputSeven.getUserName());
        assertEquals("email Test7", outputSeven.getEmail());

        UsuarioVO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("Name Test12", outputTwelve.getUserName());
        assertEquals("email Test12", outputTwelve.getEmail());
    }

    @Test
    public void parseVOToEntityTest() {
        Usuario output = DozerMapper.parseObject(inputObject.mockVO(), Usuario.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getUserName());
        assertEquals("email Test0", output.getEmail());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Usuario> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Usuario.class);
        Usuario outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getUserName());
        assertEquals("email Test0", outputZero.getEmail());

        Usuario outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getUserName());
        assertEquals("email Test7", outputSeven.getEmail());

        Usuario outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Name Test12", outputTwelve.getUserName());
        assertEquals("email Test12", outputTwelve.getEmail());
    }

}
