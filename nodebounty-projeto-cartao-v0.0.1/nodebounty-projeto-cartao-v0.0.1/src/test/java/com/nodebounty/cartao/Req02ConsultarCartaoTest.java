package com.nodebounty.cartao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nodebounty.cartao.model.Cartao;
import com.nodebounty.cartao.service.ICartaoServico;

@SpringBootTest
class Req02ConsultarCartaoTest {

    @Autowired
    ICartaoServico cartaoServico;

    @Test
    void ct01_consulta_por_id_com_sucesso() {
        // Suponha que você tenha 3 entidades Cartao no banco de dados
        // e que o serviço consultaPorId esteja configurado corretamente para recuperar as entidades.

        // Quando você consulta as entidades por ID (ou algum critério específico) usando o serviço
        List<Cartao> cartoes = cartaoServico.consultaCartao(); 

        // Então a quantidade de entidades retornadas na consulta deve ser 3
        assertEquals(3, cartoes.size());
    }
}
