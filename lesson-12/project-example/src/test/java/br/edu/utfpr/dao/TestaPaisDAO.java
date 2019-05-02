package br.edu.utfpr.dao;

import br.edu.utfpr.dto.PaisDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestaPaisDAO {

    private static PaisDAO paisDAO;

    @BeforeClass
    public static void setup() {
        paisDAO = new PaisDAO() {
            @Override
            public List<PaisDTO> ListaTodosPais() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }; 
    }

    @Test
    public void testaIncluirPais() {

        PaisDTO pais = PaisDTO.builder()
                .codigoTelefone(55)
                .nome("Brasil")
                .sigla("BR")
                .build();

        Assert.assertTrue(paisDAO.inserir(pais));
    }

    @Test
    public void testaListarTodos() {
        PaisDTO pais = PaisDTO.builder()
                .codigoTelefone(55)
                .nome("Brasil")
                .sigla("BR")
                .build();

        paisDAO.inserir(pais);

        Assert.assertTrue(paisDAO.ListaTodosPais().listIterator().equals(pais));
    }

    @Test
    public void testaExcluir() {

        PaisDTO pais = PaisDTO.builder()
                .codigoTelefone(32)
                .nome("Estados Unidos da América")
                .sigla("EUA")
                .build();

        paisDAO.inserir(pais);

        PaisDTO paisRecuperado = paisDAO.ListaTodosPais().stream().filter(p -> p.getSigla().equalsIgnoreCase(pais.getSigla())).collect(Collectors.toList()).get(0);

        Assert.assertTrue(paisDAO.excluir(paisRecuperado.getId()));
    }

    @Test
    public void testaAlterar() {
        PaisDTO pais = PaisDTO.builder()
                .codigoTelefone(32)
                .nome("Reino Unido")
                .sigla("RU")
                .build();

        paisDAO.inserir(pais);

        PaisDTO paisRecuperado = paisDAO.ListaTodosPais().stream().filter(p -> p.getSigla().equalsIgnoreCase(pais.getSigla())).collect(Collectors.toList()).get(0);

        paisRecuperado.setNome("Reino Unido Alterado");

        Assert.assertTrue(paisDAO.alterar(paisRecuperado));
    }

}
