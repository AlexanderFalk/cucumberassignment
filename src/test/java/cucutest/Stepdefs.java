package cucutest;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Test;

import static org.junit.Assert.*;

public class Stepdefs {

    class ATM {
        double balance;
        double withdrawal;
        double remaining;

        ATM(double balance) {
            this.balance = balance;
        }

        double withdraw(double amount) {
            this.withdrawal = amount;
            this.balance -= amount;
            this.remaining = this.balance;
            return this.remaining;
        }

        double outcome() {
            return this.withdrawal;
        }
    }

    ATM atm;

    @Given("^I have \\$(\\d+) in my account$")
    public void iHaveBalanceInMyAccount(int expected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        atm = new ATM(expected);
    }

    @When("^I choose to withdraw the fixed amount of \\$(\\d+)$")
    public void iChooseToWithdrawTheFixedAmountOfWithdrawal(int expected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        atm.withdraw(expected);
    }


    @Then("^I should Recieve \\$(\\d+) cash$")
    public void iShouldOutcome(int expected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expected, atm.outcome(), 5);
    }


    @And("^the balance of my account should be \\$(\\d+)$")
    public void theBalanceOfMyAccountShouldBeRemaining(int expected) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(expected, atm.balance, 5);
    }
}