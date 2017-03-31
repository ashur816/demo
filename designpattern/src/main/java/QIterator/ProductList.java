package QIterator;

import java.util.List;

/**
 * @author ZXY
 * @ClassName: ConcreteAggregate
 * @Description: 具体聚合类
 * @date 2017/3/31 10:40
 */
class ProductList extends AbstractObjectList {
    public ProductList(List objects) {
        super(objects);
    }

    //实现创建迭代器对象的具体工厂方法
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
