
public interface UmbrellaDetails {
	String user_register(String emailepassword);
	String user_cria(String emailepassword);
	String getPraia();
	String getDay();
	String getMonth();
	String getYear();
	String getStartHour();
	String getEndHour();
	String getIdSombra();
	String getEmail1();
	String getUser();
	String getDia();
	String getMes();
	String getAno();
	String getHoradeInicio();
	String getHoraFim();
	String getIdSombrinha();
	String getMaxPessoas();
	String start();
	String praia_quantidadePessoasSombrinha(String input);
	String changepraia(String input);
	String changedia(String input);
	String changemes(String input);
	String changeano(String input);
	String changestarthour(String input);
	String changeendhour(String input);
	String praia_verificarDisponibilidade(String input);
	String praia_umbrellasNr(String input);
	String write_combiner(String input);
	String praia_reservarSombrinha(String input);
	String user_reservarSombrinha(String input);
	String user_listarSombrinhas(String input);
	String user_cancelarSombrinha(String input);
	String praia_listarSombrinhas(String input);
}