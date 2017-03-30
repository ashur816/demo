package FBuilder;

/**
 * @author ZXY
 * @ClassName: Client
 * @Description:
 * @date 2017/3/29 10:36
 */
class ActorController {

    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab) {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        Actor actor = ab.createActor();
        return actor;
    }

    public static void main(String[] args) {
        ActorController a = new ActorController();
        ActorBuilder actorBuilder = new HeroBuilder();
        a.construct(actorBuilder);
    }
}
