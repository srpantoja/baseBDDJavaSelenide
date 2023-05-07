package dataProviders;

import managers.FileReaderManager;

public class Constants {

    public static String BASE_URL = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
    public static String LOGIN_URL = "/login";
    public static String REGISTER_URL = "/cadastro";
    public static String LOGGED_URL = "/logar";
    public static String TOAST_MESSAGE_LOGIN = "Bem vindo, ?!";
    public static String TOAST_MESSAGE_LOGOUT = "Até Logo!";
    public static String TOAST_MESSAGE_LOGIN_ERROR = "Problemas com o login do usuário";
    public static String TOAST_MESSAGE_MANDATORY_EMAIL = "Email é um campo obrigatório";
    public static String TOAST_MESSAGE_MANDATORY_PASSWORD = "Senha é um campo obrigatório";
    public static String TOAST_MESSAGE_INCORRECT_CREDENTIALS = "Problemas com o login do usuário";
    public static String TOOLTIP_MESSAGE_INVALID_EMAIL = "Inclua um \"@\" no endereço de e-mail. \"?\" está com um \"@\" faltando.";
    public static String TOOLTIP_MESSAGE_INCOMPLETE_EMAIL = "Insira uma parte depois de \"@\". \"?\" está incompleto.";

}
