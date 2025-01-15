import org.junit.jupiter.api.BeforeEach;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Paciente;
import dao.PacienteDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PacienteDAOTest {

    private PacienteDAO pacienteDAO;

    @BeforeEach
    public void setUp() {
        pacienteDAO = new PacienteDAO();
    }

    @Test
    public void testCadastrarPaciente() throws SQLException {
        Paciente paciente = new Paciente(0, "John Doe", "123 Street", new Date(), "555-1234", "123456789", "987654321", "john@example.com", 1);
        pacienteDAO.cadastrarPaciente(paciente);
        ArrayList<Paciente> pacientes = pacienteDAO.buscarPacienteFiltro("WHERE CPF = '123456789'");
        assertNotNull(pacientes);
        assertFalse(pacientes.isEmpty());
        assertEquals("John Doe", pacientes.get(0).getNome());
    }

    @Test
    public void testBuscarPaciente() throws SQLException {
        ArrayList<Paciente> pacientes = pacienteDAO.buscarPaciente();
        assertNotNull(pacientes);
        assertTrue(pacientes.size() > 0);
    }
}
