/**
 * RangeKey is a class that extends {@code ARange}, but does not add functionality.
 *
 * @author Alex Molinari
 */


public class RangeKey extends ARange{

    /**
     * CONSTRUCTOR Instantiates an {@code Object} from the {@code ARange} Abstract Class.
     * @param start start value for desired range.
     * @param finish end value for desired range.
     */
    public RangeKey(Object start, Object finish) {
        super(start, finish);
    }
}
