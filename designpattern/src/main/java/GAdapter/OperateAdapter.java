package GAdapter;

/**
 * @author ZXY
 * @ClassName: OperationAdapter
 * @Description:
 * @date 2017/3/29 13:29
 */
public class OperateAdapter implements Operate {
    private CalOne calOne;

    public OperateAdapter(){
        this.calOne = new CalOne();
    }

    @Override
    public void doMinus() {
        calOne.doMinus();
    }
}
