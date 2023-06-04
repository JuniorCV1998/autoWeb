package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Junior\\OneDrive\\Documentos\\Proyecto Apps\\Automatización\\autoWeb\\src\\test\\resources\\features", //Path From Content Root
glue = "definitions",
tags = "@smoke",
plugin = {"html:target/cucumber-report/index.html","json:target/cucumber-report/cucumber.json"})
public class runtest {

}
