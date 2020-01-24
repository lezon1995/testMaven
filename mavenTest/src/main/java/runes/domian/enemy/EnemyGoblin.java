package runes.domian.enemy;


import runes.domian.base.*;
import runes.domian.skill.IAttackSkill;

/**
 * 初级小怪哥布林
 *
 * @author Wentworth .
 * @date 2020/1/20 5:37 下午
 */
public class EnemyGoblin extends EnemyBase implements IAttackSkill {

    public EnemyGoblin() {
        super(
                LifeBase.new_(100, 100),
                LevelBase.new_(1, null),
                AttackDamageBase.new_(10, 0.5F, 2.0F, 0, 0.0F),
                null,
                ResistanceBase.new_(0, 0),
                DroppingBase.new_(5, 1, null)
        );
    }

    @Override
    public Object runDestroySkill() {
        return super.runDestroySkill();
    }

    @Override
    public Object runAttackSkill() {
        return null;
    }
}
