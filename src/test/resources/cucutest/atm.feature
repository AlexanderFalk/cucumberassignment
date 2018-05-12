Feature: Withdraw fixed amount

  Scenario Outline: No overdraw
  Given I have <Balance> in my account

  When I choose to withdraw the fixed amount of <Withdrawal>

  Then I should <Outcome>

  And the balance of my account should be <Remaining>

  Examples:
  |Balance|Withdrawal|Remaining|Outcome         |
  |$400   |$80       |$320     |Recieve $80 cash|
  |$1000   |$300       |$700     |Recieve $300 cash|
  |$555   |$55       |$500     |Recieve $55 cash|
  |$12000  |$2500       |$9500     |Recieve $2500 cash|