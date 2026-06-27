package aplicacao;


public class Sensors {
    public static void main(String[] args) {
        SensorWeb objSensorWeb = new SensorWeb();
        objSensorWeb.abrirSensorWeb();
        objSensorWeb.loginSensorWeb();
        objSensorWeb.clicarBotaoGrafico();
//        objSensorWeb.selecionarSensoresTemperatura();
        objSensorWeb.selecionarSensoresUmidade();
//        objSensorWeb.selecionarSensoresTemperaturaCf();
        objSensorWeb.definirLarguraGrafico();
        objSensorWeb.definirAlturaGrafico();
        objSensorWeb.carregarGrafico();
    }
}
