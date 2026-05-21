import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Введення даних
        try {
            Scanner scannerObj = new Scanner(System.in);
            System.out.println("Введіть текст: ");
            String textInput = scannerObj.nextLine();
            System.out.println("-------------------------------");

            // Перевіряємо текст
            validateText(textInput);

            // Обрахунки
            StringBuilder text = new StringBuilder(textInput);
            StringBuilder newText = calculateText(text);

            // Виведення даних
            System.out.println(newText);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка задання тексту: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }


    /**
     * Перевіряє правильність тексту
     *
     * @param text текст
     * @throws IllegalArgumentException якщо введений текст некоректний
     */
    public static void validateText(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Немає введеного тексту");
        }
    }


    /**
     * Прибирає в тексті всі наступні входження першої літери враховуючи великі та малі літери
     *
     * @param text текст
     * @return оброблений text
     */
    public static StringBuilder calculateText(StringBuilder text) {
        char firstLetter = text.charAt(0);
        char firstLetter_lower = Character.toLowerCase(firstLetter);
        char firstLetter_upper = Character.toUpperCase(firstLetter);

        for (int i = text.length() - 1; i > 0; i--) {
            if (text.charAt(i) == firstLetter_lower || text.charAt(i) == firstLetter_upper) {
                text.deleteCharAt(i);
            }
        }

        return text;
    }
}