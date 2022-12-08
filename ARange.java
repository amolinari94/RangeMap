import java.util.ArrayList;


/**
 * ABSTRACT CLASS ARange is a simple class that holds a 'range' of numbers by storing the start and end values that the user specifies.
 *
 * @author Alex Molinari
 */
public abstract class ARange {
    public Integer _start;
    public Integer _finish;
    public double startDouble;
    public double finishDouble;
    public ArrayList<Integer> _range = new ArrayList<>();

    /**CONSTRUCTOR takes {@code double} values and casts them to type {@code int}.
     *
     * @param start start value of desired range.
     * @param finish end value of desired range.
     */
    public ARange (double start, double finish){
        this.startDouble = start;
        this._start = castToInt(start);
        this.finishDouble = finish;
        this._finish = castToInt(finish);
        //generateRange();
    }

    /**CONSTRUCTOR secondary constructor takes an {@code Object} for the start and end values for the desired range.
     *
     * @param start start value for desired range.
     * @param finish end value for desired range.
     */

    public ARange (Object start, Object finish){
        this._start = (int) start;
        this._finish = (int) finish;
    }

    /**METHOD generateRange initializes an {@code ArrayList} of every value in the user-designated range.  Not necessary
     * for functionality of {@code RangeMap}.
     *
     */

    private void generateRange(){
        for (int i = _start; i < _finish; i++) {
            _range.add(i);
        }
    }

    /**METHOD castToInt casts a {@code double} input value to tyoe {@code int}.
     *
     * @param num number that needs to be converted.
     * @return converted number.
     */
    private int castToInt(double num){
        return (int) num;
    }

    /**METHOD getStart returns the start value of the range.
     *
     * @return start value of {@code ARange} instance.
     */
    public int getStart(){
        return _start;
    }


}
