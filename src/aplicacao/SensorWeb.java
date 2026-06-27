package aplicacao;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SensorWeb {
    private final String URL = "https://clientes.sensorweb.com.br/ache/login.htm";
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String usuario = "carlos.roberto";
    private final String senha = "Web@3104";

    public SensorWeb() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void abrirSensorWeb() {
        /*
        Metodo para abrir página na web
        */
        driver.get(URL);
    }

    public void loginSensorWeb() {
        driver.findElement(By.id("user-input")).sendKeys(usuario);
        driver.findElement(By.id("password-input")).sendKeys(senha);
        driver.findElement(By.className("standard-btn")).click();
    }

    public void clicarBotaoGrafico() {
        WebElement botao = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='icon-grafic']")));
        botao.click();
    }

    public void selecionarSensoresTemperatura() {
        for (int valor = 526; valor < 596; valor += 2) {
            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@type='checkbox' and @value='" + valor + "']")));
            checkbox.click();
        }
    }

    public void selecionarSensoresUmidade() {
        for (int valor = 596; valor < 664; valor += 2) {
            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@type='checkbox' and @value='" + valor + "']")));
            checkbox.click();
        }
    }

    public void selecionarSensoresTemperaturaCf() {
        for (int valor = 1051; valor < 1057; valor += 2) {
            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@type='checkbox' and @value='" + valor + "']")));
            checkbox.click();
        }
    }

    public void definirLarguraGrafico() {
        WebElement element = driver.findElement(By.id("imageWidth"));
        element.clear();
        element.sendKeys("1300");
    }

    public void definirAlturaGrafico() {
        WebElement element = driver.findElement(By.id("imageHeight"));
        element.clear();
        element.sendKeys("550");
    }

    public void carregarGrafico() {
        WebElement botao = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("imageChartImg")));
        botao.click();

        System.out.println("Pressione Enter para finalizar e fechar o navegador...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
