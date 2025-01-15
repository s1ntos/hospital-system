
import org.junit.jupiter.api.BeforeEach;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Convenio;
import dao.ConvenioDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ConvenioDAOTest {

    private ConvenioDAO convenioDAO;

    @BeforeEach
    public void setUp() {
        convenioDAO = new ConvenioDAO();
    }

    @Test
    public void testBuscarConvenios() throws SQLException {
        ArrayList<Convenio> convenios = convenioDAO.buscarcConvenios();
        assertNotNull(convenios);
        assertTrue(convenios.size() > 0);
    }

    @Test
    public void testBuscarConvenioFiltro() throws SQLException {
        String query = "Convenio Test";
        Convenio convenio = convenioDAO.buscarConvenioFiltro(query);
        assertNotNull(convenio);
        assertEquals("Convenio Test", convenio.getNomeConvenio());
    }
}
