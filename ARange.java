import java.util.ArrayList;

public class ARange {

    public Integer _start;
    public Integer _finish;
    public double startDouble;
    public double finishDouble;
    public ArrayList<Integer> _range = new ArrayList<>();

    public ARange (double start, double finish){
        this.startDouble = start;
        this._start = castToInt(start);
        this.finishDouble = finish;
        this._finish = castToInt(finish);
        //generateRange();
    }

    private void generateRange(){
        for (int i = _start; i < _finish; i++) {
            _range.add(i);
        }
    }

    private int castToInt(double num){
        return (int) num;
    }

    public int getStart(){
        return _start;
    }


}
