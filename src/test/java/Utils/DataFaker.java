package Utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
public class DataFaker {
    public static Faker faker = new Faker();

    //      Faker functions list :-
//        1. getRandomNumber
//        2. getRandomAlphabet
//        3. getRandomNumber
//        4. getRandoMobileNumber
//        5. getRandomEmailAddress
//        6. getRandomDate
    public static String getRandomNumber(int count){
        return faker.number().digits(count);
    }

    public static String getRandomAlphabet(int size){
        return RandomStringUtils.randomAlphabetic(size);
    }

    public static String getRandomNumber(int min, int max){
        return String.valueOf(faker.number().numberBetween(min, max));
    }

    public static String getRandoMobileNumber(){
        return faker.number().numberBetween(6, 9) + faker.number().digits(9);
    }
    public static String getRandomEmailAdderess(){
        return faker.internet().emailAddress();
    }
    public static String getRandomDate(){
        return faker.date().birthday().toString().substring(0,10);
    }
}
