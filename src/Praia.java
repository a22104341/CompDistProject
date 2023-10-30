public class Praia {
    public static String[][] read_splitter(String file){
        /* use the variables on top in Functions */
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        return new String[1][1];
    }

    public static String write_combiner(String day, String month, String startHour, String endHour, String email){
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + startHour + "/" + endHour + "/" + email;
    }

    public static boolean verificarDisponibilidade(String file){
        // (vai ao ficheiro da sombrinha, verifica se já existe algum registo a esta hora/data)
        return false;
    }

    public static void listarSombrinhas(String date, String startHour, String endHour){
        // (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)
    }

    public static void reservarSombrinha(String input){
        // (guarda dentro da sombrinha newLine: -Dia/Mes/Ano/HoraIncio/HoraFim/email) input = call write_combiner()
    }

    public static void cancelarSombrinha(String email, String date, String endHour){
        // (Vai a essa sombrinha, procura o email, verifica se a data/horasFim são as msmas, apaga as reservas)
    }

    public static void quantidadePessoasSombrinha(int maxPeople){
        // (qual das sombrinhas a mais apropriada?)
    }
}