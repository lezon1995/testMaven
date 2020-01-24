package runes.domian.tower;

import runes.domian.base.AttackDamageBase;
import runes.domian.enemy.EnemyBase;
import runes.domian.base.LifeBase;
import runes.domian.base.ResistanceBase;
import runes.domian.equipment.EquipmentSlot;
import runes.domian.rune.RuneSlot;
import runes.domian.skill.AbstractHitCounter;
import runes.domian.skill.IActiveSkill;
import runes.domian.skill.IAttackSkill;
import runes.domian.skill.IPassiveSkill;
import runes.util.DamageUtil;
import runes.util.PositionUtil;


/**
 * 弓箭堡垒
 * 方式:弓箭
 * 攻击力:10
 * 护甲:10
 * 魔抗:0
 * 穿透:0
 * 射程:5米
 * 被动技能:每次攻击会提高5%的攻击速度 最多提高50%
 * 主动技能:蓄力射出一支强力的弓箭(攻速减少20%) 造成200% 如果暴击 则伤害提高100% 即最终造成(100%+100%)*200%=400%
 *
 * @author Wentworth .
 * @date 2020/1/20 3:26 下午
 */
public class ArrowFort extends TowerBase implements IAttackSkill, IPassiveSkill, IActiveSkill {
    public ArrowFort() {
        super(
                LifeBase.new_(100, 100),
                AttackDamageBase.new_(10, 1.0F, 5.0F, 0, 0.0F),
                ResistanceBase.new_(10, 0),
                RuneSlot.new_(),
                EquipmentSlot.new_()
        );

    }


    @Override
    public Object runPassiveSkill() {
        new Thread(() -> {
            this.attackDamage.hitCounter = new AbstractHitCounter() {
                @Override
                public Object count() {
                    if (hitCount >= 10) {
                        return null;
                    }
                    //攻击计数器累加
                    this.hitCount++;
                    //攻击速度提高5%
                    attackDamage.attackSpeed *= (1 + 0.05F);
                    return null;
                }
            };
        }).start();
        return null;
    }

    @Override
    public Object runAttackSkill() {
        //从敌人队列中取出一个敌人
        EnemyBase enemy = queue.poll();
        if (enemy == null) {
            return null;
        }
        currentAttackingQueue.offer(enemy);

        //当敌人在防御塔射程之内
        while (PositionUtil.distance(this, enemy) <= this.attackDamage.range) {
            //计算对敌人的伤害
            int damage = DamageUtil.calculateDamage(this, enemy);

            //敌人减少生命值
            enemy.life.healthPoint -= damage;

            //累加攻击计数器
            this.attackDamage.hitCounter.count();

            //如果生命值<=0 则代表敌人阵亡
            if (enemy.life.healthPoint <= 0) {
                enemy.runDestroySkill();
                break;
            }

            try {
                Thread.sleep((long) (this.attackDamage.attackInterval * 1000L));
            } catch (InterruptedException e) {
            }
        }

        return null;
    }

    @Override
    public Object runActiveSkill() {
        EnemyBase enemy = currentAttackingQueue.peek();
        if (enemy == null) {
            return null;
        }
        int damage = DamageUtil.calculateDamage(this, this.attackDamage.damage * 2, enemy);

        //敌人减少生命值
        enemy.life.healthPoint -= damage;

        //如果生命值<=0 则代表敌人阵亡
        if (enemy.life.healthPoint <= 0) {
            enemy.runDestroySkill();
        }

        return null;
    }

}
