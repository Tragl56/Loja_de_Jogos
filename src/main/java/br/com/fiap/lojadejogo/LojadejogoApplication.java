package br.com.fiap.lojadejogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class LojadejogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojadejogoApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Jogos Pro!";
	}

}
