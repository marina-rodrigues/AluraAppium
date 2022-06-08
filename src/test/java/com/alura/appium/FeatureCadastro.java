package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObject;
import com.alura.appium.PageObjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static com.alura.appium.AppiumDriverConfig.Instance;


public class FeatureCadastro {

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_confere(){
        AppiumDriver driver = Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "456");
        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
}
    @Test
    public void posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaDeCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Bugan", "123", "123");
        telaLogin.BuscarElementos();

    }

}
