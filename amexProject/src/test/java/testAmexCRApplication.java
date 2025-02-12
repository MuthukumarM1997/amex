import Pages.*;
import baseUtils.CommonSetup;

import baseUtils.ExtentManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testAmexCRApplication extends CommonSetup {

    /**
     * Method to test the error messages when filling Junk data in application page
     * @param firstName customer firstname from xmx suite
     * @param lastName customer last name from xmx suite
     * @param dob dob from xmx suite
     * @param email email from xmx suite
     * @param countrycode countrycode from xmx suite
     * @param phonenumber phonenumber from xmx suite
     */
    @Parameters({"firstName", "LastName", "dob", "email", "countrycode", "phonenumber"})
    @Test
    public void amexNegativeScenario(String firstName, String lastName, String dob, String email, String countrycode,
                                     String phonenumber) {
        HomePage homepage = new HomePage(driver);
        TypesOfCardsPage typesOfCardsPage = new TypesOfCardsPage(driver);
        GoldCardDetailsPage goldCardDetailsPage = new GoldCardDetailsPage(driver);
        ApplyPage applyPage = new ApplyPage(driver);
        try {
            ExtentManager.test.pass("Navigated successfully to the home page");
            ExtentManager.test.info("click on “Cartes American Express”");
            homepage.clickAmexCard();
            ExtentManager.test.pass("Navigated successfully to the types of card page");
            ExtentManager.test.info("clicks on “En Savior Plus” Under “Cartes Gold\n" +
                    "American Express”");
            typesOfCardsPage.clickLearnMoreBtn();
            ExtentManager.test.pass("Navigated successfully to the Gold Card Details page page");
            ExtentManager.test.info("clicks on Demandez Votre Carte");
            goldCardDetailsPage.clickRequestCardBtn();
            ExtentManager.test.pass("Navigated successfully to the Gold Card Application page");
            applyPage.clickacceptCookieBtn();
            ExtentManager.test.info("Entering First name");
            applyPage.enterFirstName(firstName);
            ExtentManager.test.info("Entering Last name");
            applyPage.enterLastName(lastName);
            ExtentManager.test.info("Entering date of birth");
            applyPage.enterdob(dob);
            ExtentManager.test.info("Entering Email");
            applyPage.enterEmail(email);
            ExtentManager.test.info("Selecting country code");
            applyPage.enterCountryCode(countrycode);
            ExtentManager.test.info("Entering Phone number");
            applyPage.enterMobile(phonenumber);
            applyPage.submitBtn();
            SoftAssert softAssert = new SoftAssert();
            ExtentManager.test.info("Verifying the error messages for junk details");
            softAssert.assertEquals(applyPage.civilityErrorMsg(), "erci de préciser votre civilité.");
            softAssert.assertEquals(applyPage.getfirstNameErrorMsg(), "rénom obligatoire.");
            softAssert.assertEquals(applyPage.getlastnameErrorMsg(), "om obligatoire.");
            softAssert.assertEquals(applyPage.getdobErrorMsg(), "Vous devez avoir plus de 18 ans.");
            softAssert.assertEquals(applyPage.getemailErrorMsg(), "Merci de vérifier le format de votre adresse email " +
                    "(exemple : nom@domaine.fr). Les caractères " +
                    "autorisés sont : lettres, chiffres, tirets (_-), arobase (@), et point (.).");
            softAssert.assertEquals(applyPage.getmobileNumberErrorMsg(), "Téléphone mobile obligatoire en chiffres " +
                    "uniquement et sans espaces. Exemple France, " +
                    "Guadeloupe, Martinique, Guyane, La Réunion, Saint- Barthélemy, Saint Martin, Mayotte: - 0612345678 - " +
                    "0712345678 IMPORTANT : Pour tout autre pays ou région, dont Polynésie Française et Nouvelle Calédonie," +
                    " merci de sélectionner l’indicatif du territoire correspondant et saisir le numéro de mobile sans le " +
                    "préfixe « 0 » au début.");
            softAssert.assertAll();
            ExtentManager.test.pass("Validated all the error messages under application page when filling junk data");
        } catch (AssertionError e) {
            ExtentManager.test.fail(e.getMessage());
        }
    }
}
