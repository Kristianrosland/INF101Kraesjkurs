public interface IVector {


    /**
     * @return Antall elementer i vektoren
     */
    int size();

    /**
     *
     * @param index
     * @return Elementer som ligger på posisjon 'index'
     * @throws IndexOutOfBoundsException ved ugyldig index
     */
    double get(int index);

    /**
     * Elementvis addisjon/subtraksjon/multiplikasjon/division
     * av denne vektoren med en annen vektor med like mange elementer
     *
     * E.g., [0,1,2,3] + [2,3,4,5] = [2,3,6,8]
     *
     * @return En ny IVektor med resultatet
     */
    IVector add(IVector addend);
    IVector sub(IVector subtrahend);
    IVector mul(IVector factor);
    IVector div(IVector divisor);
}
