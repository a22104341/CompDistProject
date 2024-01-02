import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.Arrays;

public class Consumer {
	public static String inputs(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/input");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String disponivel(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/disponivel");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String verificaLogin(String input, String password) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/verificaLogin");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input + "," + password;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}


	public static String criaFileUser(String input, String password) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/criaFileUser");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input + "," + password;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String criaFileUser1(String input, String password) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/criaFileUser1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input + "," + password;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getPraia() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getPraia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getDay() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getDay");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getMonth() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getMonth");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getYear() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getYear");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getStartHour() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getStartHour");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getEndHour() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getEndHour");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getIdSombra() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getIdSombra");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getEmail1() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getEmail1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getUser() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getUser");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}


	public static String getDia() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getDia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getMes() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getMes");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getAno() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getAno");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getHoradeInicio() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getHoradeInicio");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getHoraFim() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getHoraFim");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getIdSombrinha() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getIdSombrinha");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String getMaxPessoas() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/getMaxPessoas");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String start() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/start");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}


	public static String praia_quantidadePessoasSombrinha(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/praia_quantidadePessoasSombrinha");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String changepraia(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/changepraia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String changedia(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/changedia");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String changemes(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/changemes");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String changeano(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/changeano");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String changestarthour(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/changestarthour");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String changeendhour(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/changeendhour");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String praia_verificarDisponibilidade(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/praia_verificarDisponibilidade");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String praia_umbrellasNr() {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice/rest/praia_umbrellasNr");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String write_combiner(String day, String month, String year, String startHour, String endHour, String praiaIdsombra) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/write_combiner");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = day + "," + month + "," + year + "," + startHour + "," + endHour + "," + praiaIdsombra;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String praia_reservarSombrinha(String file, String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/praia_reservarSombrinha");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = file + "," + input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String user_reservarSombrinha(String file, String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/user_reservarSombrinha");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = file + "," + input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String user_listarSombrinhas(String input) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/user_listarSombrinhas");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = input;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static String praia_listarSombrinhas(String date, String start1, String end1) {
		try {
			URL url = new URL("http://localhost:8080/rest_webservice1.0/rest/praia_listarSombrinhas");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String inputParaAfuncao = date + "," + start1 + "," + end1;

			OutputStream os = conn.getOutputStream();
			os.write(inputParaAfuncao.getBytes());
			os.flush();

			Scanner scanner;
			String response;
			if (conn.getResponseCode() != 200) {
				scanner = new Scanner(conn.getErrorStream());
				response = "Error From Server \n\n";
			} else {
				scanner = new Scanner(conn.getInputStream());
				response = "Response From Server \n\n";
			}
			scanner.useDelimiter("\\Z");
			System.out.println(response + scanner.next());
			scanner.close();
			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Failed";
	}

	public static void loginAndRegisterAndSubMenu() throws Exception {


		while (true) {
			// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
			// then press Enter. You can now see whitespace characters in your code.

			//variaveis do Functions

			/* Define variables that won't change */

			String praia = getPraia();
			int day1 = Integer.parseInt(getDay());
			int month1 = Integer.parseInt(getMonth());
			int year1 = Integer.parseInt(getYear());
			int startHour1 = Integer.parseInt(getStartHour());
			int endHour1 = Integer.parseInt(getEndHour());
			int idSombra = Integer.parseInt(getIdSombra());
			int email1 = Integer.parseInt(getEmail1());
			String user = getUser();
			int dia = Integer.parseInt(getDia());
			int mes = Integer.parseInt(getMes());
			int ano = Integer.parseInt(getAno());
			int horadeInicio = Integer.parseInt(getHoradeInicio());
			int horaFim = Integer.parseInt(getHoraFim());
			String idSombrinha = getIdSombrinha();
			int maxPessoas = Integer.parseInt(getMaxPessoas());
			boolean loggedIn = false;





			/* Initialize all the Variables and Lists */
			start();

			//CREATE BUFFREADER
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));


			String input;
			String password;
			String email = "";

			if (!loggedIn) {
				/* Login or register */
				char thisInput = '0';
				while (true) {
					System.out.println("Do you wish to Login or Register? \n 1 - Login \n 2 - Register");
					input = reader.readLine();
					if (inputs(input).equals("Valid Input")) {
						thisInput = input.trim().charAt(0);
						break;
					} else {
						System.out.println("Invalid input");
					}
				}

				boolean reaskEmail = true;
				while (reaskEmail) {
					System.out.println("Please type in your email:");
					boolean askedEmail = true;
					input = reader.readLine();

					if (thisInput == '1') {

						/* give him 3 attempts at getting the password right */
						int counter = 0;
						while (counter < 3) {
							/* Login */
							if (input != null && disponivel(input).equals("false")) {
								email = input;
								System.out.println("Please type in your password:");
								String input2 = reader.readLine();
								if (input2 != null && verificaLogin(email.trim(), input2).equals("false")) {
									System.out.println("Incorrect login credentials!(Attempt " + counter + "/3 )");
								} else {
									System.out.println("You are logged in!");
									reaskEmail = false;
									break;
								}
							}
							counter++;
						}
						if (reaskEmail) {
							break;
						}

					} else {
						while (true) {
							/* Register */
							/* Check if email already is registered */
							if (!askedEmail) {
								System.out.println("Please type in your email:");
								input = reader.readLine();
								askedEmail = true;
							}
							if (input != null && disponivel(input).equals("true")) {

								//Register Section
								email = input.trim();

								/* Email-Format Check */
								if (!(email.length() < 255)) {
									System.out.println("Email is too long (maximum 254 Characters)");
									break;
								}

								/* @ Checks */
								int position = -1;
								if (email.contains("@")) {
									/* Check how many @'s */
									int counter = 0;
									boolean cutItShort = false;
									for (int i = 0; i < email.length(); i++) {
										if (email.charAt(i) == '@') {
											counter++;
											position = i;
										}
									}

									if (counter != 1 || position == 0 || position == email.length() - 1) {
										/* Either missing '@', more than one '@', or '@' in the first or last position */
										System.out.println("Incorrect Format, you need to have exactly 1 @ in your email, and it should not be in the first or last position");
										cutItShort = true;
									}

									if (cutItShort) {
										// Handle the error or break as needed
										break;
									}

								} else {
									/* Missing an @ */
									System.out.println("Incorrect Format, you need to have at least 1 @ in your email");
									// Handle the error or break as needed
									break;
								}

								/* Check for Spaces */
								if (email.contains(" ")) {
									System.out.println("The email can't contain a space");
									break;
								}

								/* . Checks */
								/* Save the start and Endsection */
								String prefix = email.substring(0, position);
								String endSectionEmail = email.substring(position + 1);

								/* Check 1st and last position of email for weird symbols */
								char char_pos0 = email.charAt(0);
								char char_posEnd = email.charAt(email.length() - 1);
								char char_posEndMin1 = email.charAt(email.length() - 2);

								if (!endSectionEmail.contains(".")) {
									System.out.println("After the @ you need a .");
									break;
								}

								/* 1st pos Checks */
								if (!(Character.isLetter(char_pos0) || Character.isDigit(char_pos0))) {
									System.out.println("The email needs to begin with a Letter or Digit");
									break;
								}

								/* Last 2 positions Checks */
								if (!(Character.isLetter(char_posEnd) || Character.isLetter(char_posEndMin1))) {
									System.out.println("The last 2 positions of your email need to be Letters");
									break;
								}

								/* Check if they not two Symbols's in a row + automatically checks if there is a symbol b4/after the @*/
								char b4Char = email.charAt(1);
								boolean cutItShort = false;
								for (int i = 2; i < email.length() - 1; i++) {
									char currentChar = email.charAt(i);
									/* Checks: both letter, both digit, 1digit 1letter, 1letter 1 digit */
									if (!(Character.isLetter(currentChar) || Character.isDigit(currentChar))) {
										if (!(Character.isLetter(b4Char) || Character.isDigit(b4Char))) {

											System.out.println("The email can't have two Symbols following each other");
											cutItShort = true;
											break;
										}
									}
									b4Char = currentChar;
								}
								if (cutItShort) {
									break;
								} else {
									reaskEmail = false;
									break;
								}

							} else {
								System.out.println("Email already in use, use a different email");
								askedEmail = false;
							}
						}



						/* reasking password Section */
						boolean reaskPw = true;
						while (reaskPw) {
							while (true) {
								/* Password Section */
								System.out.println("Please pick your password here:");
								input = reader.readLine();
								if (input != null) {
									password = input;
									/* length Check */
									if (!(password.length() >= 8)) {
										System.out.println("Password too short, needs to contain at least 8 characters");
										break;
									}
									/* Stuff it needs to contain */
									boolean special = false;
									boolean upper = false;
									boolean lower = false;
									boolean digit = false;

									boolean passwordApproved = false;

									for (int i = 0; i < password.length(); i++) {
										char thisCharacter = password.charAt(i);
										if (Character.isLetter(thisCharacter)) {
											if (Character.isLowerCase(thisCharacter)) {
												lower = true;
											} else {
												upper = true;
											}
										} else if (Character.isDigit(thisCharacter)) {
											digit = true;
										} else {
											special = true;
										}

										if (special && upper && lower && digit) {
											passwordApproved = true;
											break;
										}
									}
									if (!passwordApproved) {
										System.out.println("Password needs to contain at least 1 of each: Lowercase, Uppercase, Digit, Special Character");
										break;
									}

									/* Make em Retype the Password 3 times */
									int counter = 0;
									while (counter < 3) {
										System.out.println("Retype your password here:");
										input = reader.readLine();
										if (input != null) {
											if (input.equals(password)) {
												/* Locale Root is good practice */
												System.out.println(password);
												criaFileUser(email, password);
												criaFileUser1(email, password);
												reaskPw = false;
												break;
											} else {
												System.out.println("Password incorrect, retype password(Attempt " + counter + "/3)");
											}
										}
										counter++;
									}

									/* if password was wrong 3 times, they gotta type in their email and Password AGAIN*/
									if (!reaskPw) {
										reaskEmail = false;
									}
									break;
								}
							}
						} /* reaskPW */

					}

				} /* reaskEmail */
				loggedIn = true;
			}

			/* After Login Steps */
			boolean stayLoggedIn = true;
			while (stayLoggedIn) {
				/* which operation? */
				System.out.println("Which operation do you wish to do? \n" +
						"Pick the correct number for the related operation:\n" +
						"1 - Reserve Umbrella\n" +
						"2 - Cancel Umbrella\n" +
						"3 - List Umbrellas\n" +
						"4 - Logout\n");

				/* 1 - Needs to know amnt of people */
				/* 2 - Just list the umbrellas from that Functions.*/
				/* 1 & 3 - ask for day/Hour... + which beach */
				/* 4 - Ask: Are you sure you wish to logout? */

				input = reader.readLine().trim();
				String day, month, year, startHour, endHour;
				int amntPpl;
				switch (input) {

					case "1":

						/* Reserve umbrella */
						int ola = 0;
						while (true) {
							System.out.println("How many people will be going to the beach with you?");
							input = reader.readLine().trim();
							if (Character.isDigit(input.charAt(0))) {
								praia_quantidadePessoasSombrinha(input);
								break;
							} else {
								System.out.println("Invalid Input");
							}
						}
						praia_quantidadePessoasSombrinha(input);
						boolean magic = false;
						while (!magic) {

							System.out.println("What is the beach you want to go to?\nA\nB\nC");
							input = reader.readLine().trim();
							switch (input) {
								case "A":
								case "B":
								case "C":
									magic = true;
									break;
								default:
									System.out.println("Invalid Input");
							}
						}
						changepraia(input);
						praia = input;


						System.out.println("Which day do you want to go to the beach?");
						day = reader.readLine().trim();
						changedia(day);
						System.out.println("What month you want to go to the beach?");
						month = reader.readLine().trim();
						changemes(month);
						System.out.println("What year you want to go to the beach?");
						year = reader.readLine().trim();
						changeano(year);

						while (true) {
							System.out.println("At what time do you wish to go? Opening times: 8-20");
							startHour = reader.readLine().trim();
							changestarthour(startHour);
							int start = Integer.parseInt(startHour);
							if (!(start >= 8 && start < 20)) {
								System.out.println("Invalid Option");
							} else {
								break;
							}
						}

						while (true) {
							System.out.println("When do you want to leave the beach? 8-20");
							endHour = reader.readLine().trim();
							changeendhour(endHour);
							int end = Integer.parseInt(endHour);
							if (!(end > 8 && end <= 20)) {
								System.out.println("Invalid Option");
							} else {
								break;
							}
						}

						/* Now we need to check, which umbrella's are valid options for the amount of people */
						/* We need a function, that returns an Array, with only UmbrellaNrs, that are valid for this Functions.*/
						/* thisArray = CallsTheFunction */
						int theFileNr = -1;
						String oArray;

						oArray = praia_umbrellasNr();
						String[] resultList = oArray.split(",");


						if (resultList != null) {
							for (int i = 0; i < resultList.length; i++) {
								String fileName = praia + Integer.parseInt(resultList[i]);
								if (praia_verificarDisponibilidade(fileName).equals("true")) {
									theFileNr = Integer.parseInt(resultList[i]);


									System.out.println("This Umbrella: " + praia + Integer.parseInt(resultList[i]) + " will be reserved in your name");
									break;
								}
							}
						}

						if (theFileNr != -1) {

							//escreve no ficheiro praia
							praia_reservarSombrinha((praia + theFileNr), write_combiner(day, month, year, startHour, endHour, email));
							user_reservarSombrinha(email, write_combiner(day, month, year, startHour, endHour, praia + theFileNr));
						} else {
							System.out.println("Unfortunately, there are no Umbrellas available for your specifications");
						}
						break;


					case "2":

						/* Cancel Umbrella */


						String resposta = user_listarSombrinhas(email);
						String originalString = resposta;
						String firstCharAsString = String.valueOf(originalString.charAt(0));
						int firstCharAsInt = Integer.parseInt(firstCharAsString);
						String newString = originalString.substring(1);
						System.out.println(newString);
						if (resposta.equals("")) {
							System.out.println("You dont have any reservations.");
							break;
						}
						if (!(resposta.equals(""))) {
							System.out.println("These are your Umbrella reservations:");
							System.out.println(newString);
						}
						while (true) {
							System.out.println("Which of these reservations, do you wish to cancel?");
							input = reader.readLine().trim();
							/* check if its a valid option */
							if (!(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= firstCharAsInt)) {
								System.out.println("Invalid input");
							} else {
								break;
							}
						}


						String id = thisUserFile[Integer.parseInt(input) - 1][idSombra];
						int line = Integer.parseInt(input) - 1;
						String linha = String.valueOf(line);
						user_cancelarSombrinha(linha, thisUserFile, email);

						/* check if its a valid option */
						break;

					case "3":

						/* List umbrella's on beach */
						int count1 = 0;
						while (count1 != 0) {
							System.out.println("What is the beach you want to go to?\nA\nB\nC");
							input = reader.readLine().trim();
							switch (input) {
								case "A":
								case "B":
								case "C":
									count1 = 1;
									break;
								default:
									count1 = 0;
									System.out.println("Invalid Input");
							}
						}
						changepraia(input);
						praia = input;


						System.out.println("Which day do you want to go to the beach?");
						day = reader.readLine().trim();
						changedia(day);
						System.out.println("What month you want to go to the beach?");
						month = reader.readLine().trim();
						changemes(month);
						System.out.println("What year you want to go to the beach?");
						year = reader.readLine().trim();
						changeano(year);
						int start1 = 0;
						count1 = 0;
						while (count1 != 0) {
							System.out.println("At what time do you wish to go? Opening times: 8-20");
							startHour = reader.readLine().trim();
							changestarthour(startHour);
							start1 = Integer.parseInt(startHour);
							if (!(start1 >= 8 && start1 < 20)) {
								System.out.println("Invalid Option");
							} else {
								count1 = 1;
								break;
							}
						}
						int end1 = 0;
						count1 = 0;
						while (count1 != 0) {
							System.out.println("When do you want to leave the beach? 8-20");
							endHour = reader.readLine().trim();
							changeendhour(endHour);
							end1 = Integer.parseInt(endHour);
							if (!(end1 > 8 && end1 <= 20)) {
								System.out.println("Invalid Option");
							} else {
								count1 = 1;
								break;
							}
						}
						String date = day + "/" + month + "/" + year;

						String resposta1 = praia_listarSombrinhas(date, String.valueOf(start1), String.valueOf(end1));

						System.out.println("These are the available umbrellas on beach " + praia + ":" + "\n");
						System.out.println(resposta1);

						break;

					case "4":
						/* Logout */

						stayLoggedIn = false;
						break;

					default:
						System.out.println("Invalid option try again!");
						break;

				}
			}
		}
	}


	public static void main(String[] args) {
		try {
			loginAndRegisterAndSubMenu();
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

