package FBuilder;

/**
 * @author ZXY
 * @ClassName: HeroBuilder
 * @Description:
 * @date 2017/3/29 10:39
 */
class HeroBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        actor.setType("a");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("a");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("a");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("a");
    }
}
