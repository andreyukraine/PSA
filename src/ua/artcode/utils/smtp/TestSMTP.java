package ua.artcode.utils.smtp;

/**
 * Created by aleksandrnagorniy on 18.09.16.
 */
public class TestSMTP {

    public static final String USER_NAME_FOR_SMTP = "psv.aco15@gmail.com";
    public static final String PASS_WORD_FOR_SMTP = "PsaACO15";

    public static void main(String[] args) {

        ISMTPController testSMTP = new SMTPSender(USER_NAME_FOR_SMTP, PASS_WORD_FOR_SMTP);

        boolean res = testSMTP.sentMessage("psv.aco15@gmail.com", "test subject", "test message", "Best regards");
        System.out.println(res);

    }

}
