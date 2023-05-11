Feature: As a QA, I would like to verify all negative scenarios for login
Scenario Outline: : Select ‘Sign in’, and enter as many negative scenarios as possible. Verify that a error message is displayed and the text that it
  contains is as expected.

 Given launches chrome browser.
 When user opens URL "https://www.bbc.co.uk/sport/football/scores-fixtures"
 And user clicks the sign in button
 And user enters incorrect "<username>" and "<password>"
 Then user should see a  "<message>"



  Examples:
    | username | password | message|

    | madodaash@gmail.com | Password@123 | Looks like either the email/username or password is wrong. Try again, reset your password or get help.|
    | madodaa             | pass123      | Sorry, that password is too short.It needs to be eight characters or more.                            |
    |madoda               |              | Please check and try again. |
   |                     |pass          | Please check and try again. |
   |                     |              | Plea se check and try again. |