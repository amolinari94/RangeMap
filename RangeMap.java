import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/** CLASS RangeMap extends {@code LinkedHashMap} to allow users to specify a numeric range as a key to a singular variable.
 * The numbers within the range do not have to be stored, and only one value is linked to each {@code ARange} key.
 *
 * @param <K>
 * @param <V>
 */

public class RangeMap<K, V> extends LinkedHashMap<ARange, Integer> {


    ARange range;
    //LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    //LinkedHashMap<ARange, Integer> map2 = new LinkedHashMap<>();
    //LinkedHashMap<Integer, RangeMap> intervalSet = new LinkedHashMap<>();

    int counter = 0;
    ArrayList<ARange> rangeSet = new ArrayList<>();
    private int startValue;

    private int endValue;
    private int _interval;
    //todo make a version with an Object as value param

    public RangeMap(){
        this.counter = 0;
    }

    public RangeMap(int interval){
        this._interval = interval;
        this.counter = 0;

    }


    //todo replace 'int value' with 'object value' and check for type in the method so user can use multiple types.
    //todo instead of iterating and initializing a value for each range, make the range object the key, and change get
    // method to iterate through range arraylist

    //EXP: V1 - creates KV pairs for every number in range for a given variable
    /*public void putR(int start, int finish, int value){
        ARange range = new ARange(start, finish);
        for (var i : range._range){
            //this.map.put(i, Integer.valueOf(value.toString()));
            this.map.put(i, value);
        }
    }*/



    /*public int get(int value){
        return map.get(value);
    }*/
    //EXP: end V1



    //EXP: V2

    public void put(int start, int finish, int value){
        ARange key = new ARange(start, finish);
        rangeSet.add(key);
        this.range = rangeSet.get(counter);
        this.startValue = range._start;
        this.endValue = range._finish;
        _interval = (finish - start);
        super.put(key, value);
        counter++;
        //intervalSet.put(_interval, this);
        //map2.put(range, value);
    }

    /*private void put(ARange range, int value) {
    }
    
     */
    
    public void put(ARange key, int value){
        rangeSet.add(key);
        this.range = rangeSet.get(counter);
        this.startValue = range._start;
        this.endValue = range._finish;
        this._interval = range._finish - range._start;
        super.put(key, value);
        counter++;
    }



    //exp replaced map2.entrySet() with this.entrySet and refactored .put method to the above super() call - didnt help speed
    //fixme - time complexity of the forEach loop is slowing down the program exponentially

    /*public int get(int value){
        int val = 0;
        for (Map.Entry<ARange, Integer> entry : this.entrySet()){
            //if (entry.getKey()._range.contains(value)){
                //val = entry.getValue();
            //}
            if (entry.getKey()._start < value && entry.getKey()._finish > value){
                val = entry.getValue();
            }
        }
        return val;
    }

     */


    public int getValue(int value){
        int val = 0;
        try{
            //todo: to find interval, round 'value' to its numeral?
            int multiplier = _interval;
            int valueKey = Math.round(value/multiplier) * multiplier;
            //rangeSet.get()
            //val = this.get(rangeSet.stream().filter(i -> i._start.equals(valueKey)));
            val = this.get(rangeSet.get((valueKey / _interval - 1)));

        }catch (IndexOutOfBoundsException e ){
            System.out.format("\nsearched value not within any Ranges inside RangeMap with interval: %d\n", _interval );

        }
        return val;
    }
}
