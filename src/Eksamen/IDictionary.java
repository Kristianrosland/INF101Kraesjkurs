package Eksamen;
/**
 ** Ordliste som holder rede på gyldige ord
 */
public interface IDictionary {

    /**
     * @return true hvis word er et gyldig ord
     */
    boolean isValidWord(String word);
}
