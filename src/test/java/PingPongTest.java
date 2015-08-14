import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class PingPongTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Ping-Pong!");
  }

  @Test
  public void pingPongFor_one() {
    PingPong display = new PingPong();
    String[] one = {"1"};
    assertEquals(one, display.pingPongDisplay("1"));
  }

  @Test
  public void pingPongFor_two() {
    PingPong display = new PingPong();
    String[] one = {"1","2"};
    assertEquals(one, display.pingPongDisplay("2"));
  }

  @Test
  public void pingPongFor_three() {
    PingPong display = new PingPong();
    String[] one = {"1","2","ping"};
    assertEquals(one, display.pingPongDisplay("3"));
  }

  @Test
  public void pingPongFor_five() {
    PingPong display = new PingPong();
    String[] one = {"1","2","ping","4","pong"};
    assertEquals(one, display.pingPongDisplay("5"));
  }

  @Test
  public void pingPongFor_fifteen() {
    PingPong display = new PingPong();
    String[] one = {"1","2","ping","4","pong","ping","7","8","ping","pong","11","ping","13","14","ping-pong"};
    assertEquals(one, display.pingPongDisplay("15"));
  }

}
