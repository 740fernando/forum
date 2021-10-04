package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    //@ResponseBody - Essa anotacao, diz para o Spring, que usara o propria msg passada no metodo
    @RequestMapping("/topicos")
    @ResponseBody
    public List<TopicoDto>list(){
        Topico topico = new Topico("01-00Dúvida","Dúvida com Spring",new Curso("Spring","Programação"));

        return TopicoDto.converter(Arrays.asList(topico,topico,topico));

    }
}
/**
 * O Spring usa uma biblioteca chamada "Jackson".
 * É o Jackson que faz a conversão de Java para JSON.
 * O Spring usa o Jackson disfarçadamente, "por debaixo
 * dos panos". Ele pegou a lista, List<Topico>, que foi
 * devolvida, passou ela para o Jackson. O Jackson converteu
 * para JSON, e ele pegou esse JSON e devolveu como uma string.
 *
 *  DICIONARIO
 *  @ResponseBody -Por padrão, o Spring considera que o retorno do método é o nome
 * da página que ele deve carregar, mas ao utilizar a anotação @ResponseBody,
 * indicamos que o retorno do método deve ser serializado e devolvido no corpo da resposta.
 *
 * Endpoint - é a URL onde seu serviço pode ser acessado por uma aplicação cliente
 *
 * @RestController - Essa anotação é justamente para dizer que o @controller é um @Rest controller
 *  Por padrão, ele já assume que todo metodo já vai ter o @ResponseBody
 *
 */