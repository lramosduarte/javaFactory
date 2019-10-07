package com.github.lramosduarte.examples;

import static com.github.lramosduarte.fake.FakeDataGenerator.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ExamplesTest {
  @Test
  public void demonstrateHowEasyThisIsToUse() {
    ExampleModel model = fake(ExampleModel.class);
    System.out.println(model);

    Assertions.assertNotNull(model.getAccountName());
    Assertions.assertNotNull(model.getBalance());
    Assertions.assertNotNull(model.isEnabled());
    Assertions.assertTrue(model.getAliases().size() > 0);
  }

  public static class ExampleModel {
    private String accountName;
    private BigDecimal balance;
    private boolean enabled;

    private List<String> aliases;

    public String getAccountName() {
      return accountName;
    }

    public void setAccountName(String accountName) {
      this.accountName = accountName;
    }

    public BigDecimal getBalance() {
      return balance;
    }

    public void setBalance(BigDecimal balance) {
      this.balance = balance;
    }

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }

    public List<String> getAliases() {
      return aliases;
    }

    public void setAliases(List<String> aliases) {
      this.aliases = aliases;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("ExampleModel{");
      sb.append("accountName='").append(accountName).append('\'');
      sb.append(", balance=").append(balance);
      sb.append(", enabled=").append(enabled);
      sb.append(", aliases=").append(aliases);
      sb.append('}');
      return sb.toString();
    }
  }
}
