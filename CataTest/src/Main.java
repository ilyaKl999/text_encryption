public class Main {
    public static void main(String[] args) {
        //decoding_USER_Encryption_WITH_KEY(String KEY_USER_SET_FILE)// МЕТОД РАСШИФРОВЩИК!!!!!!!!!!!!!!!!!!!!!!!!! ПРИНИМАЕТ ТЕКСТ КОТОРЫЙ НУЖНО РАСШИФРОВАТЬ,
        // КЛЮЧ ЖЕ ПАРСИТ В ПЕРВЫХ 24 СИМВОЛАХ ТЕКСТА СФОРМИРОВАННОГО ПОСЛЕ ШИФРОВАНИЯ(РАНДОМНЫЙ ЦИФРЫ ПРИВАРЕНЫЕ ПРИ СОЗДАНИИ ТЕКСТА)
        //generation_KEY_USER_Encryption(String KEY_USER_SET_FILE)//- МЕТОД ЗАШИФРОВЩИК, ФОРМИРУЕТ 3 КЛЮЧА ИЗ РАНДОМНЫХ ЧИСЕЛ И ВВАРИВАЕТ ИХ В НАЧАЛО ТЕКСТА
        // КЛЮЧ ВСЕГДА ПРИ ЗАПУСКЕ ПРОГРАМЫ РАЗНЫЙ ТАК КАК ОСНОВАН НА MATH.RANDOM!!!!!!!!! 3 ключа 3 стадии присваивания

        ////////////////////////ТЕСТЫ ПРОСТОО!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String user_Text_TEST1 = "Привет, меня зовут Илья и я тестирую шифрование по средством Java Тут буду хранить пароли " +
                "Секретные текста летописи и вести дневник про пердеж.";
        String user_Text_TEST2 = "примером рекурсии в математике являет рассматривается класс так называемых «примитивно " +
                "рекурсивных» функций. Определение примитивно рекурсивной функции также рекурсивно, оно задаёт набор примитивных функций " +
                "и набор правил; функция является примитивно рекурсивной, если она может быть представлена как комбинация прими";
        String user_Text_TEST3 = " потенциально бесконечное вычисление, причём без явных ";
        String user_Text_TEST4 = " математике являет рассматривается класс";
        String user_Text_TEST5 = " меня зовут Илья";

        String a = Encryption.generation_KEY_USER_Encryption(user_Text_TEST1);
        System.out.println(a);
        System.out.println(Encryption.decoding_USER_Encryption_WITH_KEY(a));
        System.out.println("_______________________________________________________________________________");

        String a1 = Encryption.generation_KEY_USER_Encryption(user_Text_TEST2);
        System.out.println(a1);
        System.out.println(Encryption.decoding_USER_Encryption_WITH_KEY(a1));
        System.out.println("_______________________________________________________________________________");


        String a2 = Encryption.generation_KEY_USER_Encryption(user_Text_TEST3);
        System.out.println(a2);
        System.out.println(Encryption.decoding_USER_Encryption_WITH_KEY(a2));
        System.out.println("_______________________________________________________________________________");


        String a3 = Encryption.generation_KEY_USER_Encryption(user_Text_TEST4);
        System.out.println(a3);
        System.out.println(Encryption.decoding_USER_Encryption_WITH_KEY(a3));
        System.out.println("_______________________________________________________________________________");


        String a4 = Encryption.generation_KEY_USER_Encryption(user_Text_TEST5);
        System.out.println(a3);
        System.out.println(Encryption.decoding_USER_Encryption_WITH_KEY(a4));
        System.out.println("_______________________________________________________________________________");


        ////////////////////////ТЕСТЫ ПРОСТОО!!!!!!!!!!!!!!!!!!!!!!!!!!!!!////////////////////////ТЕСТЫ ПРОСТОО!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    }

    public class Encryption {                                                           //КЛАСС ШИФРОВАНИЕ!
        private String KEY_USER_SET_FILE = "";
        private byte KEY_USER_GET_FILE = (byte) random_In_ARange(1, 66);
        static byte KEY_1 = (byte) random_In_ARange(1, 9);
        static byte KEY_2 = (byte) random_In_ARange(10, 99);
        static byte KEY_3 = (byte) random_In_ARange(100, 127);

        public Encryption(String KEY_USER_SET_FILE) {                          //КОНСТРУКТОР
            this.KEY_USER_SET_FILE = KEY_USER_SET_FILE;
        }

        static int random_In_ARange(int min, int max) {                                  //Получение рандомного значения из промеж_утка!
            return (int) (Math.random() * ((max - min) + 1)) + min;
        }

        static String KEY_ADD_TEXT = "ADD";
        static String REJEST = "REG";

        static String generation_KEY_USER_Encryption(String KEY_USER_SET_FILE) {
            final int CONST_PATTERN = 12;
            StringBuilder FILE_SECRET_BUILD = new StringBuilder();
            byte counter = 0;
            FILE_SECRET_BUILD = FILE_SECRET_BUILD.append(KEY_ADD_TEXT + REJEST + KEY_1 + REJEST + KEY_2 + REJEST + KEY_3 + REJEST + KEY_ADD_TEXT);
            for (int i = 0; i < KEY_USER_SET_FILE.length(); i++) {
                if (i % CONST_PATTERN == 0) {
                    counter++;
                }
                if (counter == 0) {
                    FILE_SECRET_BUILD = FILE_SECRET_BUILD.append((char) (KEY_USER_SET_FILE.charAt(i) + KEY_1));
                } else if (counter == 1) {
                    FILE_SECRET_BUILD = FILE_SECRET_BUILD.append((char) (KEY_USER_SET_FILE.charAt(i) + KEY_2));
                } else if (counter == 2) {
                    FILE_SECRET_BUILD = FILE_SECRET_BUILD.append((char) (KEY_USER_SET_FILE.charAt(i) + KEY_3));
                }
                counter = 0;
            }
            return FILE_SECRET_BUILD.toString();
        }

        static String decoding_USER_Encryption_WITH_KEY(String KEY_USER_SET_FILE) {               // МЕТОД РАСШИФРОВЩИК!!!!!!!!!!!!!!!!!!!!!!!!! ПРИНИМАЕТ РАСШИФРОВАНЫЙ ТЕКСТ
            String intoClass = KEY_USER_SET_FILE;
            String getKey = new String(intoClass.split(KEY_ADD_TEXT)[1]);
            String[] key = getKey.split(REJEST);
            final int CONST_PATTERN = 12;
            StringBuilder FILE_SECRET_BUILD = new StringBuilder();
            byte counter = 0;
            byte KEY_11 = Byte.valueOf(key[1]);
            byte KEY_22 = Byte.valueOf(key[2]);
            byte KEY_33 = Byte.valueOf(key[3]);

            for (int i = 0; i < KEY_USER_SET_FILE.length(); i++) {
                if (i % CONST_PATTERN == 0) {
                    counter++;
                }
                if (counter == 0) {
                    FILE_SECRET_BUILD = FILE_SECRET_BUILD.append((char) (KEY_USER_SET_FILE.charAt(i) - KEY_11));
                } else if (counter == 1) {
                    FILE_SECRET_BUILD = FILE_SECRET_BUILD.append((char) (KEY_USER_SET_FILE.charAt(i) - KEY_22));
                } else if (counter == 2) {
                    FILE_SECRET_BUILD = FILE_SECRET_BUILD.append((char) (KEY_USER_SET_FILE.charAt(i) - KEY_33));
                }
                counter = 0;
            }
            return FILE_SECRET_BUILD.toString().substring(24);
        }
    }
}