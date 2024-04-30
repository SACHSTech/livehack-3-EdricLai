class Problem1 extends ConsoleProgram {

  /**
  * Student account registration program
  * @author: EdricLai
  */

  public void run() {
    // introduction
    System.out.println("***** Student Account Registration *****");

    // inputs
    String strFirstName = readLine("Enter your first name: ");
    String strLastName = readLine("Enter your last name: ");
    String strStudentNum = readLine("Enter your student number: ");
    String strPassword = readLine("Enter a new password: ");

    // output
    System.out.println("Your username is: " + createUserName(strFirstName, strLastName, strStudentNum));
    System.out.println("Valid password: " + validatePassword(strPassword));
  }

  /**
   * returns username
   * @param1 strFirstName   input first name
   * @param2 strLastName    input last name
   * @param3 strStudentNum  input student number
   * @return strUserName    username
  */
  private String createUserName(String strFirstName, String strLastName, String strStudentNum) {
    // exception: blank character
    String strCompiled = strFirstName + strLastName + strStudentNum;
    for (int i = 0; i < strCompiled.length(); i++) {
      // checks every input chars
      char chrLetter = strCompiled.charAt(i);
      if (Character.isWhitespace(chrLetter)) {
        throw new IllegalArgumentException("blank characters are invalid.");
      }
    }

    // exception: password length
    if (strStudentNum.length() < 9) {
      throw new IllegalArgumentException("student number must be 9 digits long.");
    }

    // init local variables
    String strUserName = "";
    String strLowercase = "";
    char charUppercase = strFirstName.charAt(0);
    
    // uppercase
    charUppercase = Character.toUpperCase(charUppercase);

    // lowercase
    for (int i = 0; i < 4; i++) {
      // lowercases the first 4 chars
      char chrLetter = strLastName.charAt(i);
      chrLetter = Character.toLowerCase(chrLetter);
      strLowercase += chrLetter;
    }

    // forms username
    strUserName = charUppercase + strLowercase;
    strUserName += strStudentNum.substring(strStudentNum.length() - 3, strStudentNum.length());
    return strUserName;
  }
  
  /**
   * returns validity of password
   * @param1 strPassword  input password
   * @return boolValid    is password valid or not
  */
  private boolean validatePassword(String strPassword) {
    // init local variables
    boolean boolValid = false;
    char chrLetter;

    // valid check
    if (strPassword.length() >= 7) {
      for (int i = 0; i < strPassword.length(); i++) {
        chrLetter = strPassword.charAt(i);
        // letter or digit rule
        if (!(Character.isLetterOrDigit(chrLetter))) {
          boolValid = false;
          break;
        }
        // one uppercase rule
        if (Character.isUpperCase(chrLetter)) {
          boolValid = true;
        }
      }
    }
    
    // return validity
    return boolValid;
  }
}