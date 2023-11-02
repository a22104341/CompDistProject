public class User {
    public static String[][] read_splitter(){
        /* use the variables on top in Functions */
        // (tem a String como input, retorna uma Matrix com tudo separado [][] 1st is the lines, 2nd is split by / etc.)
        return new String[1][1];
    }

    public static String write_combiner(String day, String month,String year, String startHour, String endHour, String idSombrinha){
        /* maybe these are not all strings? idk, if they arent, then they need a converter in here, so we don't gotta do it by hand everytime */
        return day + "/" + month + "/" + startHour + "/" + endHour + "/" + idSombrinha;
    }

    public static boolean user_verificarDisponibilidade(String email){
        // (email already being used?)
        return false;
    }

    public static void verifyLogin(String email, String password){
        // (emailExiste?PasswordCorreta?)
    }

    public static void register(String email, String password){
        // (criar novo ficheiro - Filename: "email", conteúdo:"Password")
    }

    public static void listarSombrinhas(){
        // (Listar as sombrinhas q ele tem no ficheiro)
    }

    public static boolean verificarSombrinha(){
        // (é uma das sombrinhas dele?)
        return false;
    }

    public static void reservarSombrinha(String input){
        // (guarda no user newLine:-Dia/Mes/Ano/HoraInicio/HoraFim/IDSOMBRINHA   input = call write_combiner()      Esse chama o mesmo mas das funcoes da praia)
    }

    public static void cancelarSombrinha(String email, String date, String endHour){
        // (GOES WITH PRAIA ONE)
    }
}

