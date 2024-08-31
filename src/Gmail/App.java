package Gmail;

public class App {
    public static void main(String[] args) {

        GEmailSender gEmailSender = new GEmailSender();
        String to = "priyadharshini3120@gmail.com";
        String from = "sakthivelms1405@gmail.com";
        String subject = "vetri";
        String text = "Gradle project la work seitha emial";
        boolean b = gEmailSender.sendEmail(to, from, subject, text);
        if (b) {
            System.out.println("Email is sent successfully");
        } else {
            System.out.println("There is problem in sending email");
        }
    }
}
