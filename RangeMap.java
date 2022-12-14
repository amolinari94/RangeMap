
import java.util.ArrayList;
import java.util.LinkedHashMap;




/** CLASS RangeMap extends {@code LinkedHashMap} to allow users to specify a numeric range as a key to a singular {@code Object} value.
 * The numbers within the range do not have to be stored, and only one value is linked to each {@code ARange} key.
 *
 * @author Alex Molinari
 */

public class RangeMap extends LinkedHashMap<ARange, Object> {
    ARange range;
    int counter = 0;
    ArrayList<ARange> rangeSet = new ArrayList<>();
    private long _interval;

    ArrayList<Integer> startValSet = new ArrayList<Integer>();


    /**CONSTRUCTOR default {@code RangeMap} constructor, infers interval of the range-set once {@code RangeMap.put()} is called.
     *
     */
    public RangeMap(){
        this.counter = 0;
    }

    /**CONSTRUCTOR secondary constructor, takes the range-interval as a parameter, instead of inferring from {@code RangeMap.put()}.
     *
     * @param interval the number of values contained within each {@code ARange} range-key.
     */

    public RangeMap(int interval){
        this._interval = interval;
        this.counter = 0;
    }

    /** METHOD put is the primary {@code RangeMap.put()} method.  Takes a range-start {@code Object}, range-end
     * {@code Object}, and a value {@code Object}.  start and finish are used as parameters to instantiate a new {@code ARange},
     * and then parsed and subtracted from each other to initialize the {@code _interval} {@code long} member.
     *
     * With each {@code RangeMap.put()} call, a new ARange instance is created, and added to the {@code rangeSet} {@code ArrayList}
     * member.  {@code super.put()} then initializes the {@code ARange} key & the {@code Object} value as a new {@code entry}.
     *
     * Member objects {@code ARange} range & {@code counter} are not currently being used.
     *
     * @param start start-value for desired range. Must be an integer-based number, but does not need to be of {@code Type} {@code Integer}.
     * @param finish end-value for desired range. Must be an integer-based number, but does not need to be of {@code Type} {@code Integer}.
     * @param value the desired {@code Object} for the Key in the Key/Value pair to point to.
     */
    public void put(Object start, Object finish, Object value){ //were ints, trying as objects so theres no type restriction
        ARange key = null;

        try{
            key = new RangeKey( start,  finish);
            this._interval =  Long.parseLong(finish.toString())- Long.parseLong(start.toString());
        }catch (ClassCastException e){
            System.out.println("Value input cannot be cast to appropriate type");
        }catch (ArithmeticException r){
            System.out.println("Error translating input values - Check for typos");
        }
        rangeSet.add(key);
        startValSet.add(key._start);
        this.range = rangeSet.get(counter);
        super.put(key, value);
        counter++;
    }


    /**METHOD put - Secondary {@code RangeMap.put()} method that takes an {@code ARange} that has already been instantiated
     * outside the class, instead of taking individual start and end values. Takes an {@code int} as a value. Probably depreciated by the
     * method above.
     *
     * @param key instance of {@code ARange} to be set as {@code RangeMap} key.
     * @param value value that user wants the key to point to.
     */
    public void put(ARange key, int value){
        startValSet.add(key._start);
        rangeSet.add(key);
        this.range = rangeSet.get(counter);
        this._interval = range._finish - range._start;
        super.put(key, value);
        counter++;
    }

    /**METHOD get finds the first number in the corresponding {@code ARange} key for an input value, then gets that
     * ObjectID as reference from the {@code rangeSet} {@code ArrayList} member. The input {@code value} is divided
     * by the {@code _interval}, rounded, and then multiplied by the _interval to find the first value in that
     * range. This value is used to reference an index spot in the {@code rangeSet} holding {@code ARange} instances.
     * If the collection starts at 0, 1 is subtracted from the index. The corresponding Object ID is the key for the
     * desired value in this {@code RangeMap}.
     *
     * @param value any value to be searched in the ranges of this {@code RangeMap}
     * @return {@code int} value that is pointed to by the range-key that holds the {@code value} input parameter.
     */
    public int get(int value){
        int val = 0;
        try{
            long multiplier = _interval;
            long valueKey = Math.round( value /multiplier) * multiplier;
            int index = (int) ((int) valueKey/_interval);
            val = (startValSet.get(0)==0) ? (int)super.get(rangeSet.get(index)) : (int)super.get(rangeSet.get(index-1));
        }catch (IndexOutOfBoundsException e ){
            System.out.format("\nError: Searched value not in RangeMap with interval: %d\n", _interval );
        }
        return val;
    }
}
