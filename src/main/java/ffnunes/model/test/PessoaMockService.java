package ffnunes.model.test;

import java.util.ArrayList;
import java.util.List;

public class PessoaMockService {

	public static List<Pessoa> getAll() {
		Pessoa p1 = new Pessoa("Fanuel");
		Pessoa p2 = new Pessoa("José");
		Pessoa p3 = new Pessoa("Maria");
		
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		
		return pessoas;
	}
	
	public static Pessoa salvar(Pessoa p){
		return p.save();
	}
	
	public static void salvar(List<Pessoa> pessoas){
		for (Pessoa pessoa : pessoas) {
			pessoa.save();
		}
	}
}
