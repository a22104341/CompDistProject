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

            Functions.lerPraias(file);
            if (Functions.praia.equals("A")){
                if (Functions.maxPessoas==2){
                    if (Functions.praiaASombrinhas2>Functions.used){
                        return true;

                    }else {
                        return false;
                    }

                }else if(Functions.maxPessoas==3){
                    if (Functions.praiaASombrinhas3>Functions.used){
                        return true;
                    }else {
                        return false;
                    }

                }else {
                    if (Functions.praiaASombrinhas4>Functions.used){
                        return true;
                    }else {
                        return false;
                    }

                }
            } else if (Functions.praia.equals("B")) {
                if (Functions.maxPessoas==2){
                    if (Functions.praiaBSombrinhas2>Functions.used){
                        return true;
                    }else{
                        return false;
                    }

                } else if (Functions.maxPessoas==3) {
                    if (Functions.praiaBSombrinhas3>Functions.used){
                        return true;
                    }else {
                        return false;
                    }

                }else {
                    if (Functions.praiaBSombrinhas4>Functions.used){
                        return true;
                    }else {
                        return false;
                    }
                }
            } else {
                if (Functions.praiaCSombrinhas2>Functions.used){
                    return true;
                }else {
                    return false;
                }

            }

    }

    public static void listarSombrinhas(String date, String startHour, String endHour){
        // (passa pelo array desta praia e chama verificarDisponibilidade, às horas/data que o utilizador introduziu)
    }

    public static void reservarSombrinha(String input){
        // (guarda dentro da sombrinha newLine: -Dia/Mes/Ano/HoraIncio/HoraFim/Praia/email) input = call write_combiner()
        Functions.start();
        String[] divisao = input.split("/");
        // so a guardar need to guardar em variaveis globais
        Functions.dia = Integer.parseInt(divisao[0].trim());
        Functions.mes = Integer.parseInt(divisao[1].trim());
        Functions.ano = Integer.parseInt(divisao[2].trim());
        Functions.horadeInicio=Integer.parseInt(divisao[3].trim());
        Functions.horaFim = Integer.parseInt(divisao[4].trim());
        Functions.praia = String.valueOf(divisao[5]);
        Functions.user = String.valueOf(divisao[6]);
        verificarDisponibilidade(Functions.pathGetter(Functions.praia,Functions.maxPessoas));
    }

    public static void cancelarSombrinha(String email, String date, String endHour){
        // (Vai a essa sombrinha, procura o email, verifica se a data/horasFim são as msmas, apaga as reservas)
    }

    public static void quantidadePessoasSombrinha(int maxPeople){
        // (qual das sombrinhas a mais apropriada?)
        Functions.maxPessoas=maxPeople;
    }
}