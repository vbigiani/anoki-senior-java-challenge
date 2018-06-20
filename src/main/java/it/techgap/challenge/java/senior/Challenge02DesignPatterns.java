package it.techgap.challenge.java.senior;

public class Challenge02DesignPatterns {

    /**
     * This class should be well-done singleton
     */
    public static class Singleton {

        public static final Singleton IN = new Singleton();

        private Singleton() {
        }

        /**
         * TODO: Implement this. Make sure it is a singleton.
         * NOTE: Feel free to change everything inside this class, except for the name and return value of this method
         *
         * @return You know what :)
         */
        public static Singleton getInstance() {
            return IN;
        }

    }

}
