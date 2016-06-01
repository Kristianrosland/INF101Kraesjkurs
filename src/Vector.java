public class Vector implements IVector {

    /**
     * Vector-data, ikke null
     */
    private double[] data;

    public Vector(double[] elements){
        data = elements;
    }


    public int size() {
        return data.length;
    }


    public double get(int index) {
        if(index <0 || index >= data.length){
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return data[index];
    }

    public IVector add(IVector addend) {
        double[] sum = new double[size()];
        for(int i = 0;i < data.length; i++){
            sum[i] = data[i] + addend.get(i);
        }
        return new Vector(sum);
    }

    public IVector sub(IVector subtrahend) {
        double[] sum = new double[size()];
        for(int i = 0; i < data.length; i++){
            sum[i] = data[i] - subtrahend.get(i);
        }
        return new Vector(sum);
    }

    public IVector mul(IVector factor) {
        double[] sum = new double[size()];
        for(int i = 0; i < data.length; i++){
            sum[i] = data[i] * factor.get(i);
        }
        return new Vector(sum);
    }

    public IVector div(IVector divisor) {
        double[] sum = new double[size()];
        for(int i = 0; i < data.length; i++){
            sum[i] = data[i] / divisor.get(i);
        }
        return new Vector(sum);
    }
}
