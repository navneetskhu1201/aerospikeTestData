import com.github.javafaker.Faker;
import org.apache.commons.text.RandomStringGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.SimpleTimeZone;

public class Practice {

    public static String generatePan() {
        return String.valueOf(randomCharString(5) +
                randomFourDigitNum(4) +
                randomCharString(1));
    }

    private static String randomCharString(int length) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('A', 'Z')
                .build();
        return generator.generate(length);
    }

    private static String randomFourDigitNum(int length) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', '9')
                .build();
        return generator.generate(length);
    }

    public static void writeIntoCsv() throws Exception {
        String csvFilePath = "aerospikeData.dsv";
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

        fileWriter.write("id,name,phone_number,date_of_birth,pan");
        fileWriter.newLine();
        fileWriter.write(generateData());
        fileWriter.close();
    }

    public static void main(String args[]) throws Exception {
        writeIntoCsv();
    }

    public static String generateData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Faker faker = new Faker(new Locale("en-IND"));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 50001; i++) {
             String record = String.format("%s,%s,%s,%s,%s",
                   i,faker.name().firstName() + " " + faker.name().lastName() , faker.phoneNumber().phoneNumber().replaceAll("-","") , sdf.format(faker.date().birthday()), generatePan());
            stringBuilder.append(record).append("\n");
        }
        return stringBuilder.toString();
    }
}
